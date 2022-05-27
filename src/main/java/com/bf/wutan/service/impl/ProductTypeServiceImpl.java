package com.bf.wutan.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.ProductType;
import com.bf.wutan.mapper.ProductTypeMapper;
import com.bf.wutan.service.ProductTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bf
 * @since 2022-04-27
 */
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements ProductTypeService {

    final ProductTypeMapper productTypeMapper;

    public ProductTypeServiceImpl(ProductTypeMapper productTypeMapper) {
        this.productTypeMapper = productTypeMapper;
    }

    @Override
    public Boolean addProductType(ProductType productType){
        return productTypeMapper.addProductType(productType);
    }

    @Override
    public  Boolean deleteProductTypeByName( String typename ){
        return productTypeMapper.deleteProductTypeByName(typename);
    }

    @Override
    public Boolean updateProductType(ProductType productType){
        return productTypeMapper.updateProductType(productType);
    }

    @Override
    public IPage<ProductType> getProductTypeList(Page<ProductType> page){
        return productTypeMapper.getProductTypeList(page);
    }

    @Override
    public List<ProductType> getProductTypeAll(){
        return productTypeMapper.getProductTypeAll();
    }

    @Override
    public ProductType getProductTypeById(Integer id){
        return productTypeMapper.getProductTypeById(id);
    }

    @Override
    public ProductType getProductTypeByName(String typename){
        return productTypeMapper.getProductTypeByName(typename);
    }
}
