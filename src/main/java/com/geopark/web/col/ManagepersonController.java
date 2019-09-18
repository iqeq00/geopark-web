package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Manageperson;
import com.geopark.web.service.ManagepersonService;
import com.geopark.web.service.SysResourceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 管理人员 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-09-17
 */
@RestController
@RequestMapping("/manageperson")
public class ManagepersonController extends SuperController {
    @Autowired
    private ManagepersonService managepersonService;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("管理人员查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Manageperson>> page(
            @RequestParam(value = "name", defaultValue = "") String name) {

        LambdaQueryChainWrapper<Manageperson> qw = managepersonService.lambdaQuery();
        if (StringUtils.isNotBlank(name)) {
            qw.like(Manageperson::getName, name);
        }

        return success(qw.page(this.<Manageperson>getPage()));

    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("管理人员添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Manageperson manageperson) {

        managepersonService.save(manageperson);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("管理人员编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Manageperson manageperson) {

        manageperson.setId(id);
        managepersonService.updateById(manageperson);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("管理人员删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        managepersonService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
