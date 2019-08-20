package com.geopark.web.col.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.cpt.ScanMappings;
import com.geopark.web.model.entity.SysResource;
import com.geopark.web.service.SysResourceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * <p>
 * 资源表 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@RestController
@RequestMapping("/resource")
public class SysResourceController extends SuperController {

    @Autowired
    private SysResourceService resourceService;

    @Autowired
    private ScanMappings scanMappings;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("查询所有资源(分页)")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "resourceName", value = "需要查询的资源名", paramType = "query"),
//            @ApiImplicitParam(name = "method", value = "需要查询的请求方式", paramType = "query"),
//            @ApiImplicitParam(name = "authType", value = "权限认证类型", paramType = "query")
//    })
    @GetMapping("/page")
    public ApiResponses<IPage<SysResource>> page(
            @RequestParam(value = "resourceName", required = false) String resourceName,
            @RequestParam(value = "method", required = false) String method,
            @RequestParam(value = "authType", required = false) AuthTypeEnum authType) {

        return success(resourceService.lambdaQuery()
                .like(StringUtils.isNotEmpty(resourceName), SysResource::getResourceName, resourceName)
                .eq(StringUtils.isNotEmpty(method), SysResource::getMethod, method)
                .eq(Objects.nonNull(authType), SysResource::getAuthType, authType)
                .page(this.<SysResource>getPage()));
    }


    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("刷新资源")
    @PutMapping
    public ApiResponses<Void> refresh() {

        scanMappings.doScan();
        return success();
    }
}
