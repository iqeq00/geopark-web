package com.geopark.web.service.impl;

import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geopark.framework.converter.BeanConverter;
import com.geopark.framework.enums.ErrorCodeEnum;
import com.geopark.framework.enums.StatusEnum;
import com.geopark.framework.utils.ApiAssert;
import com.geopark.framework.utils.JWTUtils;
import com.geopark.framework.utils.TypeUtils;
import com.geopark.web.mapper.SysUserMapper;
import com.geopark.web.model.entity.SysUser;
import com.geopark.web.model.entity.SysUserRole;
import com.geopark.web.model.vo.ResourcePermVo;
import com.geopark.web.model.vo.TokenVo;
import com.geopark.web.model.vo.UserDetailsVo;
import com.geopark.web.service.SysResourceService;
import com.geopark.web.service.SysUserRoleService;
import com.geopark.web.service.SysUserService;
import org.apache.commons.codec.digest.Md5Crypt;
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

    @Autowired
    private SysResourceService resourceService;

    @Override
    public List<Integer> getRoleIds(Integer uid) {

        LambdaQueryChainWrapper<SysUserRole> lambdaQueryChainWrapper = userRoleService.lambdaQuery();
        lambdaQueryChainWrapper.select(SysUserRole::getRoleId).eq(SysUserRole::getUid, uid);
        return userRoleService.listObjs(lambdaQueryChainWrapper, TypeUtils::castToInt);
    }

    @Override
    public SysUser login(String loginName, String password, String ipAddr) {
        SysUser user = lambdaQuery().eq(SysUser::getLoginName, loginName).one();
        //用户不存在
        ApiAssert.notNull(ErrorCodeEnum.USERNAME_OR_PASSWORD_IS_WRONG, user);
        //用户名密码错误
        ApiAssert.isTrue(ErrorCodeEnum.USERNAME_OR_PASSWORD_IS_WRONG, Md5Crypt.apr1Crypt(password, loginName).equals(user.getPassword()));
        //用户被禁用
        ApiAssert.isTrue(ErrorCodeEnum.USER_IS_DISABLED, StatusEnum.NORMAL.equals(user.getStatus()));
        user.setIp(ipAddr);
        updateById(user);
        return user;
    }

    @Override
    public TokenVo getToken(SysUser user) {
        Integer uid = user.getUid();
        TokenVo tokenVo = new TokenVo();
        tokenVo.setUid(uid);
        tokenVo.setToken(JWTUtils.generate(uid));
        return tokenVo;
    }

    @Override
    public UserDetailsVo getUserDetails(Integer uid) {
        SysUser user = getById(uid);
        ApiAssert.notNull(ErrorCodeEnum.USER_NOT_FOUND, user);
        UserDetailsVo userDetails = BeanConverter.convert(UserDetailsVo.class, user);
        userDetails.setPerms(resourceService.getUserPerms(uid));
        return userDetails;
    }
}
