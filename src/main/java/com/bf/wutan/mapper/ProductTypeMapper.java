package com.bf.wutan.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.ProductType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2022-04-27
 */
@Mapper
public interface ProductTypeMapper extends BaseMapper<ProductType> {

    @Insert("insert into productType(typename,description) values(#{typename},#{description})")
    Boolean addProductType(ProductType productType);

    @Delete("delete from productType where typename=#{typename}")
    Boolean deleteProductTypeByName(@Param("typename") String typename );

    @Update("update productType set typename=#{typename},description=#{description} where id=#{id}")
    Boolean updateProductType(ProductType productType);

    @Select("select *from productType ")
    IPage<ProductType> getProductTypeList(Page<ProductType> page);

    @Select("select * from productType")
    List<ProductType> getProductTypeAll();

    @Select("select * from productType where id=#{id}")
    ProductType getProductTypeById(@Param("id") Integer id);

    @Select("select * from productType where typename=#{typename}")
    ProductType getProductTypeByName(@Param("typename")String typename);
}
