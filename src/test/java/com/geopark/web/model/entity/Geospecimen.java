package com.geopark.web.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 地质标本
 * </p>
 *
 * @author lichee
 * @since 2019-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("geospecimen")
public class Geospecimen implements Serializable {

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
     * 野外编号
     */
    private String fieldnumber;

    /**
     * 馆内编号
     */
    private String hallnumber;

    /**
     * 英文或拉丁学名
     */
    private String englishlatin;

    /**
     * 标本类型
     */
    private String specimentype;

    /**
     * 采集位置
     */
    private String collectionposition;

    /**
     * 采集时间
     */
    private LocalDate collectiontime;

    /**
     * 采集人
     */
    private String collectionhuman;

    /**
     * 鉴定人
     */
    private String identificationhuman;

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
     * 备注
     */
    private String note;

    /**
     * 照片
     */
    private String img;


    public static final String ID = "id";

    public static final String PARK_ID = "park_id";

    public static final String SPECIMENNUMBER = "specimennumber";

    public static final String SPECIMENNAME = "specimenname";

    public static final String FIELDNUMBER = "fieldnumber";

    public static final String HALLNUMBER = "hallnumber";

    public static final String ENGLISHLATIN = "englishlatin";

    public static final String SPECIMENTYPE = "specimentype";

    public static final String COLLECTIONPOSITION = "collectionposition";

    public static final String COLLECTIONTIME = "collectiontime";

    public static final String COLLECTIONHUMAN = "collectionhuman";

    public static final String IDENTIFICATIONHUMAN = "identificationhuman";

    public static final String COLLECTIONNUMBER = "collectionnumber";

    public static final String SAVESTATE = "savestate";

    public static final String FEATUREDESCRIPTION = "featuredescription";

    public static final String NOTE = "note";

    public static final String IMG = "img";

}
