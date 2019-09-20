package com.geopark.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geopark.web.mapper.PlanningMapper;
import com.geopark.web.model.entity.Planning;
import com.geopark.web.service.PlanningService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 公园规划 服务实现类
 * </p>
 *
 * @author lichee
 * @since 2019-09-20
 */
@Service
public class PlanningServiceImpl extends ServiceImpl<PlanningMapper, Planning> implements PlanningService {

}
