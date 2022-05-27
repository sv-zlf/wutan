package com.bf.wutan.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.App;
import com.bf.wutan.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jdk.jfr.BooleanFlag;
import org.apache.ibatis.annotations.*;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2022-04-20
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    @Insert("insert into product(name,description,app_typeid,product_typeid,avatar) values(#{name},#{description},#{appTypeid},#{productTypeid},#{avatar})")
    Boolean addProduct(Product product);

    @Delete("delete from product where name=#{name}")
    Boolean deleteProductByName(@Param("name") String name);

    @Update("update product set description=#{description},app_typeid=#{appTypeid},product_typeid=#{productTypeid},avatar=#{avatar} where name=#{name}")
    Boolean updateProduct(Product product);

    @Select("select * from product ")
    IPage<Product> getProductList(Page<Product> page);

    @Select("select * from product where name=#{name}")
    Product getProductByName(@Param("name") String name);

    @Select("select * from product where app_typeid=#{appTypeid} ")
    IPage<Product> getProductByAppType(Page<Product> page, @Param("appTypeid") Integer appTypeid);

    @Select("select * from product where product_typeid=#{productTypeid} ")
    IPage<Product> getProductByProductType(Page<Product> page, @Param("productTypeid") Integer productTypeid);

    @Select("select count(*) from product")
    Integer countProduct();
}
