package com.geopark.web.col.sys;

import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.converter.BeanConverter;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.enums.MenuTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.SysMenu;
import com.geopark.web.model.param.MenuPARM;
import com.geopark.web.model.vo.ComboVo;
import com.geopark.web.model.vo.MenuVo;
import com.geopark.web.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;

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
    @ApiOperation("查询父级菜单(下拉框)")
    @GetMapping("/combos")
    public ApiResponses<List<ComboVo>> combos() {

        LambdaQueryChainWrapper<SysMenu> lqcw = menuService.lambdaQuery().select(SysMenu::getId, SysMenu::getMenuName)
                .in(SysMenu::getMenuType, MenuTypeEnum.CATALOG, MenuTypeEnum.MENU);

//        menuService.listObjs(lqcw, );
//        List<ComboVo> list = menuService.listObjs(lqcw, menu -> {
//            ComboVo combo = new ComboVo();
//            combo.setId(menu.getId());
//            combo.setName(menu.getMenuName());
//            return combo;
//        });
//        return success(list);
        return null;
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("查询单个菜单")
    @GetMapping("/{id}")
    public ApiResponses<MenuVo> get(@PathVariable("id") Integer id) {

        return success(menuService.getMenuVoDetails(id));
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("设置菜单状态")
    @PutMapping("/{id}/status")
    public ApiResponses<Void> updateStatus(@PathVariable("id") Integer id, @RequestBody @Validated(MenuPARM.Status.class) MenuPARM menuPARM) {

        menuService.updateStatus(id, menuPARM.getStatus());
        return success();
    }
}
