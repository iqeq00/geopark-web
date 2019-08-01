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
 * 地灾信息
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("earthquake")
public class Earthquake implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 地质公园ID
     */
    private Integer parkId;

    /**
     * 灾害点编号
     */
    private String disasternumber;

    /**
     * 灾害点名称
     */
    private String disastername;

    /**
     * 类型
     */
    private String type;

    /**
     * 地理位置
     */
    private String position;

    /**
     * 坐标
     */
    private String coordinate;

    /**
     * 规模
     */
    private String scale;

    /**
     * 稳定性
     */
    private String stability;

    /**
     * 危险性
     */
    private String dangerous;

    /**
     * 特征描述
     */
    private String description;

    /**
     * 诱发因素
     */
    private String factor;

    /**
     * 威胁对象
     */
    private String threat;

    /**
     * 备注
     */
    private String note;


    public static final String ID = "id";

    public static final String PARK_ID = "park_id";

    public static final String DISASTERNUMBER = "disasternumber";

    public static final String DISASTERNAME = "disastername";

    public static final String TYPE = "type";

    public static final String POSITION = "position";

    public static final String COORDINATE = "coordinate";

    public static final String SCALE = "scale";

    public static final String STABILITY = "stability";

    public static final String DANGEROUS = "dangerous";

    public static final String DESCRIPTION = "description";

    public static final String FACTOR = "factor";

    public static final String THREAT = "threat";

    public static final String NOTE = "note";

}
