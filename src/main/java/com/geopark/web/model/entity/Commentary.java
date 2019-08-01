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
 * 标示解说系统
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("commentary")
public class Commentary implements Serializable {

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
     * 位置
     */
    private String position;

    /**
     * 坐标
     */
    private String coordinate;

    /**
     * 建设时间
     */
    private String constructiontime;

    /**
     * 内容
     */
    private String content;

    /**
     * 备注
     */
    private String note;


    public static final String ID = "id";

    public static final String PARK_ID = "park_id";

    public static final String NUMBER = "number";

    public static final String TYPE = "type";

    public static final String POSITION = "position";

    public static final String COORDINATE = "coordinate";

    public static final String CONSTRUCTIONTIME = "constructiontime";

    public static final String CONTENT = "content";

    public static final String NOTE = "note";

}
