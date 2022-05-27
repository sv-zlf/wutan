package com.bf.wutan.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.App;
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
public interface AppMapper extends BaseMapper<App> {

    @Insert("insert into app(appname,avatar,description,typeid) values(#{appname},#{avatar},#{description},#{typeid})")
    Boolean createApp(App app);

    @Delete("delete from app where appname=#{appname}")
    Boolean deleteAppByName(@Param("appname")String appname);

    @Update("update app set  description=#{description},avatar=#{avatar},typeid=#{typeid} where appname=#{appname} ")
    Boolean updateApp(App app);

    @Select("select * from app")
    IPage<App> getApp(Page<App> page);

    @Select("select * from app where appname=#{appname}")
    App getAppByName(@Param("appname") String appname);

    @Select("select * from app")
    List<App> getAllApp();

    @Select("select * from app where typeid=#{typeid} ")
    IPage<App> selectAppByAppType(Page<App> page, @Param("typeid") Integer typeid);

    @Select("select count(*) from app")
    Integer countApp();
}
