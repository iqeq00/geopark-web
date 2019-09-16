package com.geopark.web.col;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Parkrelation;
import com.geopark.web.service.ParkrelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 缔结姊妹公园 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@RestController
@RequestMapping("/parkrelation")
public class ParkrelationController extends SuperController {

    @Autowired
    private ParkrelationService parkrelationService;

    @Resources
    @ApiOperation("缔结姊妹公园查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Parkrelation>> page(
            @RequestParam(value = "parkId", required = false) Integer parkId) {

        LambdaQueryChainWrapper<Parkrelation> lqcw = parkrelationService.lambdaQuery();
        if(null != parkId) {
            lqcw.eq(Parkrelation::getParkId, parkId);
        }
        return success(lqcw.page(this.<Parkrelation>getPage()));
    }

    @Resources
    @ApiOperation("缔结姊妹公园添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Parkrelation parkrelation) {

        parkrelationService.save(parkrelation);
        return success(HttpStatus.CREATED);
    }

    @Resources
    @ApiOperation("缔结姊妹公园编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Parkrelation parkrelation) {

        parkrelation.setId(id);
        parkrelationService.updateById(parkrelation);
        return success();
    }

    @Resources
    @ApiOperation("缔结姊妹公园删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        parkrelationService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}