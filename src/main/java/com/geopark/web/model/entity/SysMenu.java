package com.geopark.web.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.geopark.framework.enums.MenuTypeEnum;
import com.geopark.framework.enums.StatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author lichee
 * @since 2019-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_menu")
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父菜单ID，一级菜单为0
     */
    private Integer parentId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 路径
     */
    private String path;

    /**
     * 类型:0:目录,1:菜单,2:按钮
     */
    private MenuTypeEnum menuType;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 创建者ID
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer createUid;

    /**
     * 修改者ID
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer updateUid;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 状态 0：禁用 1：正常
     */
    private StatusEnum status;

    /**
     * 路由
     */
    private String router;

    /**
     * 别名
     */
    private String alias;

    /**
     * 排序
     */
    private Integer sort;

}