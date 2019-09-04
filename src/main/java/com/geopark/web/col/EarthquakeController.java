package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Earthquake;
import com.geopark.web.service.EarthquakeService;
import com.geopark.web.service.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 地灾信息 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Slf4j
@RestController
@RequestMapping("/earthquake")
public class EarthquakeController extends SuperController {
    @Autowired
    private EarthquakeService earthquakeService;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("地灾信息查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Earthquake>> page(
            @RequestParam(value = "type", defaultValue = "") String type) {

        LambdaQueryChainWrapper<Earthquake> qw = earthquakeService.lambdaQuery();
        if (StringUtils.isNotBlank(type)) {
            qw.like(Earthquake::getType, type);
        }

        return success(qw.page(this.<Earthquake>getPage()));

    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("地灾信息添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Earthquake earthquake) {

        earthquakeService.save(earthquake);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("地灾信息编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Earthquake earthquake) {

        earthquake.setId(id);
        earthquakeService.updateById(earthquake);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("地灾信息删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        earthquakeService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
