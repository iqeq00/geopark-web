package com.geopark.web.col;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Exchangeexhibition;
import com.geopark.web.service.ExchangeexhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 交流互展 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@RestController
@RequestMapping("/exchangeexhibition")
public class ExchangeexhibitionController extends SuperController {

    @Autowired
    private ExchangeexhibitionService exchangeexhibitionService;

    @Resources
    @ApiOperation("交流互展查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Exchangeexhibition>> page(
            @RequestParam(value = "parkId", required = false) Integer parkId) {

        LambdaQueryChainWrapper<Exchangeexhibition> lqcw = exchangeexhibitionService.lambdaQuery();
        if(null != parkId) {
            lqcw.eq(Exchangeexhibition::getParkId, parkId);
        }
        return success(lqcw.page(this.<Exchangeexhibition>getPage()));
    }

    @Resources
    @ApiOperation("交流互展添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Exchangeexhibition exchangeexhibition) {

        exchangeexhibitionService.save(exchangeexhibition);
        return success(HttpStatus.CREATED);
    }

    @Resources
    @ApiOperation("交流互展编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Exchangeexhibition exchangeexhibition) {

        exchangeexhibition.setId(id);
        exchangeexhibitionService.updateById(exchangeexhibition);
        return success();
    }

    @Resources
    @ApiOperation("交流互展删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        exchangeexhibitionService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}