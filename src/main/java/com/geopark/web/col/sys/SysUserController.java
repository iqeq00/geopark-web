package com.geopark.web.col.sys;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.converter.BeanConverter;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.enums.ErrorCodeEnum;
import com.geopark.framework.enums.StatusEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.framework.utils.ApiAssert;
import com.geopark.web.model.entity.SysUser;
import com.geopark.web.model.param.UserPARM;
import com.geopark.web.model.vo.UserVo;
import com.geopark.web.service.SysUserService;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@RestController
@RequestMapping("/user")
public class SysUserController extends SuperController {

    @Autowired
    private SysUserService userService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("查询所有用户")
    @GetMapping("/page")
    public ApiResponses<IPage<UserVo>> page(@RequestParam(value = "loginName", required = false) String loginName,
            @RequestParam(value = "nickname", required = false) String nickname,
            @RequestParam(value = "status", required = false) StatusEnum status) {

        return success(
                userService.lambdaQuery().like(StringUtils.isNotEmpty(loginName), SysUser::getLoginName, loginName)
                        .like(StringUtils.isNotEmpty(nickname), SysUser::getNickname, nickname)
                        .eq(Objects.nonNull(status), SysUser::getStatus, status)
                        .page(this.<SysUser>getPage())
                        .convert(e -> BeanConverter.convert(UserVo.class, e))
        );
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("查询单个用户")
    @GetMapping("/{id}")
    public ApiResponses<UserVo> get(@PathVariable("id") Integer id) {
        SysUser user = userService.getById(id);
        ApiAssert.notNull(ErrorCodeEnum.USER_NOT_FOUND, user);
        UserVo userVo = BeanConverter.convert(UserVo.class, user);
        List<Integer> roleIds = userService.getRoleIds(user.getId());
        userVo.setRoleIds(roleIds);
        return success(userVo);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("创建用户")
    @PostMapping
    public ApiResponses<Void> create(@RequestBody @Validated(UserPARM.Create.class) UserPARM userPARM) {

        int count = userService.lambdaQuery().eq(SysUser::getLoginName, userPARM.getLoginName()).count();
        ApiAssert.isTrue(ErrorCodeEnum.USERNAME_ALREADY_EXISTS, count == 0);
        SysUser user = userPARM.convert(SysUser.class);
        //没设置密码 设置默认密码
        if (StringUtils.isEmpty(user.getPassword())) {
            user.setPassword(Md5Crypt.apr1Crypt(user.getLoginName(), user.getLoginName()));
        } else {
            user.setPassword(Md5Crypt.apr1Crypt(user.getPassword(), user.getLoginName()));
        }
        //默认禁用
        user.setStatus(StatusEnum.DISABLE);
        user.setCreateUid(currentUid());
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userService.save(user);
        userService.saveUserRoles(user.getId(), userPARM.getRoleIds());
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("修改用户")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody @Validated(UserPARM.Update.class) UserPARM userPARM) {

        SysUser user = userPARM.convert(SysUser.class);
        user.setId(id);
        user.setUpdateTime(LocalDateTime.now());
        userService.updateById(user);
        userService.saveUserRoles(id, userPARM.getRoleIds());
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("删除用户")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {
        userService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("设置用户状态")
    @PutMapping("/{id}/status")
    public ApiResponses<Void> updateStatus(@PathVariable("id") Integer id, @RequestBody @Validated(UserPARM.Status.class) UserPARM userPARM) {

        userService.updateStatus(id, userPARM.getStatus());
        return success();
    }
}
