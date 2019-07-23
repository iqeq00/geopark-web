package com.geopark.web.service.impl;

import com.geopark.web.model.entity.Overlapping;
import com.geopark.web.mapper.OverlappingMapper;
import com.geopark.web.service.OverlappingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 与其他景区重叠情况 服务实现类
 * </p>
 *
 * @author lichee
 * @since 2019-07-18
 */
@Service
public class OverlappingServiceImpl extends ServiceImpl<OverlappingMapper, Overlapping> implements OverlappingService {

}
