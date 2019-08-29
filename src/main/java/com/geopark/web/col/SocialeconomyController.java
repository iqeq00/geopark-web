package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Socialeconomy;
import com.geopark.web.service.SocialeconomyService;
import com.geopark.web.service.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 社会经济概况 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Slf4j
@RestController
@RequestMapping("/socialeconomy")
public class SocialeconomyController extends SuperController {
    @Autowired
   private SocialeconomyService socialeconomyService;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("社会经济状况查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Socialeconomy>> page(
            @RequestParam(value = "parkId", defaultValue = "") String parkId) {

        LambdaQueryChainWrapper<Socialeconomy> qw = socialeconomyService.lambdaQuery();
        if (StringUtils.isNotBlank(parkId)) {
            qw.like(Socialeconomy::getParkId, parkId);
        }

        return success(qw.page(this.<Socialeconomy>getPage()));

    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("社会经济状况添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Socialeconomy socialeconomy) {

        socialeconomyService.save(socialeconomy);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("社会经济状况编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Socialeconomy socialeconomy) {

        socialeconomy.setId(id);
        socialeconomyService.updateById(socialeconomy);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("社会经济状况删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        socialeconomyService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
