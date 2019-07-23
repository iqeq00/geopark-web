package com.geopark.web.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 采样信息
 * </p>
 *
 * @author lichee
 * @since 2019-07-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sampling")
public class Sampling implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 地质公园ID
     */
    private Integer parkId;

    /**
     * 样品编号
     */
    private String samplenumber;

    /**
     * 样品类型
     */
    private String sampletype;

    /**
     * 采样位置
     */
    private String sampleposition;

    /**
     * 坐标
     */
    private String coordinate;

    /**
     * 地质代号
     */
    private String code;

    /**
     * 野外定名
     */
    private String research;

    /**
     * 测试成果
     */
    private String achievement;

    /**
     * 备注
     */
    private String note;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;


    public static final String ID = "id";

    public static final String PARK_ID = "park_id";

    public static final String SAMPLENUMBER = "samplenumber";

    public static final String SAMPLETYPE = "sampletype";

    public static final String SAMPLEPOSITION = "sampleposition";

    public static final String COORDINATE = "coordinate";

    public static final String CODE = "code";

    public static final String RESEARCH = "research";

    public static final String ACHIEVEMENT = "achievement";

    public static final String NOTE = "note";

    public static final String CREATED_AT = "created_at";

    public static final String UPDATED_AT = "updated_at";

    public static final String DELETED_AT = "deleted_at";

}
