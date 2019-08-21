package com.geopark.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.geopark.web.model.entity.SysMenuResource;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 菜单资源关系表 服务类
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
public interface SysMenuResourceService extends IService<SysMenuResource> {

    /**
     * 获取菜单资源关系
     *
     * @param menuId
     * @param resourceIds
     */
    List<SysMenuResource> getMenuResources(Integer menuId, List<String> resourceIds);

    /**
     * 根据菜单ID删除资源关系记录
     *
     * @param menuId
     */
    void removeByMenuId(Integer menuId);
}
