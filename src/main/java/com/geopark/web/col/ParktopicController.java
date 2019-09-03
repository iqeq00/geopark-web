package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Parktopic;
import com.geopark.web.service.ParktopicService;
import com.geopark.web.service.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 公园专题研究 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Slf4j
@RestController
@RequestMapping("/parktopic")
public class ParktopicController extends SuperController {
    @Autowired
    private ParktopicService parktopicService;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("专题研究查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Parktopic>> page(
            @RequestParam(value = "author", defaultValue = "") String author,
            @RequestParam(value = "reportname", defaultValue = "") String reportname) {

        LambdaQueryChainWrapper<Parktopic> qw = parktopicService.lambdaQuery();
        if (StringUtils.isNotBlank(author)) {
            qw.like(Parktopic::getAuther, author);
        }
        if (StringUtils.isNotBlank(reportname)) {
            qw.like(Parktopic::getReportname, reportname);
        }

        return success(qw.page(this.<Parktopic>getPage()));

    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("专题研究添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Parktopic parktopic) {

        parktopicService.save(parktopic);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("专题研究编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Parktopic parktopic) {

        parktopic.setId(id);
        parktopicService.updateById(parktopic);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("专题研究删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        parktopicService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
