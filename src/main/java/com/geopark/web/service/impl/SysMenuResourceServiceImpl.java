package com.geopark.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geopark.web.mapper.SysMenuResourceMapper;
import com.geopark.web.model.entity.SysMenuResource;
import com.geopark.web.service.SysMenuResourceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单资源关系表 服务实现类
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Service
public class SysMenuResourceServiceImpl extends ServiceImpl<SysMenuResourceMapper, SysMenuResource> implements SysMenuResourceService {

    @Override
    public List<SysMenuResource> getMenuResources(Integer menuId, List<String> resourceIds) {

        return resourceIds.stream().map(resourceId -> new SysMenuResource(menuId, resourceId)).collect(Collectors.toList());
    }

    @Override
    public void removeByMenuId(Integer menuId) {

        List<SysMenuResource> list = lambdaQuery().eq(SysMenuResource::getMenuId, menuId).list();
        List<Integer> ids = new ArrayList<>();
        list.forEach(val -> {
            ids.add(val.getId());
        });
        if(ids.size()>0) {
            removeByIds(ids);
        }

    }
}
