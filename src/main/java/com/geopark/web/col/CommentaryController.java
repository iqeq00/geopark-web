package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Commentary;
import com.geopark.web.service.CommentaryService;
import com.geopark.web.service.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 标示解说系统 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Slf4j
@RestController
@RequestMapping("/commentary")
public class CommentaryController extends SuperController {
    @Autowired
    private CommentaryService commentaryService;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("标示解说查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Commentary>> page(
            @RequestParam(value = "position", defaultValue = "") String position) {

        LambdaQueryChainWrapper<Commentary> qw = commentaryService.lambdaQuery();
        if (StringUtils.isNotBlank(position)) {
            qw.like(Commentary::getPosition, position);
        }

        return success(qw.page(this.<Commentary>getPage()));

    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("标示解说添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Commentary commentary) {

        commentaryService.save(commentary);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("标示解说编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Commentary commentary) {

        commentary.setId(id);
        commentaryService.updateById(commentary);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("标示解说删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        commentaryService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
