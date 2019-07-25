package com.geopark.web.model.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 菜单树DTO
 * </p>
 *
 * @author lichee
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MenuTreeVo extends TreeNode {

    private Integer id;
    private String menuName;
    private Integer menuType;
    private String router;
    private String path;
    private String icon;
    private String alias;
}
