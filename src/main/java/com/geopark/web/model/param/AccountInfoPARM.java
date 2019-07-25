package com.geopark.web.model.param;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 用户信息 PARM
 * </p>
 *
 * @author lichee
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AccountInfoPARM {

    private static final long serialVersionUID = 1L;

    @NotBlank(groups = Update.class, message = "昵称不能为空")
    private String nickname;

    private String email;

    private String phone;

    public interface Update {

    }

}
