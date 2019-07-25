package com.geopark.web.mapper;

import com.geopark.web.model.entity.Museum;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 博物馆基本情况 Mapper 接口
 * </p>
 *
 * @author lichee
 * @since 2019-07-18
 */
@Mapper
public interface MuseumMapper extends BaseMapper<Museum> {

}
