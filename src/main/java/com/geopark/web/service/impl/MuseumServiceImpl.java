package com.geopark.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geopark.web.mapper.MuseumMapper;
import com.geopark.web.model.entity.Museum;
import com.geopark.web.service.MuseumService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博物馆基本情况 服务实现类
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Service
public class MuseumServiceImpl extends ServiceImpl<MuseumMapper, Museum> implements MuseumService {

}
