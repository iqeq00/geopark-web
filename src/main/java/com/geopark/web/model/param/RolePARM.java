package com.geopark.web.model.param;

import com.geopark.framework.model.Convert;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author lichee
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RolePARM extends Convert {

    private static final long serialVersionUID = 1L;

    @NotBlank(groups = {Create.class, Update.class}, message = "角色名称不能为空")
    private String roleName;

    private String remark;

    public interface Create {

    }

    public interface Update {

    }
}
