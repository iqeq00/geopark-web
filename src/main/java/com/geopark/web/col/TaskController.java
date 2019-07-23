package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.geopark.web.Constants;
import com.geopark.web.base.ResponseEntity;
import com.geopark.web.base.ResponseList;
import com.geopark.web.model.entity.Task;
import com.geopark.web.service.TaskService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-18
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("page")
    public ResponseList<Task> page(@RequestParam(value = "page", defaultValue = "1") int pageNum,
                                   @RequestParam(value = "limit", defaultValue = "10") int pageSize,
                                   @RequestParam(value = "taskName", defaultValue = "") String taskName,
                                   @RequestParam(value = "status", defaultValue = "") String status,
                                   Date startTime,
                                   Date endTime) {

        QueryChainWrapper<Task> qw = taskService.query();
        if (StringUtils.isNotBlank(taskName)) {
            qw.like("task_name",taskName);
        }
        if (StringUtils.isNotBlank(status)) {
            qw.eq("status",status);
        }
        if (null != startTime) {
            qw.ge("create_time", startTime);
        }
        if (null != endTime) {
            qw.le("create_time", endTime);
        }
        IPage<Task> page = qw.page(new Page<Task>(pageNum, pageSize));
        ResponseList<Task> res = new ResponseList<>(page.getRecords(), page.getTotal());
        return res;
    }

    /**
     * 保存
     */
    @PostMapping
    public ResponseEntity<String> save(@RequestBody Task task) {

        ResponseEntity<String> res = new ResponseEntity<String>();
        try {
            task.setCreateTime(LocalDateTime.now());
            boolean s = taskService.save(task);
            if (s) {
                res.setSuccess("成功");
            } else {
                res.setData("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.setFailure(Constants.Message.OPTION_FAILURE);
        }
        return res;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody Task task) {
        ResponseEntity<String> res = new ResponseEntity<String>();
        try {
            boolean s = taskService.updateById(task);
            if (s) {
                res.setSuccess("成功");
            } else {
                res.setData("失败");
            }
        } catch (Exception e) {
            res.setFailure(Constants.Message.OPTION_FAILURE);
        }
        return res;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        ResponseEntity<String> res = new ResponseEntity<>();
        try {
            Boolean isOk = taskService.removeById(id);
            if (isOk) {
                res.setData("成功");
            } else {
                res.setData("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.setFailure(Constants.Message.OPTION_FAILURE);
        }
        return res;
    }
}
