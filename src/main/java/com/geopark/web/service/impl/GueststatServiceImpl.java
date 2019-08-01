package com.geopark.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geopark.web.mapper.GueststatMapper;
import com.geopark.web.model.entity.Gueststat;
import com.geopark.web.service.GueststatService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 游客统计 服务实现类
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Service
public class GueststatServiceImpl extends ServiceImpl<GueststatMapper, Gueststat> implements GueststatService {

}
