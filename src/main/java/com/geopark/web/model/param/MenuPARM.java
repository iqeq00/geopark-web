package com.geopark.web.model.param;

import com.geopark.framework.enums.MenuTypeEnum;
import com.geopark.framework.enums.StatusEnum;
import com.geopark.framework.model.Convert;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author lichee
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MenuPARM extends Convert {

    private static final long serialVersionUID = 1L;

    @NotNull(groups = MenuPARM.Create.class, message = "父菜单不能为空")
    private Integer parentId;

    @NotBlank(groups = MenuPARM.Create.class, message = "菜单名称不能为空")
    private String menuName;

    private String path;

    private String router;

    @NotNull(groups = MenuPARM.Create.class, message = "类型不能为空")
    private MenuTypeEnum menuType;

    private String icon;

    private String alias;

    private Integer sort;

    @NotNull(groups = {MenuPARM.Create.class, MenuPARM.Status.class}, message = "状态不能为空")
    private StatusEnum status;

    private List<String> resourceIds;

    public interface Create {

    }

    public interface Update {

    }

    public interface Status {

    }
}
