package com.geopark.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.geopark.web.model.entity.SysUser;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 根据用户ID获取角色
     *
     * @param id
     * @return
     */
    List<Integer> getRoleIds(Integer id);
}
