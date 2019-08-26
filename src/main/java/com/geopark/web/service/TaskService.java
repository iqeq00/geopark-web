package com.geopark.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.geopark.web.model.entity.Task;

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
}
