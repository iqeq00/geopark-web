package com.geopark.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geopark.web.mapper.ProductionMapper;
import com.geopark.web.model.entity.Production;
import com.geopark.web.service.ProductionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品推介 服务实现类
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Service
public class ProductionServiceImpl extends ServiceImpl<ProductionMapper, Production> implements ProductionService {

}
