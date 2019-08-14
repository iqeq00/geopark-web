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
 * 人文景观
 * </p>
 *
 * @author lichee
 * @since 2019-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("humanlandscape")
public class Humanlandscape implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 地质公园ID
     */
    private Integer parkId;

    /**
     * 人文景观编号
     */
    private String humanitnumber;

    /**
     * 景观名称
     */
    private String hName;

    /**
     * 地理位置
     */
    private String position;

    /**
     * 交通状况
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
     * 景观特色
     */
    private String feature;

    /**
     * 文物保护单位
     */
    private String level;

    /**
     * 批准时间
     */
    private String approvedtime;

    /**
     * 保护现状
     */
    private String status;

    /**
     * 照片
     */
    private String img;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;


    public static final String ID = "id";

    public static final String PARK_ID = "park_id";

    public static final String HUMANITNUMBER = "humanitnumber";

    public static final String H_NAME = "h_name";

    public static final String POSITION = "position";

    public static final String TRAFFIC = "traffic";

    public static final String LAT = "lat";

    public static final String LNG = "lng";

    public static final String ALTITUDE = "altitude";

    public static final String FEATURE = "feature";

    public static final String LEVEL = "level";

    public static final String APPROVEDTIME = "approvedtime";

    public static final String STATUS = "status";

    public static final String IMG = "img";

    public static final String CREATED_AT = "created_at";

    public static final String UPDATED_AT = "updated_at";

    public static final String DELETED_AT = "deleted_at";

}
