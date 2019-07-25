package com.geopark.web.model.param;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 登陆参数
 * </p>
 *
 * @author lichee
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class LoginPARM {

    @NotBlank(message = "用户名不能为空！")
    private String loginName;
    @NotBlank(message = "密码不能为空！")
    private String password;

}
