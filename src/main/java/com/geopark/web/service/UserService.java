package com.geopark.web.service;

import com.geopark.web.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.geopark.web.model.vo.TokenVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author lichee
 * @since 2019-07-18
 */
public interface UserService extends IService<User> {


}
