package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Museum;
import com.geopark.web.service.MuseumService;
import com.geopark.web.service.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 博物馆基本情况 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Slf4j
@RestController
@RequestMapping("/museum")
public class MuseumController extends SuperController {
    @Autowired
    private MuseumService museumService;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("博物馆基本情况查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Museum>> page(
            @RequestParam(value = "museumname", defaultValue = "") String museumname) {

        LambdaQueryChainWrapper<Museum> qw = museumService.lambdaQuery();
        if (StringUtils.isNotBlank(museumname)) {
            qw.like(Museum::getMuseumname, museumname);
        }

        return success(qw.page(this.<Museum>getPage()));

    }

    @Resources
    @ApiOperation("博物馆查询(列表)")
    @GetMapping("/list")
    public ApiResponses<List<Museum>> list() {

        return success(museumService.lambdaQuery().list());
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("博物馆基本情况添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Museum museum) {

        museumService.save(museum);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("博物馆基本情况编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Museum museum) {

        museum.setId(id);
        museumService.updateById(museum);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("博物馆基本情况删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        museumService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
