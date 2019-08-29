package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Park;
import com.geopark.web.service.ParkService;
import com.geopark.web.service.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 公园概况 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Slf4j
@RestController
@RequestMapping("/park")
public class ParkController extends SuperController {
    @Autowired
    private ParkService parkService;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("公园查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Park>> page(
            @RequestParam(value = "name", defaultValue = "") String name) {

        LambdaQueryChainWrapper<Park> qw = parkService.lambdaQuery();
        if (StringUtils.isNotBlank(name)) {
            qw.like(Park::getName, name);
        }

        return success(qw.page(this.<Park>getPage()));

    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("公园添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Park park) {

        parkService.save(park);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("公园编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Park park) {

        park.setId(id);
        parkService.updateById(park);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("公园删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        parkService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
