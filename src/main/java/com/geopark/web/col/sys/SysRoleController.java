package com.geopark.web.col.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.SysRole;
import com.geopark.web.model.param.RolePARM;
import com.geopark.web.model.vo.RoleVo;
import com.geopark.web.service.SysResourceService;
import com.geopark.web.service.SysRoleMenuService;
import com.geopark.web.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@RestController
@RequestMapping("/role")
public class SysRoleController extends SuperController {

    @Autowired
    private SysRoleService roleService;

    @Autowired
    private SysRoleMenuService roleMenuService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("查询所有角色(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<RoleVo>> page(@RequestParam(value = "roleName", required = false) String roleName) {

        return success(roleService.pageRoleVo(this.<SysRole>getPage(), roleName));
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("添加角色")
    @PostMapping
    public ApiResponses<Void> create(@RequestBody @Validated(RolePARM.Create.class) RolePARM rolePARM) {

        SysRole role = rolePARM.convert(SysRole.class);
        role.setCreateUid(currentUid());
        role.setCreateTime(LocalDateTime.now());
        role.setUpdateUid(currentUid());
        role.setUpdateTime(LocalDateTime.now());
        roleService.save(role);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("修改角色")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody @Validated(RolePARM.Update.class) RolePARM rolePARM) {

        SysRole role = rolePARM.convert(SysRole.class);
        role.setId(id);
        role.setUpdateUid(currentUid());
        role.setUpdateTime(LocalDateTime.now());
        roleService.updateById(role);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("删除角色")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {
        roleService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }


    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation(value = "修改角色菜单")
    @PutMapping("/{id}/menu")
    public ApiResponses<Void> menu(@PathVariable("id") Integer id, @RequestBody @NotEmpty(message = "菜单ID不能为空") List<Integer> menuIds) {

        roleMenuService.saveRoleMenu(id, menuIds);
        return success();
    }

}