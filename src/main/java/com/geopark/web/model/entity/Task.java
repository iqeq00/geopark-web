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
 * 
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("task")
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名字
     */
    private String taskName;

    /**
     * 描述
     */
    private String taskDesc;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 状态：
1. 任务未开始
2. 任务进行中
3. 任务完成
4. 任务失败
     */
    private Integer status;


    public static final String ID = "id";

    public static final String TASK_NAME = "task_name";

    public static final String TASK_DESC = "task_desc";

    public static final String CREATE_TIME = "create_time";

    public static final String STATUS = "status";

}
