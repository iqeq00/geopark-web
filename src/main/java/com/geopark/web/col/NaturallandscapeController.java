package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Naturallandscape;
import com.geopark.web.service.NaturallandscapeService;
import com.geopark.web.service.SysResourceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 自然景观 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-09-19
 */
@RestController
@RequestMapping("/naturallandscape")
public class NaturallandscapeController extends SuperController {
    @Autowired
    private NaturallandscapeService naturallandscapeService;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("自然景观查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Naturallandscape>> page(
            @RequestParam(value = "nname", defaultValue = "") String nname) {

        LambdaQueryChainWrapper<Naturallandscape> qw = naturallandscapeService.lambdaQuery();
        if (StringUtils.isNotBlank(nname)) {
            qw.like(Naturallandscape::getNname, nname);
        }
        return success(qw.page(this.<Naturallandscape>getPage()));
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("自然景观添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Naturallandscape naturallandscape) {

        naturallandscapeService.save(naturallandscape);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("自然景观编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Naturallandscape naturallandscape) {

        naturallandscape.setId(id);
        naturallandscapeService.updateById(naturallandscape);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("自然景观删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        naturallandscapeService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
