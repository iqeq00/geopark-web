package com.geopark.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.geopark.web.model.entity.Task;
import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
public interface TaskService extends IService<Task> {

    void saveTransaction(Task task);

    IPage<Task> page(String taskName, String status, Date startTime, Date endTime, Page<Task> page);
}
