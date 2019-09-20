package com.geopark.web.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 生物标本
 * </p>
 *
 * @author lichee
 * @since 2019-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("biospecimen")
public class Biospecimen implements Serializable {

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
     * 拉丁学名
     */
    private String latin;

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
    private String collectiontime;

    /**
     * 采集人
     */
    private String collectionhuman;

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


    public static final String ID = "id";

    public static final String PARK_ID = "park_id";

    public static final String SPECIMENNUMBER = "specimennumber";

    public static final String SPECIMENNAME = "specimenname";

    public static final String HALLNUMBER = "hallnumber";

    public static final String LATIN = "latin";

    public static final String SPECIMENTYPE = "specimentype";

    public static final String COLLECTIONPOSITION = "collectionposition";

    public static final String COLLECTIONTIME = "collectiontime";

    public static final String COLLECTIONHUMAN = "collectionhuman";

    public static final String COLLECTIONNUMBER = "collectionnumber";

    public static final String SAVESTATE = "savestate";

    public static final String FEATUREDESCRIPTION = "featuredescription";

    public static final String NOTE = "note";

    public static final String IMG = "img";

}
