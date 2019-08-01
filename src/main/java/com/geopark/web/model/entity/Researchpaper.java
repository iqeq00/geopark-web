package com.geopark.web.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 科普活动
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("researchpaper")
public class Researchpaper implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 地质公园编号
     */
    private Integer parkId;

    /**
     * 活动名称
     */
    private String activityname;

    /**
     * 时间
     */
    private String time;

    /**
     * 地点
     */
    private String position;

    /**
     * 科普对象
     */
    private String scienceobject;

    /**
     * 科普内容
     */
    private String sciencecontent;

    /**
     * 科普工作人员
     */
    private String sciencestaff;

    /**
     * 备注
     */
    private String note;

    /**
     * 照片
     */
    private String img;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;


    public static final String ID = "id";

    public static final String PARK_ID = "park_id";

    public static final String ACTIVITYNAME = "activityname";

    public static final String TIME = "time";

    public static final String POSITION = "position";

    public static final String SCIENCEOBJECT = "scienceobject";

    public static final String SCIENCECONTENT = "sciencecontent";

    public static final String SCIENCESTAFF = "sciencestaff";

    public static final String NOTE = "note";

    public static final String IMG = "img";

    public static final String CREATED_AT = "created_at";

    public static final String UPDATED_AT = "updated_at";

    public static final String DELETED_AT = "deleted_at";

}
