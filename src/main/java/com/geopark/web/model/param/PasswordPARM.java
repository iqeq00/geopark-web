package com.geopark.web.model.param;

import com.geopark.framework.model.Convert;
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
public class PasswordPARM extends Convert {

    @NotBlank(message = "原密码不能为空", groups = Update.class)
    private String oldPassword;
    @NotBlank(message = "新密码不能为空", groups = Update.class)
    private String newPassword;

    public interface Update {

    }
}
