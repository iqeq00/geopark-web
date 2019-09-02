package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Mineralright;
import com.geopark.web.service.MineralrightService;
import com.geopark.web.service.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 矿权设置情况 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Slf4j
@RestController
@RequestMapping("/mineralright")
public class MineralrightController extends SuperController {
    @Autowired
    private MineralrightService mineralrightService;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("矿权情况查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Mineralright>> page(
            @RequestParam(value = "mineralname", defaultValue = "") String mineralname) {

        LambdaQueryChainWrapper<Mineralright> qw = mineralrightService.lambdaQuery();
        if (StringUtils.isNotBlank(mineralname)) {
            qw.like(Mineralright::getMineralname, mineralname);
        }

        return success(qw.page(this.<Mineralright>getPage()));

    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("矿权情况添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Mineralright mineralright) {

        mineralrightService.save(mineralright);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("矿权情况编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Mineralright mineralright) {

        mineralright.setId(id);
        mineralrightService.updateById(mineralright);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("矿权情况删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        mineralrightService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
