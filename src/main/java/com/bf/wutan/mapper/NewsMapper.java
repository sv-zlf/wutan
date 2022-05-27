package com.bf.wutan.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.News;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2022-04-19
 */
@Mapper
public interface NewsMapper extends BaseMapper<News> {

    @Insert("insert into news(title,description,update_time,state,avatar) values(#{title},#{description},#{updateTime},#{state},#{avatar})")
    Boolean createNews(News news);

    @Delete("delete from news where title=#{title}")
    Boolean deleteNewsByTitle(@Param("title") String title);

    @Delete("delete from news where id=#{id}")
    Boolean deleteNewsById(@Param("id") Integer id);

    @Update("update news set description=#{description},update_time=#{updateTime},avatar=#{avatar} where title=#{title}")
    Boolean updateNews(News news);

    @Update("update news set state= NOT state where title=#{title}")
    Boolean updateNewsStatus(@Param("title") String title);

    @Select("select * from news order by update_time desc")
    IPage<News> getNews(Page<News> page);

    @Select("select * from news where id=#{id}")
    IPage<News> setNewsById(Page<News> page,@Param("id") Integer id);

    @Select("select * from news where title=#{title}")
    News setNewsByTitle(@Param("title") String title);

    @Select("select count(*) from news")
    Integer countNews();
}
