package com.geopark.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.geopark.web.model.entity.SysResource;
import com.geopark.web.model.vo.ResourcePermVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 资源表 Mapper 接口
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
public interface SysResourceMapper extends BaseMapper<SysResource> {

    /**
     * 获取用户权限
     *
     * @param id
     * @return
     */
    List<ResourcePermVo> getUserResourcePerms(@Param("uid") Integer uid);

    /**
     * 获取用户菜单资源权限
     *
     * @param id
     * @return
     */
    List<ResourcePermVo> getUserMenuResourcePerms(@Param("uid") Integer uid);
}
