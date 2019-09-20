package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Geolandscape;
import com.geopark.web.service.GeolandscapeService;
import com.geopark.web.service.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/geolandscape")
public class GeolandscapeController extends SuperController {
    @Autowired
    private GeolandscapeService geolandscapeService;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("地质遗迹景观查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Geolandscape>> page(
            @RequestParam(value = "gname", defaultValue = "") String gname) {

        LambdaQueryChainWrapper<Geolandscape> qw = geolandscapeService.lambdaQuery();
        if (StringUtils.isNotBlank(gname)) {
            qw.like(Geolandscape::getGname, gname);
        }

        return success(qw.page(this.<Geolandscape>getPage()));

    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("地质遗迹景观添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Geolandscape geolandscape) {

        geolandscapeService.save(geolandscape);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("地质遗迹景观编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Geolandscape geolandscape) {

        geolandscape.setId(id);
        geolandscapeService.updateById(geolandscape);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("地质遗迹景观删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        geolandscapeService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
