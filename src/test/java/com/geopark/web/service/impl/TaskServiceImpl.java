package com.geopark.web.service.impl;

import com.geopark.web.model.entity.Task;
import com.geopark.web.mapper.TaskMapper;
import com.geopark.web.service.TaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lichee
 * @since 2019-07-19
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

}
