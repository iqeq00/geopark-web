package com.geopark.web.model.param;

import com.geopark.framework.cons.Regex;
import com.geopark.framework.enums.StatusEnum;
import com.geopark.framework.model.Convert;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.List;

/**
 * <p>
 * 用户PARM
 * </p>
 *
 * @author lichee
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserPARM extends Convert {

    private static final long serialVersionUID = 1L;

    @NotBlank(groups = {Create.class, Update.class}, message = "用户名不能为空")
    private String loginName;
    private String password;
    @NotBlank(groups = {Create.class, Update.class}, message = "昵称不能为空")
    private String nickname;
    @Email(groups = {Create.class, Update.class}, message = "邮箱格式不正确")
    private String email;
    @Pattern(groups = {Create.class, Update.class}, regexp = Regex.PHONE, message = "手机号码格式不正确")
    private String phone;
    @NotNull(groups = Status.class, message = "用户状态不能为空")
    private StatusEnum status;
    @NotEmpty(groups = {Create.class, Update.class}, message = "用户角色不能为空")
    private List<Integer> roleIds;

    public interface Create {

    }

    public interface Update {

    }

    public interface Status {

    }

}