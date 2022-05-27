package com.bf.wutan.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.AppType;
import com.bf.wutan.mapper.AppTypeMapper;
import com.bf.wutan.service.AppTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bf
 * @since 2022-04-20
 */
@Service
public class AppTypeServiceImpl extends ServiceImpl<AppTypeMapper, AppType> implements AppTypeService {

    final AppTypeMapper appTypeMapper;

    public AppTypeServiceImpl(AppTypeMapper appTypeMapper) {
        this.appTypeMapper = appTypeMapper;
    }

    @Override
    public Boolean createAppType(AppType appType){
        return appTypeMapper.createAppType(appType);
    }

    @Override
    public Boolean deleteAppTypeByName(String name){
        return appTypeMapper.deleteAppTypeByName(name);
    }

    @Override
    public Boolean updateAppType(AppType appType){
        return appTypeMapper.updateAppType(appType);
    }

    @Override
    public IPage<AppType> getAppType(Page<AppType> page){
        return appTypeMapper.getAppType(page);
    }

    @Override
    public List<AppType> getAppTypes(){
        return appTypeMapper.getAppTypes();
    }

    @Override
    public  AppType getAppTypeByName(String typename){
        return appTypeMapper.getAppTypeByName(typename);
    }

    @Override
    public AppType getAppTypeById(Integer id){
        return appTypeMapper.getAppTypeById(id);
    }
}
