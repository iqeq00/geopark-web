package com.geopark.web.col.sys;

import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.converter.BeanConverter;
import com.geopark.framework.enums.MenuTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.SysMenu;
import com.geopark.web.model.param.MenuPARM;
import com.geopark.web.model.vo.ComboVo;
import com.geopark.web.model.vo.MenuVo;
import com.geopark.web.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Resources
    @ApiOperation("菜单查询(所有)")
    @GetMapping("/list")
    public ApiResponses<List<SysMenu>> list() {

        return success(menuService.list());
    }

    @Resources
    @ApiOperation("菜单父级查询(下拉框)")
    @GetMapping("/combos")
    public ApiResponses<List<ComboVo>> combos() {

        List<SysMenu> list = menuService.lambdaQuery().select(SysMenu::getId, SysMenu::getMenuName)
                .in(SysMenu::getMenuType, MenuTypeEnum.CATALOG, MenuTypeEnum.MENU).list();
        return success(BeanConverter.convert(ComboVo.class, list));
    }

    @Resources
    @ApiOperation("菜单详情")
    @GetMapping("/{id}")
    public ApiResponses<MenuVo> get(@PathVariable("id") Integer id) {

        return success(menuService.getMenuVoDetails(id));
    }

    @Resources
    @ApiOperation("菜单添加")
    @PostMapping
    public ApiResponses<Void> create(@RequestBody @Validated(MenuPARM.Create.class) MenuPARM menuPARM) {

        SysMenu menu = menuPARM.convert(SysMenu.class);
        menuService.saveMenu(menu, menuPARM.getResourceIds());
        return success(HttpStatus.CREATED);
    }

    @Resources
    @ApiOperation("菜单编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody @Validated(MenuPARM.Update.class) MenuPARM menuPARM) {

        SysMenu menu = menuPARM.convert(SysMenu.class);
        menu.setId(id);
        menuService.updateMenu(menu, menuPARM.getResourceIds());
        return success();
    }

    @Resources
    @ApiOperation("菜单删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        menuService.removeMenu(id);
        return success(HttpStatus.NO_CONTENT);
    }

    @Resources
    @ApiOperation("菜单状态设置")
    @PutMapping("/{id}/status")
    public ApiResponses<Void> updateStatus(@PathVariable("id") Integer id, @RequestBody @Validated(MenuPARM.Status.class) MenuPARM menuPARM) {

        menuService.updateStatus(id, menuPARM.getStatus());
        return success();
    }

}