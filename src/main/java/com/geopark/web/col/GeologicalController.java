package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Geological;
import com.geopark.web.service.GeologicalService;
import com.geopark.web.service.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 地质背景 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Slf4j
@RestController
@RequestMapping("/geological")
public class GeologicalController extends SuperController {
    @Autowired
    private GeologicalService geologicalService;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("地质背景查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Geological>> page(
            @RequestParam(value = "parkId", defaultValue = "") String parkId) {

        LambdaQueryChainWrapper<Geological> qw = geologicalService.lambdaQuery();
        if (StringUtils.isNotBlank(parkId)) {
            qw.like(Geological::getParkId, parkId);
        }

        return success(qw.page(this.<Geological>getPage()));

    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("地质背景添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Geological geological) {

        geologicalService.save(geological);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("地质背景编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Geological geological) {

        geological.setId(id);
        geologicalService.updateById(geological);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("地质背景删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        geologicalService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
