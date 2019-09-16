package com.geopark.web.col;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Parkmeeting;
import com.geopark.web.service.ParkmeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 会议 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@RestController
@RequestMapping("/parkmeeting")
public class ParkmeetingController extends SuperController {

    @Autowired
    private ParkmeetingService parkmeetingService;

    @Resources
    @ApiOperation("会议查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Parkmeeting>> page(
            @RequestParam(value = "parkId", required = false) Integer parkId) {

        LambdaQueryChainWrapper<Parkmeeting> lqcw = parkmeetingService.lambdaQuery();
        if(null != parkId) {
            lqcw.eq(Parkmeeting::getParkId, parkId);
        }
        return success(lqcw.page(this.<Parkmeeting>getPage()));
    }

    @Resources
    @ApiOperation("会议添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Parkmeeting parkmeeting) {

        parkmeetingService.save(parkmeeting);
        return success(HttpStatus.CREATED);
    }

    @Resources
    @ApiOperation("会议编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Parkmeeting parkmeeting) {

        parkmeeting.setId(id);
        parkmeetingService.updateById(parkmeeting);
        return success();
    }

    @Resources
    @ApiOperation("会议删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        parkmeetingService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}