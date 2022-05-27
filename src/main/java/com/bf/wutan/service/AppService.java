package com.bf.wutan.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.App;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bf
 * @since 2022-04-20
 */
public interface AppService extends IService<App> {


    /**
     * 添加案例
     *
     * @param app 案例信息
     * @return 是否添加案例
     */
    Boolean createApp(App app);

    /**
     * 根据案例名称删除案例
     *
     * @param name 案例名称
     * @return 是否删除案例
     */
    Boolean deleteAppByName(String name);

    /**
     * 更新案例信息
     *
     * @param app 案例信息
     * @return 是否更新案例
     */
    Boolean updateApp(App app);

    /**
     * 获取案例列表
     *
     * @param page mybatis分页
     * @return 案例列表
     */
    IPage<App> getApp(Page<App> page);

    /**
     * 根据案例名称获取案例信息
     *
     * @param name 案例名称
     * @return 案例
     */
    App getAppByName(String name);


    /**
     * 获取指定类型的案例列表
     *
     * @param page mybatis分页
     * @param typeId 应用场景类型
     * @return 案例列表
     */
    IPage<App> selectAppByAppType(Page<App> page,Integer typeId);

}
