package com.geopark.web.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 展板
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("displayboard")
public class Displayboard implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 公园ID
     */
    private Integer parkId;

    /**
     * 展板编号
     */
    private String boardnumber;

    /**
     * 展厅名称
     */
    private String hallname;

    /**
     * 展板内容
     */
    private String boardcontent;

    /**
     * 制作时间
     */
    private LocalDate makingtime;

    /**
     * 设计施工单位
     */
    private String constructionunit;

    /**
     * 内容作者
     */
    private String contentauther;

    /**
     * 附注
     */
    private String note;

    /**
     * 照片
     */
    private String img;


    public static final String ID = "id";

    public static final String PARK_ID = "park_id";

    public static final String BOARDNUMBER = "boardnumber";

    public static final String HALLNAME = "hallname";

    public static final String BOARDCONTENT = "boardcontent";

    public static final String MAKINGTIME = "makingtime";

    public static final String CONSTRUCTIONUNIT = "constructionunit";

    public static final String CONTENTAUTHER = "contentauther";

    public static final String NOTE = "note";

    public static final String IMG = "img";

}
