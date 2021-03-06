package com.geopark.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.geopark.framework.enums.StatusEnum;
import com.geopark.web.model.entity.SysUser;
import com.geopark.web.model.vo.TokenVo;
import com.geopark.web.model.vo.UserDetailsVo;

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

    /**
     * 用户登陆
     *
     * @param loginName
     * @param password
     * @param ipAddr
     * @return
     */
    SysUser login(String loginName, String password, String ipAddr);

    /**
     * 通过用户对象获取token
     *
     * @param user
     * @return
     */
    TokenVo getToken(SysUser user);

    /**
     * 获取用户详情
     *
     * @param uid
     * @return
     */
    UserDetailsVo getUserDetails(Integer uid);

    /**
     * 添加用户角色
     *
     * @param id
     * @param roleIds
     */
    void saveUserRoles(Integer id, List<Integer> roleIds);

    /**
     * 设置用户状态
     *
     * @param uid
     * @param status
     */
    void updateStatus(Integer uid, StatusEnum status);

    /**
     * 重置用户密码
     *
     * @param id
     */
    void resetPwd(Integer id);

    /**
     * 用户修改密码
     *
     * @param uid
     * @param oldPassword
     * @param newPassword
     * @return
     */
    void updatePassword(Integer uid, String oldPassword, String newPassword);
}
