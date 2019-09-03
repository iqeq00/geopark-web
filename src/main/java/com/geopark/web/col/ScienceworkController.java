package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Sciencework;
import com.geopark.web.service.ScienceworkService;
import com.geopark.web.service.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 科普作品 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Slf4j
@RestController
@RequestMapping("/sciencework")
public class ScienceworkController extends SuperController {
    @Autowired
    private ScienceworkService scienceworkService;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("科普作品查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Sciencework>> page(
            @RequestParam(value = "scienceitem", defaultValue = "") String scienceitem) {

        LambdaQueryChainWrapper<Sciencework> qw = scienceworkService.lambdaQuery();
        if (StringUtils.isNotBlank(scienceitem)) {
            qw.like(Sciencework::getScienceitem, scienceitem);
        }

        return success(qw.page(this.<Sciencework>getPage()));

    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("科普作品添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Sciencework sciencework) {

        scienceworkService.save(sciencework);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("科普作品编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Sciencework sciencework) {

        sciencework.setId(id);
        scienceworkService.updateById(sciencework);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("科普作品删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        scienceworkService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
