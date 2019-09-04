package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Humenexhibit;
import com.geopark.web.service.HumenexhibitService;
import com.geopark.web.service.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 人文展品 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Slf4j
@RestController
@RequestMapping("/humenexhibit")
public class HumenexhibitController extends SuperController {
    @Autowired
    private HumenexhibitService humenexhibitService;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("人文展品查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Humenexhibit>> page(
            @RequestParam(value = "specimenname", defaultValue = "") String specimenname) {

        LambdaQueryChainWrapper<Humenexhibit> qw = humenexhibitService.lambdaQuery();
        if (StringUtils.isNotBlank(specimenname)) {
            qw.like(Humenexhibit::getSpecimenname, specimenname);
        }

        return success(qw.page(this.<Humenexhibit>getPage()));

    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("人文展品添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Humenexhibit humenexhibit) {

        humenexhibitService.save(humenexhibit);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("人文展品编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Humenexhibit humenexhibit) {

        humenexhibit.setId(id);
        humenexhibitService.updateById(humenexhibit);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("人文展品删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        humenexhibitService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
