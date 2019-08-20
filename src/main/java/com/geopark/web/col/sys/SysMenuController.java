package com.geopark.web.col.sys;

import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.SysMenu;
import com.geopark.web.model.param.MenuPARM;
import com.geopark.web.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@RestController
@RequestMapping("/menu")
public class SysMenuController extends SuperController {

    @Autowired
    private SysMenuService menuService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("查询所有菜单")
    @GetMapping("/page")
    public ApiResponses<List<SysMenu>> list() {

        return success(menuService.list());
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("设置菜单状态")
    @PutMapping("/{id}/status")
    public ApiResponses<Void> updateStatus(@PathVariable("id") Integer id, @RequestBody @Validated(MenuPARM.Status.class) MenuPARM menuPARM) {

        menuService.updateStatus(id, menuPARM.getStatus());
        return success();
    }
}
