package com.geopark.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geopark.web.mapper.SysRoleMenuMapper;
import com.geopark.web.model.entity.SysMenuResource;
import com.geopark.web.model.entity.SysRoleMenu;
import com.geopark.web.service.SysRoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色菜单关系表 服务实现类
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

    @Override
    @Transactional
    public void saveRoleMenu(Integer roleId, List<Integer> menuIds) {

//        remove(lambdaQuery().eq(SysRoleMenu::getRoleId, roleId));
        List<SysRoleMenu> list = lambdaQuery().eq(SysRoleMenu::getRoleId, roleId).list();
        List<Integer> ids = new ArrayList<>();
        list.forEach(val -> {
            ids.add(val.getId());
        });
        if(ids.size()>0) {
            removeByIds(ids);
        }
        saveBatch(menuIds.stream().map(menuId -> new SysRoleMenu(roleId, menuId)).collect(Collectors.toList()));
    }
}
