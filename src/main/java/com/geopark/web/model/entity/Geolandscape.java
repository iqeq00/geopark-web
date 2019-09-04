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
 * 地质遗迹景观
 * </p>
 *
 * @author lichee
 * @since 2019-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("geolandscape")
public class Geolandscape implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 地质公园ID
     */
    private Integer parkId;

    /**
     * 地质遗迹统一编号
     */
    private String unitenumber;

    /**
     * 原编号
     */
    private String originalnumber;

    /**
     * 地质遗迹名称
     */
    private String gName;

    /**
     * 地质遗迹原名称
     */
    private String originalname;

    /**
     * 地质遗迹类型
     */
    private String type;

    /**
     * 地质遗迹地理位置
     */
    private String position;

    /**
     * 地质遗迹交通状况
     */
    private String traffic;

    /**
     * 经度
     */
    private Double lat;

    /**
     * 纬度
     */
    private Double lng;

    /**
     * 海拔高度
     */
    private String altitude;

    /**
     * 地质遗迹地质背景
     */
    private String background;

    /**
     * 地质遗迹特征
     */
    private String feature;

    /**
     * 评价级别
     */
    private String evaluation;

    /**
     * 保护级别
     */
    private String protection;

    /**
     * 观赏价值
     */
    private String value;

    /**
     * 遗迹成因类型
     */
    private String causes;

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

    public static final String UNITENUMBER = "unitenumber";

    public static final String ORIGINALNUMBER = "originalnumber";

    public static final String G_NAME = "g_name";

    public static final String ORIGINALNAME = "originalname";

    public static final String TYPE = "type";

    public static final String POSITION = "position";

    public static final String TRAFFIC = "traffic";

    public static final String LAT = "lat";

    public static final String LNG = "lng";

    public static final String ALTITUDE = "altitude";

    public static final String BACKGROUND = "background";

    public static final String FEATURE = "feature";

    public static final String EVALUATION = "evaluation";

    public static final String PROTECTION = "protection";

    public static final String VALUE = "value";

    public static final String CAUSES = "causes";

    public static final String NOTE = "note";

    public static final String IMG = "img";

}
