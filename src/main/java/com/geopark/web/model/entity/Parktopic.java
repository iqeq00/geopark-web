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
 * 公园专题研究
 * </p>
 *
 * @author lichee
 * @since 2019-07-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("parktopic")
public class Parktopic implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 地质公园编号
     */
    private Integer parkId;

    /**
     * 报告编号
     */
    private String reportnumber;

    /**
     * 报告名称
     */
    private String reportname;

    /**
     * 成果类型
     */
    private String achievementtype;

    /**
     * 作者
     */
    private String auther;

    /**
     * 完成时间
     */
    private String carrytime;

    /**
     * 完成单位
     */
    private String carryunit;

    /**
     * 主管单位
     */
    private String organizer;

    /**
     * 主题词
     */
    private String theme;

    /**
     * 成果摘要
     */
    private String achievementsummary;

    /**
     * 公园收藏情况
     */
    private String parkcollect;

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

    public static final String REPORTNUMBER = "reportnumber";

    public static final String REPORTNAME = "reportname";

    public static final String ACHIEVEMENTTYPE = "achievementtype";

    public static final String AUTHER = "auther";

    public static final String CARRYTIME = "carrytime";

    public static final String CARRYUNIT = "carryunit";

    public static final String ORGANIZER = "organizer";

    public static final String THEME = "theme";

    public static final String ACHIEVEMENTSUMMARY = "achievementsummary";

    public static final String PARKCOLLECT = "parkcollect";

    public static final String NOTE = "note";

    public static final String IMG = "img";

}
