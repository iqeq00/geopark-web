package com.geopark.web.service.impl;

import com.geopark.web.model.entity.News;
import com.geopark.web.mapper.NewsMapper;
import com.geopark.web.service.NewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 新闻通讯 服务实现类
 * </p>
 *
 * @author lichee
 * @since 2019-07-19
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

}
