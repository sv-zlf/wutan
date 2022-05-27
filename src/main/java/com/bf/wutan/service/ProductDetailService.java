package com.bf.wutan.service;

import com.bf.wutan.entity.ProductDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bf
 * @since 2022-04-20
 */
public interface ProductDetailService extends IService<ProductDetail> {

    /**
     * 添加产品详情
     *
     * @param productDetail 产品详情
     * @return 是否添加产品详情
     */
    Boolean addProductDetail(ProductDetail productDetail);

    /**
     *根据产品名称删除产品信息
     *
     * @param name 产品名称
     * @return 是否删除产品信息
     */
    Boolean deleteProductDetailByName(String name);

    /**
     * 更新产品详情
     *
     * @param productDetail 产品详情
     * @return 是否更新产品详情
     */
    Boolean updateProductDetail(ProductDetail productDetail);

    /**
     * 根据产品名称获取产品信息
     *
     * @param name 产品名称
     * @return 产品详情信息
     */
    ProductDetail getProductDetailByName(String name);
}
