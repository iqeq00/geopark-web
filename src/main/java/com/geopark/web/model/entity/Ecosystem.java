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
 * 生态环境状况
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ecosystem")
public class Ecosystem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 地质公园编号
     */
    private Integer parkId;

    /**
     * 公园地貌类型
     */
    private String type;

    /**
     * 公园年平均气温高
     */
    private String averagetempera;

    /**
     * 公园年最高气温
     */
    private String toptempera;

    /**
     * 公园年最低气温
     */
    private String bottomtempera;

    /**
     * 公园年平均降水
     */
    private String averagerain;

    /**
     * 植被、绿地
     */
    private String plantcover;

    /**
     * 珍稀动物
     */
    private String animal;

    /**
     * 珍稀植物
     */
    private String plant;

    /**
     * 水资源概况
     */
    private String water;

    /**
     * 气候特征
     */
    private String climate;

    /**
     * 公园内灾害情
     */
    private String disaster;

    /**
     * 备注
     */
    private String note;


    public static final String ID = "id";

    public static final String PARK_ID = "park_id";

    public static final String TYPE = "type";

    public static final String AVERAGETEMPERA = "averagetempera";

    public static final String TOPTEMPERA = "toptempera";

    public static final String BOTTOMTEMPERA = "bottomtempera";

    public static final String AVERAGERAIN = "averagerain";

    public static final String PLANTCOVER = "plantcover";

    public static final String ANIMAL = "animal";

    public static final String PLANT = "plant";

    public static final String WATER = "water";

    public static final String CLIMATE = "climate";

    public static final String DISASTER = "disaster";

    public static final String NOTE = "note";

}
