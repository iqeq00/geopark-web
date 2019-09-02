package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Researchpaper;
import com.geopark.web.service.ResearchpaperService;
import com.geopark.web.service.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 科研论文 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Slf4j
@RestController
@RequestMapping("/researchpaper")
public class ResearchpaperController extends SuperController {
    @Autowired
    private ResearchpaperService researchpaperService;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("科研论文查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Researchpaper>> page(
            @RequestParam(value = "author", defaultValue = "") String author,
            @RequestParam(value = "heading", defaultValue = "") String heading) {

        LambdaQueryChainWrapper<Researchpaper> qw = researchpaperService.lambdaQuery();
        if (StringUtils.isNotBlank(author)) {
            qw.like(Researchpaper::getAuthor, author);
        }
        if (StringUtils.isNotBlank(heading)) {
            qw.like(Researchpaper::getHeading, heading);
        }

        return success(qw.page(this.<Researchpaper>getPage()));

    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("科研论文添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Researchpaper researchpaper) {

        researchpaperService.save(researchpaper);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("科研论文编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Researchpaper researchpaper) {

        researchpaper.setId(id);
        researchpaperService.updateById(researchpaper);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("科研论文删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        researchpaperService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
