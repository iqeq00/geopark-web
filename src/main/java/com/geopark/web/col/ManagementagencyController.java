package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Managementagency;
import com.geopark.web.service.ManagementagencyService;
import com.geopark.web.service.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 管理机构 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Slf4j
@RestController
@RequestMapping("/managementagency")
public class ManagementagencyController extends SuperController {
    @Autowired
    private ManagementagencyService managementagencyService;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("管理机构查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Managementagency>> page(
            @RequestParam(value = "managename", defaultValue = "") String managename) {

        LambdaQueryChainWrapper<Managementagency> qw = managementagencyService.lambdaQuery();
        if (StringUtils.isNotBlank(managename)) {
            qw.like(Managementagency::getManagename, managename);
        }
        return success(qw.page(this.<Managementagency>getPage()));
    }

    @Resources
    @ApiOperation("管理机构查询(列表)")
    @GetMapping("/list")
    public ApiResponses<List<Managementagency>> list() {

        return success(managementagencyService.lambdaQuery().list());
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("管理机构添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Managementagency managementagency) {

        managementagencyService.save(managementagency);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("管理机构编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Managementagency managementagency) {

        managementagency.setId(id);
        managementagencyService.updateById(managementagency);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("管理机构删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        managementagencyService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
