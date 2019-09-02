package com.geopark.web.col;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Parkinfo;
import com.geopark.web.service.ParkinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 公园信息管理 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@RestController
@RequestMapping("/parkinfo")
public class ParkinfoController extends SuperController {

    @Autowired
    private ParkinfoService parkinfoService;

    @Resources
    @ApiOperation("公园信息查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Parkinfo>> page(
            @RequestParam(value = "parkId", required = false) Integer parkId) {

        LambdaQueryChainWrapper<Parkinfo> lqcw = parkinfoService.lambdaQuery();
        if(null != parkId) {
            lqcw.eq(Parkinfo::getParkId, parkId);
        }
        return success(lqcw.page(this.<Parkinfo>getPage()));
    }

    @Resources
    @ApiOperation("公园信息添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Parkinfo parkinfo) {

        parkinfoService.save(parkinfo);
        return success(HttpStatus.CREATED);
    }

    @Resources
    @ApiOperation("公园信息编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Parkinfo parkinfo) {

        parkinfo.setId(id);
        parkinfoService.updateById(parkinfo);
        return success();
    }

    @Resources
    @ApiOperation("公园信息删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        parkinfoService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
