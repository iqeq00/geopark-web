package com.geopark.web.col.sys;

import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.framework.utils.IpUtils;
import com.geopark.web.model.entity.SysUser;
import com.geopark.web.model.param.LoginPARM;
import com.geopark.web.model.vo.TokenVo;
import com.geopark.web.model.vo.UserDetailsVo;
import com.geopark.web.service.SysUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 账户 前端控制器
 * </p>
 *
 * @author lichee
 */
@RestController
@RequestMapping("/account")
@Validated
public class AccountRestController extends SuperController {

    @Autowired
    private SysUserService userService;

//    @Autowired
//    private IMenuService menuService;

    @Resources(AuthTypeEnum.OPEN)
    @ApiOperation("获取Token")
    @PostMapping("/token")
    public ApiResponses<TokenVo> getToken(@RequestBody @Validated LoginPARM loginPARM) {
        SysUser user = userService.login(loginPARM.getLoginName(), loginPARM.getPassword(), IpUtils.getIpAddr(request));
        TokenVo tokenVo = userService.getToken(user);
        return success(tokenVo);
    }

//    @Resources(auth = AuthTypeEnum.LOGIN)
//    @ApiOperation("清除Token")
//    @DeleteMapping("/token")
//    public ApiResponses<Void> removeToken() {
//        return success(HttpStatus.NO_CONTENT);
//    }
//
//    @Resources(auth = AuthTypeEnum.LOGIN)
//    @ApiOperation("修改密码")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "oldPassword", value = "原密码", required = true, dataType = "String"),
//            @ApiImplicitParam(name = "newPassword", value = "新密码", required = true, dataType = "String"),
//    })
//    @PutMapping("/password")
//    public ApiResponses<Void> updatePassword(@RequestBody @Validated PasswordPARM passwordPARM) {
//        userService.updatePassword(currentUid(), passwordPARM.getOldPassword(), passwordPARM.getNewPassword());
//        return success();
//    }
//
    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("获取账户详情")
    @GetMapping("/info")
    public ApiResponses<UserDetailsVo> accountInfo() {
        Integer uid = currentUid();
        UserDetailsVo userDetails = userService.getUserDetails(uid);
        return success(userDetails);
    }
//
//    @Resources(auth = AuthTypeEnum.LOGIN)
//    @ApiOperation("修改账户信息")
//    @PutMapping("/info")
//    public ApiResponses<Void> accountInfo(@RequestBody @Validated AccountInfoPARM accountInfoPARM) {
//        Integer uid = currentUid();
//        User user = accountInfoPARM.convert(User.class);
//        user.setId(uid);
//        userService.updateById(user);
//        return success();
//    }
//
//    @Resources(auth = AuthTypeEnum.LOGIN)
//    @ApiOperation("获取账户菜单")
//    @GetMapping("/menus")
//    public ApiResponses<List<MenuTreeDTO>> menus() {
//        List<MenuTreeDTO> menuTrees = menuService.getUserPermMenus(currentUid());
//        return success(menuTrees);
//    }
//
//    @Resources(auth = AuthTypeEnum.LOGIN)
//    @ApiOperation("获取账户按钮")
//    @GetMapping("/buttons/aliases")
//    public ApiResponses<Set<String>> buttonsAliases() {
//        return success(menuService.getUserPermButtonAliases(currentUid()));
//    }
}

