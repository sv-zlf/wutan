package com.bf.wutan.service.impl;

import com.bf.wutan.entity.AppDetail;
import com.bf.wutan.mapper.AppDetailMapper;
import com.bf.wutan.service.AppDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bf.wutan.utils.DateUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2022-04-20
 */
@Service
public class AppDetailServiceImpl extends ServiceImpl<AppDetailMapper, AppDetail> implements AppDetailService {

    final AppDetailMapper appDetailMapper;

    public AppDetailServiceImpl(AppDetailMapper appDetailMapper) {
        this.appDetailMapper = appDetailMapper;
    }

    @Override
    public Boolean addAppDetail(AppDetail appDetail){
        appDetail.setReadCount(0);
        appDetail.setTime(DateUtils.getCurrentTime());
        return appDetailMapper.addAppDetail(appDetail);
    }

    @Override
    public Boolean deleteAppDetailByName(String appName){
        return appDetailMapper.deleteAppDetailByname(appName);
    }

    @Override
    public Boolean updateAppDetail(AppDetail appDetail){
        appDetail.setTime(DateUtils.getCurrentTime());
        return appDetailMapper.updateAppDetail(appDetail);
    }

    @Override
    public Boolean updateAppDetailReadCount(String appname){
        return appDetailMapper.updateAppDetailReadCount(appname);
    }

    @Override
    public AppDetail getAppDetailByName(String appName){
        return appDetailMapper.getAppDetailByname(appName);
    }
}
