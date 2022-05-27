package com.bf.wutan.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.App;
import com.bf.wutan.mapper.AppMapper;
import com.bf.wutan.service.AppService;
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
public class AppServiceImpl extends ServiceImpl<AppMapper, App> implements AppService {

    final AppMapper appMapper;

    public AppServiceImpl(AppMapper appMapper) {
        this.appMapper = appMapper;
    }

    @Override
    public Boolean createApp(App app){
        return appMapper.createApp(app);
    }

    @Override
    public Boolean deleteAppByName(String name){
        return appMapper.deleteAppByName(name);
    }

    @Override
    public Boolean updateApp(App app){
        return appMapper.updateApp(app);
    }

    @Override
    public IPage<App> getApp(Page<App> page){
        return appMapper.getApp(page);
    }

    @Override
    public App getAppByName(String appname){
        return appMapper.getAppByName(appname);
    }


    @Override
    public  IPage<App> selectAppByAppType(Page<App> page,Integer typeid){
        return appMapper.selectAppByAppType(page,typeid);
    }

}
