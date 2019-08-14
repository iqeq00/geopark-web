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
 * 公园项目管理
 * </p>
 *
 * @author lichee
 * @since 2019-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("parkoption")
public class Parkoption implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 地质公园ID
     */
    private Integer parkId;

    /**
     * 项目名称
     */
    private String project;

    /**
     * 委托方
     */
    private String client;

    /**
     * 资金来源
     */
    private String fundProvider;

    /**
     * 项目实施单位
     */
    private String actualizer;

    /**
     * 项目合同金额
     */
    private Double amount;

    /**
     * 项目周期
     */
    private String cycle;

    /**
     * 项目负责姓名
     */
    private String man;

    /**
     * 项目负责联系
     */
    private String contact;

    /**
     * 项目进度情况
     */
    private String progress;

    /**
     * 付款情况
     */
    private String pay;

    /**
     * 备注
     */
    private String remark;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;


    public static final String ID = "id";

    public static final String PARK_ID = "park_id";

    public static final String PROJECT = "project";

    public static final String CLIENT = "client";

    public static final String FUND_PROVIDER = "fund_provider";

    public static final String ACTUALIZER = "actualizer";

    public static final String AMOUNT = "amount";

    public static final String CYCLE = "cycle";

    public static final String MAN = "man";

    public static final String CONTACT = "contact";

    public static final String PROGRESS = "progress";

    public static final String PAY = "pay";

    public static final String REMARK = "remark";

    public static final String CREATED_AT = "created_at";

    public static final String UPDATED_AT = "updated_at";

    public static final String DELETED_AT = "deleted_at";

}
