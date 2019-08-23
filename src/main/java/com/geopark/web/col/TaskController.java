package com.geopark.web.col;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Task;
import com.geopark.web.model.vo.ResourcePermVo;
import com.geopark.web.service.SysResourceService;
import com.geopark.web.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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
@RequestMapping("/task")
public class TaskController extends SuperController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("任务查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Task>> page(
            @RequestParam(value = "taskName", defaultValue = "") String taskName,
            @RequestParam(value = "status", defaultValue = "") String status,
            Date startTime, Date endTime) {

        LambdaQueryChainWrapper<Task> qw = taskService.lambdaQuery();
        if (StringUtils.isNotBlank(taskName)) {
            qw.like(Task::getTaskName, taskName);
        }
        if (StringUtils.isNotBlank(status)) {
            qw.eq(Task::getStatus, status);
        }
        if (null != startTime) {
            qw.ge(Task::getCreateTime, startTime);
        }
        if (null != endTime) {
            qw.le(Task::getCreateTime, endTime);
        }
        return success(qw.page(this.<Task>getPage()));
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("任务添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Task task) {

        task.setCreateTime(LocalDateTime.now());
        taskService.save(task);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("任务编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Task task) {

        task.setId(id);
        taskService.updateById(task);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("任务删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        taskService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }

}