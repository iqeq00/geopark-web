package com.geopark.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.geopark.framework.excel.data.GeolandscapeData;
import com.geopark.web.model.entity.Geolandscape;

import java.util.List;

/**
 * <p>
 * 地质遗迹景点 服务类
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
public interface GeolandscapeService extends IService<Geolandscape> {

    List<GeolandscapeData> getData();
}
