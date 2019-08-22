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
import com.geopark.web.model.entity.SysRoleMenu;
import com.geopark.web.model.entity.SysUser;
import com.geopark.web.model.entity.SysUserRole;
import com.geopark.web.model.vo.ResourcePermVo;
import com.geopark.web.model.vo.TokenVo;
import com.geopark.web.model.vo.UserDetailsVo;
import com.geopark.web.service.SysResourceService;
import com.geopark.web.service.SysUserRoleService;
import com.geopark.web.service.SysUserService;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        List<SysUserRole> list = userRoleService.lambdaQuery().select(SysUserRole::getRoleId).eq(SysUserRole::getUid, uid).list();
        List<Integer> ids = new ArrayList<>();
        list.forEach(val -> {
            ids.add(val.getRoleId());
        });
        return ids;
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
        Integer uid = user.getId();
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

    @Override
    @Transactional
    public void saveUserRoles(Integer uid, List<Integer> roleIds) {
        if (CollectionUtils.isNotEmpty(roleIds)) {
            List<SysUserRole> list = userRoleService.lambdaQuery().eq(SysUserRole::getUid, uid).list();
            List<Integer> ids = new ArrayList<>();
            list.forEach(val -> {
                ids.add(val.getId());
            });
            if(ids.size() > 0) {
                removeByIds(ids);
            }
            userRoleService.saveBatch(roleIds.stream().map(e -> new SysUserRole(uid, e)).collect(Collectors.toList()));
        }
    }

    @Override
    @Transactional
    public void updateStatus(Integer uid, StatusEnum status) {
        SysUser user = getById(uid);
        ApiAssert.notNull(ErrorCodeEnum.USER_NOT_FOUND, user);
        user.setStatus(status);
        updateById(user);
    }

    @Override
    @Transactional
    public void resetPwd(Integer uid) {
        SysUser user = getById(uid);
        ApiAssert.notNull(ErrorCodeEnum.USER_NOT_FOUND, user);
        user.setPassword(Md5Crypt.apr1Crypt(user.getLoginName(), user.getLoginName()));
        updateById(user);
    }
}
