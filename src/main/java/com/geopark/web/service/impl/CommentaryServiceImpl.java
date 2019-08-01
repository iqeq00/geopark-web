package com.geopark.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geopark.web.mapper.CommentaryMapper;
import com.geopark.web.model.entity.Commentary;
import com.geopark.web.service.CommentaryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标示解说系统 服务实现类
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Service
public class CommentaryServiceImpl extends ServiceImpl<CommentaryMapper, Commentary> implements CommentaryService {

}
