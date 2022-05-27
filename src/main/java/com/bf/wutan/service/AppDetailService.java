package com.bf.wutan.service;

import com.bf.wutan.entity.AppDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  案例详情服务类
 * </p>
 *
 * @author bf
 * @since 2022-04-20
 */
public interface AppDetailService extends IService<AppDetail> {

    /**
     * 添加案例详情
     *
     * @param appDetail 案例详情信息
     * @return 是否添加案例详情
     */
    Boolean addAppDetail(AppDetail appDetail);

    /**
     * 根据名称删除案例
     *
     * @param appName 案例名称
     * @return 是否删除案例详情
     */
    Boolean deleteAppDetailByName(String appName);

    /**
     * 更新案例详情信息
     *
     * @param appDetail 案例详情信息
     * @return 是否更新案例详情
     */
    Boolean updateAppDetail(AppDetail appDetail);

    /**
     * 添加案例阅读量
     *
     * @param appName 案例名称
     * @return 是否添加案例阅读量
     */
    Boolean updateAppDetailReadCount(String appName);

    /**
     * 根据案例名称获取案例信息
     *
     * @param appName 案例名称
     * @return 是否获取案例信息
     */
    AppDetail getAppDetailByName(String appName);
}
