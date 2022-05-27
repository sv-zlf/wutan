package com.bf.wutan.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.AppType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2022-04-20
 */
@Mapper
public interface AppTypeMapper extends BaseMapper<AppType> {

    @Insert("insert into appType(typename,description,avatar) values(#{typename},#{description},#{avatar}) ")
    Boolean createAppType(AppType appType);

    @Delete("delete from appType where typename=#{typename}")
    Boolean deleteAppTypeByName(@Param("typename") String typename);

    @Update("update appType set description=#{description},avatar=#{avatar} ,typename=#{typename} where id=#{id}")
    Boolean updateAppType(AppType appType);

    @Select("select * from appType")
    IPage<AppType> getAppType(Page<AppType> page);

    @Select("select * from appType")
    List<AppType> getAppTypes();

    @Select("select * from appType where typename=#{typename}")
    AppType getAppTypeByName(@Param("typename") String typename);

    @Select("select * from appType where id=#{id}")
    AppType getAppTypeById(@Param("id") Integer id);
}
