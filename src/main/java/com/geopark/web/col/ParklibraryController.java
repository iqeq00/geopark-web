package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Parklibrary;
import com.geopark.web.service.ParklibraryService;
import com.geopark.web.service.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 公园专家库与导游库 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Slf4j
@RestController
@RequestMapping("/parklibrary")
public class ParklibraryController extends SuperController {

    @Autowired
    private ParklibraryService parklibraryService;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("专家导游查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Parklibrary>> page(
            @RequestParam(value = "name", defaultValue = "") String name) {

        LambdaQueryChainWrapper<Parklibrary> qw = parklibraryService.lambdaQuery();
        if (StringUtils.isNotBlank(name)) {
            qw.like(Parklibrary::getName, name);
        }

        return success(qw.page(this.<Parklibrary>getPage()));

    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("专家导游添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Parklibrary parklibrary) {

        parklibraryService.save(parklibrary);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("专家导游编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Parklibrary parklibrary) {

        parklibrary.setId(id);
        parklibraryService.updateById(parklibrary);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("专家导游删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        parklibraryService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }

}
