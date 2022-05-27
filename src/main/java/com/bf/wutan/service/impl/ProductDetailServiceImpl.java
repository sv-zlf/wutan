package com.bf.wutan.service.impl;

import com.bf.wutan.entity.ProductDetail;
import com.bf.wutan.mapper.ProductDetailMapper;
import com.bf.wutan.service.ProductDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class ProductDetailServiceImpl extends ServiceImpl<ProductDetailMapper, ProductDetail> implements ProductDetailService {

    final ProductDetailMapper productDetailMapper;

    public ProductDetailServiceImpl(ProductDetailMapper productDetailMapper) {
        this.productDetailMapper = productDetailMapper;
    }

    @Override
    public Boolean addProductDetail(ProductDetail productDetail){
        return productDetailMapper.addProductDetail(productDetail);
    }

    @Override
    public Boolean deleteProductDetailByName(String name){
        return productDetailMapper.deleteProductDetailByName(name);
    }

    @Override
    public Boolean updateProductDetail(ProductDetail productDetail){
        return productDetailMapper.updateProductDetail(productDetail);
    }

    @Override
    public  ProductDetail getProductDetailByName(String name){
        return productDetailMapper.getProductDetailByName(name);
    }
}
