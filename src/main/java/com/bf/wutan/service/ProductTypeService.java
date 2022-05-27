package com.bf.wutan.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.ProductType;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2022-04-27
 */
public interface ProductTypeService extends IService<ProductType> {

    /**
     * 添加产品类别
     *
     * @param productType 产品类别
     * @return 是否添加产品类别
     */
    Boolean addProductType(ProductType productType);

    /**
     * 根据类别名称删除产品类别
     *
     * @param typename 产品类别名称
     * @return 是否删除产品类别
     */
    Boolean deleteProductTypeByName( String typename );

    /**
     * 更新产品类别信息
     *
     * @param productType 产品类别
     * @return 是否更新产品类别
     */
    Boolean updateProductType(ProductType productType);

    /**
     * 获取产品类别列表
     *
     * @param page mybatis分页
     * @return 产品类别列表
     */
    IPage<ProductType> getProductTypeList(Page<ProductType> page);

    /**
     * 获取所有产品类别
     *
     * @return 产品类别列表
     */
    List<ProductType> getProductTypeAll();

    /**
     * 根据编号获取指定产品类别信息
     *
     * @param id 编号
     * @return 产品类别
     */
    ProductType getProductTypeById(Integer id);

    /**
     * 根据名称获取产品类别信息
     *
     * @param typename 名称
     * @return 产品类别
     */
    ProductType getProductTypeByName(String typename);
}
