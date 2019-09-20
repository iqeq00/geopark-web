package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Humanlandscape;
import com.geopark.web.service.HumanlandscapeService;
import com.geopark.web.service.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 人文景观 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Slf4j
@RestController
@RequestMapping("/humanlandscape")
public class HumanlandscapeController extends SuperController {
    @Autowired
    private HumanlandscapeService humanlandscapeService;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("人文景观查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Humanlandscape>> page(
            @RequestParam(value = "hname", defaultValue = "") String hname) {

        LambdaQueryChainWrapper<Humanlandscape> qw = humanlandscapeService.lambdaQuery();
        if (StringUtils.isNotBlank(hname)) {
            qw.like(Humanlandscape::getHname, hname);
        }
        return success(qw.page(this.<Humanlandscape>getPage()));

    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("人文景观添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Humanlandscape humanlandscape) {

        humanlandscapeService.save(humanlandscape);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("人文景观编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Humanlandscape humanlandscape) {

        humanlandscape.setId(id);
        humanlandscapeService.updateById(humanlandscape);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("人文景观删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        humanlandscapeService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
