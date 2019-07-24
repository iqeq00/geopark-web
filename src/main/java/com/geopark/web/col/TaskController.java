package com.geopark.web.col;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Task;
import com.geopark.web.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-18
 */
@Slf4j
@RestController
@RequestMapping("task")
public class TaskController extends SuperController {

    @Autowired
    private TaskService taskService;

    @GetMapping("page")
    public ApiResponses<IPage<Task>> page(
            @RequestParam(value = "taskName", defaultValue = "") String taskName,
            @RequestParam(value = "status", defaultValue = "") String status,
            Date startTime, Date endTime) {

        QueryChainWrapper<Task> qw = taskService.query();
        if (StringUtils.isNotBlank(taskName)) {
            qw.like("task_name", taskName);
        }
        if (StringUtils.isNotBlank(status)) {
            qw.eq("status", status);
        }
        if (null != startTime) {
            qw.ge("create_time", startTime);
        }
        if (null != endTime) {
            qw.le("create_time", endTime);
        }
        return success(qw.page(this.<Task>getPage()));
    }

    @PostMapping
    public ApiResponses<Void> save(@RequestBody Task task) {

        task.setCreateTime(LocalDateTime.now());
        taskService.save(task);
        return success(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Task task) {

        task.setId(id);
        taskService.updateById(task);
        return success();
    }


    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {
        taskService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }


}
