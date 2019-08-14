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
 * 公园概况
 * </p>
 *
 * @author lichee
 * @since 2019-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("park")
public class Park implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 编码
     */
    private String number;

    /**
     * 名称
     */
    private String name;

    /**
     * 级别
     */
    private String rank;

    /**
     * 位置
     */
    private String position;

    /**
     * 行政区
     */
    private String district;

    /**
     * 邮政编码
     */
    private String zip;

    /**
     * 经度
     */
    private String lng;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 面积
     */
    private String area;

    /**
     * 公园类型
     */
    private String type;

    /**
     * 保护区划分情况
     */
    private String divide;

    /**
     * 建立时间
     */
    private String create;

    /**
     * 公园地质遗迹景观特色
     */
    private String characteristic;

    /**
     * 重要意义
     */
    private String significance;

    /**
     * 批准单位
     */
    private String ratifier;

    /**
     * 保护现状
     */
    private String statusQuo;

    /**
     * 主要地质遗迹类型
     */
    private String historicalType;

    /**
     * 公园主管部门
     */
    private String master;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;


    public static final String ID = "id";

    public static final String NUMBER = "number";

    public static final String NAME = "name";

    public static final String RANK = "rank";

    public static final String POSITION = "position";

    public static final String DISTRICT = "district";

    public static final String ZIP = "zip";

    public static final String LNG = "lng";

    public static final String LAT = "lat";

    public static final String AREA = "area";

    public static final String TYPE = "type";

    public static final String DIVIDE = "divide";

    public static final String CREATE = "create";

    public static final String CHARACTERISTIC = "characteristic";

    public static final String SIGNIFICANCE = "significance";

    public static final String RATIFIER = "ratifier";

    public static final String STATUS_QUO = "status_quo";

    public static final String HISTORICAL_TYPE = "historical_type";

    public static final String MASTER = "master";

    public static final String CREATED_AT = "created_at";

    public static final String UPDATED_AT = "updated_at";

    public static final String DELETED_AT = "deleted_at";

}
