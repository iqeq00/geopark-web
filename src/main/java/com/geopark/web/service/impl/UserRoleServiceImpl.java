package com.geopark.web.service.impl;

import com.geopark.web.model.entity.UserRole;
import com.geopark.web.mapper.UserRoleMapper;
import com.geopark.web.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户角色关系表 服务实现类
 * </p>
 *
 * @author lichee
 * @since 2019-07-18
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
