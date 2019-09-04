package com.geopark.web.col;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Production;
import com.geopark.web.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 产品推介 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@RestController
@RequestMapping("/production")
public class ProductionController extends SuperController {

    @Autowired
    private ProductionService productionService;

    @Resources
    @ApiOperation("产品推介查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Production>> page(
            @RequestParam(value = "parkId", required = false) Integer parkId) {

        LambdaQueryChainWrapper<Production> lqcw = productionService.lambdaQuery();
        if(null != parkId) {
            lqcw.eq(Production::getParkId, parkId);
        }
        return success(lqcw.page(this.<Production>getPage()));
    }

    @Resources
    @ApiOperation("产品推介添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Production production) {

        productionService.save(production);
        return success(HttpStatus.CREATED);
    }

    @Resources
    @ApiOperation("产品推介编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Production production) {

        production.setId(id);
        productionService.updateById(production);
        return success();
    }

    @Resources
    @ApiOperation("产品推介删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        productionService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
