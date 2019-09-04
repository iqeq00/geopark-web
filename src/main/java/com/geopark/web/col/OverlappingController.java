package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Overlapping;
import com.geopark.web.service.OverlappingService;
import com.geopark.web.service.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 与其他景区重叠情况 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Slf4j
@RestController
@RequestMapping("/overlapping")
public class OverlappingController extends SuperController {
    @Autowired
    private OverlappingService overlappingService ;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("重叠情况查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Overlapping>> page(
            @RequestParam(value = "othername", defaultValue = "") String othername) {

        LambdaQueryChainWrapper<Overlapping> qw = overlappingService.lambdaQuery();
        if (StringUtils.isNotBlank(othername)) {
            qw.like(Overlapping::getOthername, othername);
        }

        return success(qw.page(this.<Overlapping>getPage()));

    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("重叠情况添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Overlapping overlapping) {

        overlappingService.save(overlapping);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("重叠情况编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Overlapping overlapping) {

        overlapping.setId(id);
        overlappingService.updateById(overlapping);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("重叠情况删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        overlappingService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
