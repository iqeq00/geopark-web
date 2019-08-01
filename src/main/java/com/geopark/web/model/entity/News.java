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
 * 新闻通讯
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("news")
public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 本地文章
     */
    private String isLocale;

    /**
     * 地质公园ID
     */
    private Integer parkId;

    /**
     * 通讯稿名称
     */
    private String lettername;

    /**
     * 发布时间
     */
    private String releasetime;

    /**
     * 作者
     */
    private String auther;

    /**
     * 正文
     */
    private String content;

    /**
     * 发布的网站
     */
    private String releasewebsite;

    /**
     * 内容摘要
     */
    private String contentsummary;

    /**
     * 备注
     */
    private String note;

    private LocalDateTime deletedAt;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    public static final String ID = "id";

    public static final String IS_LOCALE = "is_locale";

    public static final String PARK_ID = "park_id";

    public static final String LETTERNAME = "lettername";

    public static final String RELEASETIME = "releasetime";

    public static final String AUTHER = "auther";

    public static final String CONTENT = "content";

    public static final String RELEASEWEBSITE = "releasewebsite";

    public static final String CONTENTSUMMARY = "contentsummary";

    public static final String NOTE = "note";

    public static final String DELETED_AT = "deleted_at";

    public static final String CREATED_AT = "created_at";

    public static final String UPDATED_AT = "updated_at";

}
