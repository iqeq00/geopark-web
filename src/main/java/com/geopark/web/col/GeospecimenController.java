package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Geospecimen;
import com.geopark.web.service.GeospecimenService;
import com.geopark.web.service.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 地质标本 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Slf4j
@RestController
@RequestMapping("/geospecimen")
public class GeospecimenController extends SuperController {
    @Autowired
    private GeospecimenService geospecimenService;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("地质标本查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Geospecimen>> page(
            @RequestParam(value = "specimenname", defaultValue = "") String specimenname) {

        LambdaQueryChainWrapper<Geospecimen> qw = geospecimenService.lambdaQuery();
        if (StringUtils.isNotBlank(specimenname)) {
            qw.like(Geospecimen::getSpecimenname, specimenname);
        }

        return success(qw.page(this.<Geospecimen>getPage()));

    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("地质标本添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Geospecimen geospecimen) {

        geospecimenService.save(geospecimen);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("地质标本编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Geospecimen geospecimen) {

        geospecimen.setId(id);
        geospecimenService.updateById(geospecimen);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("地质标本删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        geospecimenService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
