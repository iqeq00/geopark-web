package com.geopark.web.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 系统用户角色关系表
 * </p>
 *
 * @author lichee
 * @since 2019-08-14
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_role")
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    public SysUserRole(Integer uid, Integer roleId) {
        this.uid = uid;
        this.roleId = roleId;
    }

    public SysUserRole(Integer id, Integer uid, Integer roleId) {
        this.id = id;
        this.uid = uid;
        this.roleId = roleId;
    }

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    private Integer uid;

    /**
     * 角色ID
     */
    private Integer roleId;


    public static final String ID = "id";

    public static final String UID = "uid";

    public static final String ROLE_ID = "role_id";

}
