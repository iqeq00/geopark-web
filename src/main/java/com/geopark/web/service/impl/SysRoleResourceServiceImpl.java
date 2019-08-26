package com.geopark.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geopark.web.mapper.SysRoleResourceMapper;
import com.geopark.web.model.entity.SysRoleResource;
import com.geopark.web.service.SysRoleResourceService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色资源关系表 服务实现类
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Service
public class SysRoleResourceServiceImpl extends ServiceImpl<SysRoleResourceMapper, SysRoleResource> implements SysRoleResourceService {

    @Override
    public void saveTransaction() {

        throw new RuntimeException("报错了");
    }
}
