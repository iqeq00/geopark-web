package com.geopark.web.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geopark.framework.converter.BeanConverter;
import com.geopark.framework.enums.ErrorCodeEnum;
import com.geopark.framework.enums.MenuTypeEnum;
import com.geopark.framework.enums.StatusEnum;
import com.geopark.framework.utils.ApiAssert;
import com.geopark.framework.utils.ApiUtils;
import com.geopark.framework.utils.TreeUtils;
import com.geopark.framework.utils.TypeUtils;
import com.geopark.web.mapper.SysMenuMapper;
import com.geopark.web.model.entity.SysMenu;
import com.geopark.web.model.entity.SysMenuResource;
import com.geopark.web.model.vo.MenuTreeVo;
import com.geopark.web.model.vo.MenuVo;
import com.geopark.web.service.SysMenuResourceService;
import com.geopark.web.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author lichee
 * @since 2019-07-31
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysMenuResourceService menuResourceService;



    @Override
    public List<MenuTreeVo> getUserPermMenus(Integer uid) {

        List<MenuTreeVo> menus = baseMapper.getUserPermMenus(uid, StatusEnum.NORMAL, Arrays.asList(MenuTypeEnum.CATALOG, MenuTypeEnum.MENU));
        return menus.stream().filter(e -> !parentIdNotNull(e.getParentId())).map(e -> TreeUtils.findChildren(e, menus)).collect(Collectors.toList());
    }

    /**
     * 父ID不为0并且不为空
     *
     * @param parentId
     * @return
     */
    private boolean parentIdNotNull(Integer parentId) {
        return Objects.nonNull(parentId) && parentId != 0;
    }

    @Override
    @Transactional
    public void updateStatus(Integer menuId, StatusEnum status) {

        SysMenu menu = getById(menuId);
        if (null != menu) {
            menu.setStatus(status);
            updateById(menu);
        }
    }

    @Override
    public MenuVo getMenuVoDetails(Integer menuId) {

        SysMenu menu = getById(menuId);
        if (null != menu) {
            MenuVo menuVo = BeanConverter.convert(MenuVo.class, menu);
            List<SysMenuResource> list = menuResourceService.lambdaQuery()
                    .select(SysMenuResource::getResourceId).eq(SysMenuResource::getMenuId, menuId).list();
            List<String> resourceIds = new ArrayList<>();
            list.forEach(menuResource -> {
                resourceIds.add(menuResource.getResourceId());
            });
            menuVo.setResourceIds(resourceIds);
            return menuVo;
        }
        return null;
    }


    @Override
    @Transactional
    public void saveMenu(SysMenu menu, List<String> resourceIds) {
        menu.setCreateTime(LocalDateTime.now());
        menu.setCreateUid(ApiUtils.currentUid());
        menu.setUpdateTime(LocalDateTime.now());
        menu.setUpdateUid(ApiUtils.currentUid());
        save(menu);
        if (CollectionUtils.isNotEmpty(resourceIds)) {
            Integer menuId = menu.getId();
            //添加resource关联
            menuResourceService.saveBatch(menuResourceService.getMenuResources(menuId, resourceIds));
        }
    }

    @Override
    @Transactional
    public void updateMenu(SysMenu menu, List<String> resourceIds) {
        menu.setUpdateTime(LocalDateTime.now());
        menu.setUpdateUid(ApiUtils.currentUid());
        updateById(menu);
        if (CollectionUtils.isNotEmpty(resourceIds)) {
            Integer menuId = menu.getId();
            //删除resource关联
            menuResourceService.removeByMenuId(menuId);
            //添加resource关联
            menuResourceService.saveBatch(menuResourceService.getMenuResources(menuId, resourceIds));
        }
    }

    @Override
    @Transactional
    public void removeMenu(Integer menuId) {
        if (parentIdNotNull(menuId)) {
            lambdaQuery().eq(SysMenu::getParentId, menuId).list().stream()
                    .filter(e -> parentIdNotNull(e.getParentId()))
                    .forEach(e -> removeMenu(e.getId()));
            //删除resource关联
            menuResourceService.removeByMenuId(menuId);
            //删除菜单
            removeById(menuId);
        }

    }

}