package com.geopark.web.service.impl;

import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geopark.framework.converter.BeanConverter;
import com.geopark.framework.enums.AuthTypeEnum;
import com.geopark.web.mapper.SysResourceMapper;
import com.geopark.web.model.entity.SysResource;
import com.geopark.web.model.vo.ResourcePermVo;
import com.geopark.web.service.SysResourceService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Service
public class SysResourceServiceImpl extends ServiceImpl<SysResourceMapper, SysResource> implements SysResourceService {

    @Override
    public List<ResourcePermVo> getResourcePerms(String method) {

        List<SysResource> list = query().select("method", "mapping").eq("method",method).list();
        return BeanConverter.convert(ResourcePermVo.class, list);
    }

    @Override
    public List<ResourcePermVo> getOpenPerms() {
        return getPerms(AuthTypeEnum.OPEN);
    }

    @Override
    public List<ResourcePermVo> getPerms(AuthTypeEnum... authTypes) {
        List<SysResource> list =lambdaQuery().select(SysResource::getMethod, SysResource::getMapping).in(ArrayUtils.isNotEmpty(authTypes), SysResource::getAuthType, (Object[]) authTypes).list();

        return BeanConverter.convert(ResourcePermVo.class, list);
    }

    @Override
    public List<ResourcePermVo> getUserMenuResourcePerms(Integer id) {
        return baseMapper.getUserMenuResourcePerms(id);
    }


    @Override
    public List<String> getUserPerms(Integer id) {
        return getUserResourcePerms(id).stream().map(e -> this.getResourcePermTag(e.getMethod(), e.getMapping())).collect(Collectors.toList());
    }

    @Override
    public String getResourcePermTag(String method, String mapping) {
        return method + ":" + mapping;
    }


    @Override
    public Set<ResourcePermVo> getUserResourcePerms(Integer uid) {
        List<ResourcePermVo> perms = getPerms(AuthTypeEnum.OPEN, AuthTypeEnum.LOGIN);
        List<ResourcePermVo> resourcePerms = baseMapper.getUserResourcePerms(uid);
        List<ResourcePermVo> userMenuResourcePerms = getUserMenuResourcePerms(uid);
        perms.addAll(resourcePerms);
        perms.addAll(userMenuResourcePerms);
        return new HashSet<>(perms);
    }
}
