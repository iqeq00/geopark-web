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
 * 矿权设置情况
 * </p>
 *
 * @author lichee
 * @since 2019-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("mineralright")
public class Mineralright implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 地质公园ID
     */
    private Integer parkId;

    /**
     * 编号
     */
    private String number;

    /**
     * 类型
     */
    private String type;

    /**
     * 许可证号
     */
    private String license;

    /**
     * 矿权人名称
     */
    private String mineralhumanname;

    /**
     * 矿权名称
     */
    private String mineralname;

    /**
     * 主要矿种
     */
    private String mineralspecies;

    /**
     * 位置
     */
    private String position;

    /**
     * 面积
     */
    private String area;

    /**
     * 经度
     */
    private Double lat;

    /**
     * 纬度
     */
    private Double lng;

    /**
     * 有效期
     */
    private String validity;

    /**
     * 备注
     */
    private String note;


    public static final String ID = "id";

    public static final String PARK_ID = "park_id";

    public static final String NUMBER = "number";

    public static final String TYPE = "type";

    public static final String LICENSE = "license";

    public static final String MINERALHUMANNAME = "mineralhumanname";

    public static final String MINERALNAME = "mineralname";

    public static final String MINERALSPECIES = "mineralspecies";

    public static final String POSITION = "position";

    public static final String AREA = "area";

    public static final String LAT = "lat";

    public static final String LNG = "lng";

    public static final String VALIDITY = "validity";

    public static final String NOTE = "note";

}
