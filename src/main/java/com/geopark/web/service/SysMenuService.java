package com.geopark.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.geopark.web.model.entity.SysMenu;
import com.geopark.web.model.vo.MenuTreeVo;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 获取用户权限菜单
     *
     * @param uid
     * @return
     */
    List<MenuTreeVo> getUserPermMenus(Integer uid);
}