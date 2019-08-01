package com.geopark.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geopark.web.mapper.ParkinfoMapper;
import com.geopark.web.model.entity.Parkinfo;
import com.geopark.web.service.ParkinfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 公园信息管理 服务实现类
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Service
public class ParkinfoServiceImpl extends ServiceImpl<ParkinfoMapper, Parkinfo> implements ParkinfoService {

}
