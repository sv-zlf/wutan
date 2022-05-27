package com.bf.wutan.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.Product;
import com.bf.wutan.mapper.ProductMapper;
import com.bf.wutan.service.ProductService;
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
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    final ProductMapper productMapper;

    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public Boolean addProduct(Product product){
        return productMapper.addProduct(product);
    }

    @Override
    public Boolean updateProduct(Product product){
        return productMapper.updateProduct(product);
    }

    @Override
    public IPage<Product> getProductList(Page<Product> page){
        return productMapper.getProductList(page);
    }

    @Override
    public Product getProductByName(String name){
        return productMapper.getProductByName(name);
    }

    @Override
    public Integer countProduct(){
        return productMapper.countProduct();
    }

    @Override
    public Boolean deleteProductByName(String name){
        return productMapper.deleteProductByName(name);
    }

    @Override
    public IPage<Product> getProductByAppType(Page<Product> page,  Integer appTypeId){
        return productMapper.getProductByAppType(page,appTypeId);
    }

    @Override
    public  IPage<Product> getProductByProductType(Page<Product> page,Integer productTypeId){
        return productMapper.getProductByProductType(page,productTypeId);
    }
}
