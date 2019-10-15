package com.geopark.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geopark.framework.converter.BeanConverter;
import com.geopark.framework.excel.data.GeolandscapeData;
import com.geopark.web.mapper.GeolandscapeMapper;
import com.geopark.web.model.entity.Geolandscape;
import com.geopark.web.service.GeolandscapeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 地质遗迹景点 服务实现类
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Service
public class GeolandscapeServiceImpl extends ServiceImpl<GeolandscapeMapper, Geolandscape> implements GeolandscapeService {

    @Override
    public List<GeolandscapeData> getData() {
        List<Geolandscape> list = lambdaQuery().list();
        return BeanConverter.convert(GeolandscapeData.class, list);
    }
}
