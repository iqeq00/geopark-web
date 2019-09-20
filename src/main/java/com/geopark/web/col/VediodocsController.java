package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Vediodocs;
import com.geopark.web.service.VediodocsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 影像资料 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-09-19
 */
@RestController
@RequestMapping("/vediodocs")
public class VediodocsController extends SuperController {

    @Autowired
    private VediodocsService vediodocsService;

    @Resources
    @ApiOperation("影像资料查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Vediodocs>> page(
            @RequestParam(value = "docname", defaultValue = "") String docname) {

        LambdaQueryChainWrapper<Vediodocs> qw = vediodocsService.lambdaQuery();
        if (StringUtils.isNotBlank(docname)) {
            qw.like(Vediodocs::getDocname, docname);
        }
        return success(qw.page(this.<Vediodocs>getPage()));
    }

    @Resources
    @ApiOperation("影像资料添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Vediodocs Vediodocs) {

        vediodocsService.save(Vediodocs);
        return success(HttpStatus.CREATED);
    }

    @Resources
    @ApiOperation("影像资料编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Vediodocs vediodocs) {

        vediodocs.setId(id);
        vediodocsService.updateById(vediodocs);
        return success();
    }

    @Resources
    @ApiOperation("影像资料删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        vediodocsService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
