package com.geopark.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geopark.web.mapper.LegalMapper;
import com.geopark.web.model.entity.Legal;
import com.geopark.web.service.LegalService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 公园管理法律法规 服务实现类
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Service
public class LegalServiceImpl extends ServiceImpl<LegalMapper, Legal> implements LegalService {

}
