package com.geopark.web.service.impl;

import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geopark.framework.utils.TypeUtils;
import com.geopark.web.mapper.SysUserMapper;
import com.geopark.web.model.entity.SysUser;
import com.geopark.web.model.entity.SysUserRole;
import com.geopark.web.service.SysUserRoleService;
import com.geopark.web.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserRoleService userRoleService;

    @Override
    public List<Integer> getRoleIds(Integer uid) {

        LambdaQueryChainWrapper<SysUserRole> lambdaQueryChainWrapper = userRoleService.lambdaQuery();
        lambdaQueryChainWrapper.select(SysUserRole::getRoleId).eq(SysUserRole::getUid, uid);
        return userRoleService.listObjs(lambdaQueryChainWrapper, TypeUtils::castToInt);
    }
}
