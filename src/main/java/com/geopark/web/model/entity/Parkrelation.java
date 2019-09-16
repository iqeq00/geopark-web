package com.geopark.web.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 缔结姊妹公园
 * </p>
 *
 * @author lichee
 * @since 2019-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("parkrelation")
public class Parkrelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 地质公园ID
     */
    private Integer parkId;

    /**
     * 姊妹公园名称
     */
    private String parkName;

    /**
     * 地点
     */
    private String address;

    /**
     * 缔结时间
     */
    private String conclusionAt;

    /**
     * 双方代表
     */
    private String delegate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 照片
     */
    private String img;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    private LocalDateTime deletedAt;

}