package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Biospecimen;
import com.geopark.web.service.BiospecimenService;
import com.geopark.web.service.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 生物标本 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Slf4j
@RestController
@RequestMapping("/biospecimen")
public class BiospecimenController extends SuperController {
    @Autowired
    private BiospecimenService biospecimenService;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("生物标本查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Biospecimen>> page(
            @RequestParam(value = "specimenname", defaultValue = "") String specimenname) {

        LambdaQueryChainWrapper<Biospecimen> qw = biospecimenService.lambdaQuery();
        if (StringUtils.isNotBlank(specimenname)) {
            qw.like(Biospecimen::getSpecimenname, specimenname);
        }

        return success(qw.page(this.<Biospecimen>getPage()));

    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("生物标本添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Biospecimen biospecimen) {

        biospecimenService.save(biospecimen);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("生物标本编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Biospecimen biospecimen) {

        biospecimen.setId(id);
        biospecimenService.updateById(biospecimen);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("生物标本删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        biospecimenService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
