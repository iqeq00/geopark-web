package com.geopark.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geopark.web.mapper.EarthquakeMapper;
import com.geopark.web.model.entity.Earthquake;
import com.geopark.web.service.EarthquakeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 地灾信息 服务实现类
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Service
public class EarthquakeServiceImpl extends ServiceImpl<EarthquakeMapper, Earthquake> implements EarthquakeService {

}
