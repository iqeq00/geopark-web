package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Culturalsites;
import com.geopark.web.service.CulturalsitesService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 文物保护单位 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-11-22
 */
@Slf4j
@RestController
@RequestMapping("/culturalsites")
public class CulturalsitesController extends SuperController {

    @Autowired
    private CulturalsitesService culturalsitesService;

    @Resources
    @ApiOperation("文物保护单位查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Culturalsites>> page(
            @RequestParam(value = "sitename", defaultValue = "") String sitename) {

        LambdaQueryChainWrapper<Culturalsites> qw = culturalsitesService.lambdaQuery();
        if (StringUtils.isNotBlank(sitename)) {
            qw.like(Culturalsites::getSitename, sitename);
        }
        return success(qw.page(this.<Culturalsites>getPage()));
    }

    @Resources
    @ApiOperation("文物保护单位添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Culturalsites culturalsites) {

        culturalsitesService.save(culturalsites);
        return success(HttpStatus.CREATED);
    }

    @Resources
    @ApiOperation("文物保护单位编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Culturalsites culturalsites) {

        culturalsites.setId(id);
        culturalsitesService.updateById(culturalsites);
        return success();
    }

    @Resources
    @ApiOperation("文物保护单位删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        culturalsitesService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}