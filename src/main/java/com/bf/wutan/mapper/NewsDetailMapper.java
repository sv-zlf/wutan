package com.bf.wutan.mapper;

import com.bf.wutan.entity.NewsDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author bf
 * @since 2022-04-20
 */
@Mapper
public interface NewsDetailMapper extends BaseMapper<NewsDetail> {

    @Insert("insert into newsDetail(title,detail,read_count) values(#{title},#{detail},#{readCount})")
    Boolean createNewsDetail(NewsDetail newsDetail);

    @Delete("delete from newsDetail where title=#{title}")
    Boolean deleteNewsDetail(@Param("title") String title);

    @Update("update newsDetail set read_count=read_count+1 where title=#{title} ")
    Boolean updateNewsDetailReadCountByTitle(@Param("title") String title);

    @Update("update newsDetail set detail =#{detail} where title=#{title}")
    Boolean updateNewsDetail(NewsDetail newsDetail);

    @Select("select * from newsDetail where title=#{title}")
    NewsDetail getNewsDetailByTitle(@Param("title") String title);

    @Select("select read_count from newsDetail where title=#{title}")
    Integer getNewsDetailReadCountByTitle(@Param("title") String title);
}
