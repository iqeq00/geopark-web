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
 * 地质遗迹景点
 * </p>
 *
 * @author lichee
 * @since 2019-07-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("geolandscape")
public class Geolandscape implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 地质公园ID
     */
    private Integer parkId;

    /**
     * 时间
     */
    private String time;

    /**
     * 收入
     */
    private Double income;

    /**
     * 收入来源说明
     */
    private String incomesource;

    /**
     * 支出
     */
    private Double expenditure;

    /**
     * 支出项目说明
     */
    private String expenditureproject;

    /**
     * 结余
     */
    private Double balance;

    /**
     * 结余情况说明
     */
    private String balancematter;

    /**
     * 备注
     */
    private String note;


    public static final String ID = "id";

    public static final String PARK_ID = "park_id";

    public static final String TIME = "time";

    public static final String INCOME = "income";

    public static final String INCOMESOURCE = "incomesource";

    public static final String EXPENDITURE = "expenditure";

    public static final String EXPENDITUREPROJECT = "expenditureproject";

    public static final String BALANCE = "balance";

    public static final String BALANCEMATTER = "balancematter";

    public static final String NOTE = "note";

}
