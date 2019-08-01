package com.geopark.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.web.model.entity.SysResource;
import com.geopark.web.model.vo.ResourcePermVo;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 资源表 服务类
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
public interface SysResourceService extends IService<SysResource> {

    /**
     * 获取某种请求方式资源权限
     *
     * @param method
     * @return
     */
    List<ResourcePermVo> getResourcePerms(String method);

    /**
     * 获取开放权限资源列表
     *
     * @return
     */
    List<ResourcePermVo> getOpenPerms();

    /**
     * 获取资源权限标记
     *
     * @param method
     * @param mapping
     * @return
     */
    String getResourcePermTag(String method, String mapping);

    /**
     * 获取指定类型权限资源列表
     *
     * @param authTypes 类型
     * @return
     */
    List<ResourcePermVo> getPerms(AuthTypeEnum... authTypes);

    /**
     * 获取用户所有权限
     *
     * @param id
     * @return
     */
    Set<ResourcePermVo> getUserResourcePerms(Integer id);


    /**
     * 获取用户菜单资源权限
     *
     * @param id
     * @return
     */
    List<ResourcePermVo> getUserMenuResourcePerms(Integer id);

    /**
     * 根据用户ID获取用户所有权限
     *
     * @param id
     * @return
     */
    List<String> getUserPerms(Integer id);
}
