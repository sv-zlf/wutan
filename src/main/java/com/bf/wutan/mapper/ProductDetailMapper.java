package com.bf.wutan.mapper;

import com.bf.wutan.entity.Product;
import com.bf.wutan.entity.ProductDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface ProductDetailMapper extends BaseMapper<ProductDetail> {

    @Insert("insert into productDetail(name,detail) values(#{name},#{detail})")
    Boolean addProductDetail(ProductDetail productDetail);

    @Delete("delete from productDetail where name=#{name}")
    Boolean deleteProductDetailByName(@Param("name") String name);

    @Update("update productDetail set detail=#{detail} where name=#{name} ")
    Boolean updateProductDetail(ProductDetail productDetail);

    @Select("select * from productDetail where name=#{name}")
    ProductDetail getProductDetailByName(@Param("name") String name);
}
