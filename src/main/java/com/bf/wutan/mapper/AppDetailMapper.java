package com.bf.wutan.mapper;

import com.bf.wutan.entity.App;
import com.bf.wutan.entity.AppDetail;
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
public interface AppDetailMapper extends BaseMapper<AppDetail> {

    @Insert("insert into appDetail(appname,detail,time,read_count) values(#{appname},#{detail},#{time},#{readCount})")
    Boolean addAppDetail(AppDetail appDetail);

    @Delete("delete from appDetail where appname=#{appname}")
    Boolean deleteAppDetailByname(@Param("appname") String appname);
    
    @Update("update appDetail set detail=#{detail},time=#{time} where appname=#{appname}")
    Boolean updateAppDetail(AppDetail appDetail);

    @Update("update appDetail set read_count=read_count+1 where appname=#{appname}")
    Boolean updateAppDetailReadCount(@Param("appname") String appname);

    @Select("select * from appDetail where appname=#{appname}")
    AppDetail getAppDetailByname(@Param("appname") String appname);
    

}
