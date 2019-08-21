package com.geopark.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.geopark.web.model.entity.SysRoleMenu;

import java.util.List;

/**
 * <p>
 * 角色菜单关系表 服务类
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {

    /**
     * 保存角色菜单关系
     *
     * @param roleId
     * @param menuIds
     */
    void saveRoleMenu(Integer roleId, List<Integer> menuIds);
}
