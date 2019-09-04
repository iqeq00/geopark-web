package com.geopark.web.col;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.geopark.framework.annotations.ApiOperation;
import com.geopark.framework.annotations.Resources;
import com.geopark.framework.controller.SuperController;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.framework.responses.ApiResponses;
import com.geopark.web.model.entity.Displayboard;
import com.geopark.web.service.DisplayboardService;
import com.geopark.web.service.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 展板 前端控制器
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Slf4j
@RestController
@RequestMapping("/displayboard")
public class DisplayboardController extends SuperController {
    @Autowired
    private DisplayboardService displayboardService;

    @Autowired
    private SysResourceService sysResourceService;

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("展板查询(分页)")
    @GetMapping("/page")
    public ApiResponses<IPage<Displayboard>> page(
            @RequestParam(value = "boardcontent", defaultValue = "") String boardcontent) {

        LambdaQueryChainWrapper<Displayboard> qw = displayboardService.lambdaQuery();
        if (StringUtils.isNotBlank(boardcontent)) {
            qw.like(Displayboard::getBoardcontent, boardcontent);
        }

        return success(qw.page(this.<Displayboard>getPage()));

    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("展板添加")
    @PostMapping
    public ApiResponses<Void> save(@RequestBody Displayboard displayboard) {

        displayboardService.save(displayboard);
        return success(HttpStatus.CREATED);
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("展板编辑")
    @PutMapping("/{id}")
    public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody Displayboard displayboard) {

        displayboard.setId(id);
        displayboardService.updateById(displayboard);
        return success();
    }

    @Resources(AuthTypeEnum.LOGIN)
    @ApiOperation("展板删除")
    @DeleteMapping("/{id}")
    public ApiResponses<Void> delete(@PathVariable("id") Integer id) {

        displayboardService.removeById(id);
        return success(HttpStatus.NO_CONTENT);
    }
}
