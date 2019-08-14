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
 * 人文展品
 * </p>
 *
 * @author lichee
 * @since 2019-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("humenexhibit")
public class Humenexhibit implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 公园ID
     */
    private Integer parkId;

    /**
     * 标本编号
     */
    private String specimennumber;

    /**
     * 标本名称
     */
    private String specimenname;

    /**
     * 馆内编号
     */
    private String hallnumber;

    /**
     * 标本类型
     */
    private String specimentype;

    /**
     * 标本来源
     */
    private String specimensource;

    /**
     * 收藏数量
     */
    private String collectionnumber;

    /**
     * 保存状态
     */
    private String savestate;

    /**
     * 特征描述
     */
    private String featuredescription;

    /**
     * 附注
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

    public static final String SPECIMENNUMBER = "specimennumber";

    public static final String SPECIMENNAME = "specimenname";

    public static final String HALLNUMBER = "hallnumber";

    public static final String SPECIMENTYPE = "specimentype";

    public static final String SPECIMENSOURCE = "specimensource";

    public static final String COLLECTIONNUMBER = "collectionnumber";

    public static final String SAVESTATE = "savestate";

    public static final String FEATUREDESCRIPTION = "featuredescription";

    public static final String NOTE = "note";

    public static final String IMG = "img";

    public static final String CREATED_AT = "created_at";

    public static final String UPDATED_AT = "updated_at";

    public static final String DELETED_AT = "deleted_at";

}
