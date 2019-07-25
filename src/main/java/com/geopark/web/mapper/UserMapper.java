package com.geopark.web.mapper;

import com.geopark.web.model.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统用户表 Mapper 接口
 * </p>
 *
 * @author lichee
 * @since 2019-07-18
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
