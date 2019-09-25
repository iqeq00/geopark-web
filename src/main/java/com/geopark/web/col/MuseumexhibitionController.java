package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Museumexhibition;
import com.geopark.web.service.MuseumexhibitionService;
import com.geopark.web.service.SysResourceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 博物馆展厅 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-09-24
 */
@RestController
@RequestMapping("/museumexhibition")
public class MuseumexhibitionController extends SuperController {
    @Autowired
    private MuseumexhibitionService museumexhibitionService;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("博物馆展厅查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Museumexhibition>> page(
            @RequestParam(value = "exhibitionname", defaultValue = "") String exhibitionname) {

        LambdaQueryChainWrapper<Museumexhibition> qw = museumexhibitionService.lambdaQuery();
        if (StringUtils.isNotBlank(exhibitionname)) {
            qw.like(Museumexhibition::getExhibitionname, exhibitionname);
        }

        return success(qw.page(this.<Museumexhibition>getPage()));

    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("博物馆展厅添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Museumexhibition museumexhibition) {

        museumexhibitionService.save(museumexhibition);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("博物馆展厅编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Museumexhibition museumexhibition) {

        museumexhibition.setId(id);
        museumexhibitionService.updateById(museumexhibition);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("博物馆展厅删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        museumexhibitionService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
