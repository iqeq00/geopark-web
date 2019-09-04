package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Sampling;
import com.geopark.web.service.SamplingService;
import com.geopark.web.service.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 采样信息 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Slf4j
@RestController
@RequestMapping("/sampling")
public class SamplingController extends SuperController {
    @Autowired
    private SamplingService samplingService;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("采样信息查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Sampling>> page(
            @RequestParam(value = "samplenumber", defaultValue = "") String samplenumber) {

        LambdaQueryChainWrapper<Sampling> qw = samplingService.lambdaQuery();
        if (StringUtils.isNotBlank(samplenumber)) {
            qw.like(Sampling::getSamplenumber, samplenumber);
        }

        return success(qw.page(this.<Sampling>getPage()));

    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("采样信息添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Sampling sampling) {

        samplingService.save(sampling);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("采样信息编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Sampling sampling) {

        sampling.setId(id);
        samplingService.updateById(sampling);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("采样信息删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        samplingService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
