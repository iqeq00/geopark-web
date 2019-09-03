package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Scienceactivity;
import com.geopark.web.service.ScienceactivityService;
import com.geopark.web.service.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 科普活动 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-08-29
 */
@Slf4j
@RestController
@RequestMapping("/scienceactivity")
public class ScienceactivityController extends SuperController {
    @Autowired
    private ScienceactivityService scienceactivityService;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("科普活动查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Scienceactivity>> page(
            @RequestParam(value = "activityname", defaultValue = "") String activityname) {

        LambdaQueryChainWrapper<Scienceactivity> qw = scienceactivityService.lambdaQuery();
        if (StringUtils.isNotBlank(activityname)) {
            qw.like(Scienceactivity::getActivityname, activityname);
        }

        return success(qw.page(this.<Scienceactivity>getPage()));

    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("科普活动添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Scienceactivity scienceactivity) {

        scienceactivityService.save(scienceactivity);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("科普活动编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Scienceactivity scienceactivity) {

        scienceactivity.setId(id);
        scienceactivityService.updateById(scienceactivity);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("科普活动删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        scienceactivityService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
