package com.geopark.web.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 公园管理法律法规
 * </p>
 *
 * @author lichee
 * @since 2019-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("legal")
public class Legal implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 地质公园ID
     */
    private Integer parkId;

    /**
     * 文件编号
     */
    private String number;

    /**
     * 文件名称
     */
    private String filename;

    /**
     * 发布单位
     */
    private String unit;

    /**
     * 规划期限
     */
    private String time;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 摘要
     */
    private String summary;

    /**
     * 备注
     */
    private String note;


    public static final String ID = "id";

    public static final String PARK_ID = "park_id";

    public static final String NUMBER = "number";

    public static final String FILENAME = "filename";

    public static final String UNIT = "unit";

    public static final String TIME = "time";

    public static final String KEYWORD = "keyword";

    public static final String SUMMARY = "summary";

    public static final String NOTE = "note";

}
