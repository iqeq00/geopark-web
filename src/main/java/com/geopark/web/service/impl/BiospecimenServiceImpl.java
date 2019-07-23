package com.geopark.web.service.impl;

import com.geopark.web.model.entity.Biospecimen;
import com.geopark.web.mapper.BiospecimenMapper;
import com.geopark.web.service.BiospecimenService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 生物标本 服务实现类
 * </p>
 *
 * @author lichee
 * @since 2019-07-18
 */
@Service
public class BiospecimenServiceImpl extends ServiceImpl<BiospecimenMapper, Biospecimen> implements BiospecimenService {

}
