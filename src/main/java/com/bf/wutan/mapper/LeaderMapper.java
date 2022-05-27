package com.bf.wutan.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.Leader;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2022-05-16
 */
@Mapper
public interface LeaderMapper extends BaseMapper<Leader> {


    @Insert("insert into leader(name,team_name,description,avatar,detail) values(#{name},#{teamName},#{description},#{avatar},#{detail})")
    Boolean addLeader(Leader leader);

    @Delete("delete from leader where team_name=#{teamName}")
    Boolean deleteLeaderByTeamName(@Param("teamName") String teamName);

    @Delete("delete from leader where name=#{name}")
    Boolean deleteLeaderByName(@Param("name") String name);

    @Update("update leader set team_name=#{teamName},description=#{description},avatar=#{avatar},detail=#{detail}  where name=#{name}")
    Boolean updateLeader(Leader leader);

    @Select("select* from leader")
    IPage<Leader> getLeaderList(Page<Leader> page);

    @Select("select * from leader where name=#{name}")
    Leader getLeaderByName(@Param("name")String name);

    @Select("select * from leader")
    List<Leader> getAllLeader();
}
