package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Vrdata;
import com.geopark.web.service.SysResourceService;
import com.geopark.web.service.VrdataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 地质公园VR全景数据 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-09-24
 */
@RestController
@RequestMapping("/vrdata")
public class VrdataController extends SuperController {
    @Autowired
    private VrdataService vrdataService;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("VR全景查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Vrdata>> page(
            @RequestParam(value = "vrname", defaultValue = "") String vrname) {

        LambdaQueryChainWrapper<Vrdata> qw = vrdataService.lambdaQuery();
        if (StringUtils.isNotBlank(vrname)) {
            qw.like(Vrdata::getVrname, vrname);
        }

        return success(qw.page(this.<Vrdata>getPage()));

    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("VR全景添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Vrdata vrdata) {

        vrdataService.save(vrdata);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("VR全景编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Vrdata vrdata) {

        vrdata.setId(id);
        vrdataService.updateById(vrdata);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("VR全景删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        vrdataService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
