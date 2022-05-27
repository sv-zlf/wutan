package com.bf.wutan.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.AppType;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  应用场景类型服务类
 * </p>
 *
 * @author bf
 * @since 2022-04-20
 */
public interface AppTypeService extends IService<AppType> {

    /**
     *添加应用场景类型
     *
     * @param appType 应用场景类型
     * @return 是否添加应用场景类型
     */
    Boolean createAppType(AppType appType);

    /**
     * 根据名称删除应用场景类型
     *
     * @param name 应用场景名称
     * @return 是否删除应用场景
     */
    Boolean deleteAppTypeByName(String name);

    /**
     * 更新应用场景类型信息
     *
     * @param appType 应用场景类型
     * @return 是否更新应用场景类型
     */
    Boolean updateAppType(AppType appType);

    /**
     * 获取应用场景类型列表
     *
     * @param page mybatis分页
     * @return 应用场景类型列表
     */
    IPage<AppType> getAppType(Page<AppType> page);

    /**
     * 获取所有应用场景类型
     *
     * @return 应用场景类型列表
     */
    List<AppType> getAppTypes();

    /**
     * 根据名称获取应用场景类型
     *
     * @param typename 应用场景类型名称
     * @return 应用场景类型
     */
    AppType getAppTypeByName(String typename);

    /**
     * 根据id获取应用场景类型
     *
     * @param id 主键
     * @return 应用场景类型
     */
    AppType getAppTypeById(Integer id);
}
