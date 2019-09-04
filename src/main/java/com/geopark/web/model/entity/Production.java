package com.geopark.web.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 产品推介
 * </p>
 *
 * @author lichee
 * @since 2019-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("production")
public class Production implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 公园ID
     */
    private Integer parkId;

    /**
     * 推介会名称
     */
    private String promotionname;

    /**
     * 地点
     */
    private String position;

    /**
     * 时间
     */
    private String time;

    /**
     * 参加代表
     */
    private String representative;

    /**
     * 推介内容
     */
    private String promotioncontent;

    /**
     * 备注
     */
    private String note;

    /**
     * 照片
     */
    private String img;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    private LocalDateTime deletedAt;


    public static final String ID = "id";

    public static final String PARK_ID = "park_id";

    public static final String PROMOTIONNAME = "promotionname";

    public static final String POSITION = "position";

    public static final String TIME = "time";

    public static final String REPRESENTATIVE = "representative";

    public static final String PROMOTIONCONTENT = "promotioncontent";

    public static final String NOTE = "note";

    public static final String IMG = "img";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String DELETED_AT = "deleted_at";

}
