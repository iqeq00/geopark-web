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
 * 与其他景区重叠情况
 * </p>
 *
 * @author lichee
 * @since 2019-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("overlapping")
public class Overlapping implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 地质公园ID
     */
    private Integer parkId;

    /**
     * 其他景区名称
     */
    private String othername;

    /**
     * 其他景区类型
     */
    private String othertype;

    /**
     * 其他景区主管部门
     */
    private String othersupervisor;

    /**
     * 其他景区开发建设情况
     */
    private String othermatter;

    /**
     * 重叠区域位置
     */
    private String overposition;

    /**
     * 重叠区域面积
     */
    private String overarea;

    /**
     * 重叠区管理情况说明
     */
    private String overinstruction;

    /**
     * 备注
     */
    private String note;


    public static final String ID = "id";

    public static final String PARK_ID = "park_id";

    public static final String OTHERNAME = "othername";

    public static final String OTHERTYPE = "othertype";

    public static final String OTHERSUPERVISOR = "othersupervisor";

    public static final String OTHERMATTER = "othermatter";

    public static final String OVERPOSITION = "overposition";

    public static final String OVERAREA = "overarea";

    public static final String OVERINSTRUCTION = "overinstruction";

    public static final String NOTE = "note";

}
