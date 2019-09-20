package com.geopark.web.col.open;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Geolandscape;
import com.geopark.web.model.entity.Humanlandscape;
import com.geopark.web.model.entity.Naturallandscape;
import com.geopark.web.service.GeolandscapeService;
import com.geopark.web.service.HumanlandscapeService;
import com.geopark.web.service.NaturallandscapeService;
import com.geopark.web.service.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 地质遗迹景点 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Slf4j
@RestController
@RequestMapping("/openApi")
public class OpenApiController extends SuperController {

    @Autowired
    private GeolandscapeService geolandscapeService;

    @Autowired
    private HumanlandscapeService humanlandscapeService;

    @Autowired
    private NaturallandscapeService naturallandscapeService;

    @Resources(AuthTypeEnum.OPEN)
    @ApiOperation("openApi地质遗迹景观列表")
    @GetMapping("/geolandscapeList")
    public ApiResponses<List<Geolandscape>> geolandscapeList(Integer parkId) {

        LambdaQueryChainWrapper<Geolandscape> qw = geolandscapeService.lambdaQuery();
        if (null != parkId) {
            qw.like(Geolandscape::getParkId, parkId);
        }
        return success(qw.list());
    }

    @Resources(AuthTypeEnum.OPEN)
    @ApiOperation("openApi地质遗迹景观详情")
    @GetMapping("/geolandscapeInfo")
    public ApiResponses<Geolandscape> geolandscapeInfo(Integer id) {

        return success(geolandscapeService.getById(id));
    }

    @Resources(AuthTypeEnum.OPEN)
    @ApiOperation("openApi人文景观列表")
    @GetMapping("/humanlandscapeList")
    public ApiResponses<List<Humanlandscape>> humanlandscapeList(Integer parkId) {

        LambdaQueryChainWrapper<Humanlandscape> qw = humanlandscapeService.lambdaQuery();
        if (null != parkId) {
            qw.like(Humanlandscape::getParkId, parkId);
        }
        return success(qw.list());
    }

    @Resources(AuthTypeEnum.OPEN)
    @ApiOperation("openApi人文景观详情")
    @GetMapping("/humanlandscapeInfo")
    public ApiResponses<Humanlandscape> humanlandscapeInfo(Integer id) {

        return success(humanlandscapeService.getById(id));
    }

    @Resources(AuthTypeEnum.OPEN)
    @ApiOperation("openApi自然景观列表")
    @GetMapping("/naturallandscapeList")
    public ApiResponses<List<Naturallandscape>> naturallandscapeList(Integer parkId) {

        LambdaQueryChainWrapper<Naturallandscape> qw = naturallandscapeService.lambdaQuery();
        if (null != parkId) {
            qw.like(Naturallandscape::getParkId, parkId);
        }
        return success(qw.list());
    }

    @Resources(AuthTypeEnum.OPEN)
    @ApiOperation("openApi自然景观详情")
    @GetMapping("/naturallandscapeInfo")
    public ApiResponses<Naturallandscape> naturallandscapeInfo(Integer id) {

        return success(naturallandscapeService.getById(id));
    }
}