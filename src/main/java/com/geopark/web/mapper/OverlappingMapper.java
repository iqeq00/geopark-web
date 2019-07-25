package com.geopark.web.mapper;

import com.geopark.web.model.entity.Overlapping;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 与其他景区重叠情况 Mapper 接口
 * </p>
 *
 * @author lichee
 * @since 2019-07-18
 */
@Mapper
public interface OverlappingMapper extends BaseMapper<Overlapping> {

}
