package com.geopark.web.col;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Task;
import com.geopark.web.service.SysResourceService;
import com.geopark.web.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

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

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("任务查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Task>> page(
            @RequestParam(value = "taskName", defaultValue = "") String taskName,
            @RequestParam(value = "status", defaultValue = "") String status,
            Date startTime, Date endTime) {

        return success(taskService.page(taskName, status, startTime, endTime, this.<Task>getPage()));

    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("任务添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Task task) {

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

    @PostMapping("transaction")
    public ApiResponses<Void> transaction(@RequestBody Task task) {

        taskService.saveTransaction(task);
        return success(HttpStatus.CREATED);
    }

    @GetMapping("/redis")
    public void test(){

        // TODO 测试线程安全
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        IntStream.range(0, 1000).forEach(i ->
                executorService.execute(() -> stringRedisTemplate.opsForValue().increment("kk", 1))
        );
        stringRedisTemplate.opsForValue().set("k1", "v1");
        final String k1 = stringRedisTemplate.opsForValue().get("k1");
        log.info("[字符缓存结果] - [{}]", k1);
        // TODO 以下只演示整合，具体Redis命令可以参考官方文档，Spring Data Redis 只是改了个名字而已，Redis支持的命令它都支持
        String key = "battcn:user:1";
        redisCacheTemplate.opsForValue().set(key, new Task(1, "名字", "描述", LocalDateTime.now(), 1));
        // TODO 对应 String（字符串）
        final Task user = (Task) redisCacheTemplate.opsForValue().get(key);
        log.info("[对象缓存结果] - [{}]", user);
    }

}