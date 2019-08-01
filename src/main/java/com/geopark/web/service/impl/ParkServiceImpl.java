package com.geopark.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geopark.web.mapper.ParkMapper;
import com.geopark.web.model.entity.Park;
import com.geopark.web.service.ParkService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 公园概况 服务实现类
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Service
public class ParkServiceImpl extends ServiceImpl<ParkMapper, Park> implements ParkService {

}
