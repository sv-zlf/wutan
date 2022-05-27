package com.bf.wutan.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * <p>
 *  产品服务类
 * </p>
 *
 * @author bf
 * @since 2022-04-20
 */
public interface ProductService extends IService<Product> {

    /**
     * 添加产品
     *
     * @param product：产品信息
     * @return 是否添加成功
     */
    Boolean addProduct(Product product);

    /**
     * 根据产品名称删除产品
     *
     * @param name：产品名称
     * @return 是否成功删除产品
     */
    Boolean deleteProductByName(String name);

    /**
     * 更新产品信息
     *
     * @param product 产品信息
     * @return 是否成功更新产品信息
     */
    Boolean updateProduct(Product product);

    /**
     * 产品信息列表
     *
     * @param page mybatis分页
     * @return 产品列表
     */
    IPage<Product> getProductList(Page<Product> page);

    /**
     * 根据名称获取产品信息
     * @param name 产品名称
     * @return 产品信息
     */
    Product getProductByName(String name);

    /**
     * 获取产品总数
     *
     * @return 产品总数
     */
    Integer countProduct();

    /**
     * 获取指定应用场景类别的产品
     *
     * @param page mybatis分页
     * @param appTypeId 应用场景类别
     * @return 产品列表
     */
    IPage<Product> getProductByAppType(Page<Product> page,  Integer appTypeId);


    /**
     * 根据产品类别获取指定产品
     *
     * @param page mybatis分页
     * @param productTypeId 产品类别
     * @return 产品列表
     */
    IPage<Product> getProductByProductType(Page<Product> page,Integer productTypeId);
}
