package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Planning;
import com.geopark.web.service.PlanningService;
import com.geopark.web.service.SysResourceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 公园规划 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-09-20
 */
@RestController
@RequestMapping("/planning")
public class PlanningController extends SuperController {

    @Autowired
    private PlanningService planningService;

    @Resources
    @ApiOperation("公园规划查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Planning>> page(
            @RequestParam(value = "filename", defaultValue = "") String filename) {

        LambdaQueryChainWrapper<Planning> qw = planningService.lambdaQuery();
        if (StringUtils.isNotBlank(filename)) {
            qw.like(Planning::getFilename, filename);
        }

        return success(qw.page(this.<Planning>getPage()));

    }

    @Resources
    @ApiOperation("公园规划添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Planning planning) {

        planningService.save(planning);
        return success(HttpStatus.CREATED);
    }

    @Resources
    @ApiOperation("公园规划编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Planning planning) {

        planning.setId(id);
        planningService.updateById(planning);
        return success();
    }

    @Resources
    @ApiOperation("公园规划删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        planningService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
