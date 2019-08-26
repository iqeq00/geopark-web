package com.geopark.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geopark.web.mapper.TaskMapper;
import com.geopark.web.model.entity.Task;
import com.geopark.web.service.SysRoleResourceService;
import com.geopark.web.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

    @Autowired
    public SysRoleResourceService roleResourceService;

    @Override
    public void saveTransaction(Task task) {

        System.out.println("coming");
        this.save(task);
        roleResourceService.saveTransaction();
    }
}
