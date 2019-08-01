package com.geopark.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geopark.web.mapper.SamplingMapper;
import com.geopark.web.model.entity.Sampling;
import com.geopark.web.service.SamplingService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 采样信息 服务实现类
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Service
public class SamplingServiceImpl extends ServiceImpl<SamplingMapper, Sampling> implements SamplingService {

}
