package com.geopark.web.col;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Picdocs;
import com.geopark.web.service.PicdocsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 文件资料 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-09-19
 */
@RestController
@RequestMapping("/picdocs")
public class PicdocsController extends SuperController {

    @Autowired
    private PicdocsService picdocsService;

    @Resources
    @ApiOperation("图片资料查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Picdocs>> page(
            @RequestParam(value = "docname", defaultValue = "") String docname) {

        LambdaQueryChainWrapper<Picdocs> qw = picdocsService.lambdaQuery();
        if (StringUtils.isNotBlank(docname)) {
            qw.like(Picdocs::getDocname, docname);
        }
        return success(qw.page(this.<Picdocs>getPage()));
    }

    @Resources
    @ApiOperation("图片资料添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Picdocs Picdocs) {

        picdocsService.save(Picdocs);
        return success(HttpStatus.CREATED);
    }

    @Resources
    @ApiOperation("图片资料编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Picdocs picdocs) {

        picdocs.setId(id);
        picdocsService.updateById(picdocs);
        return success();
    }

    @Resources
    @ApiOperation("图片资料删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        picdocsService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
