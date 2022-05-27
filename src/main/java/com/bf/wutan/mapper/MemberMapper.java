package com.bf.wutan.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.Leader;
import com.bf.wutan.entity.Member;
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
public interface MemberMapper extends BaseMapper<Member> {

    @Insert("insert into member(name,description,avatar,detail,team_id) values(#{name},#{description},#{avatar},#{detail},#{teamId})")
    Boolean addMember(Member member);

    @Delete("delete from member where name=#{name}")
    Boolean deleteMemberByName(@Param("name")String name);

    @Delete("delete from member where team_id=#{teamId}")
    Boolean deleteMemberByTeamId(@Param("teamId")Integer teamId);

    @Update("update member set description=#{description},avatar=#{avatar},detail=#{detail},team_id=#{teamId} where name=#{name}")
    Boolean updateMember(Member member);

    @Select("select * from member")
    IPage<Member> getMemberList(Page<Member> page);

    @Select("select * from member where team_id =#{teamId}")
    List<Member> getMemberByTeamId(@Param("teamId")Integer teamId);

    @Select("select * from member where name=#{name}")
    Member getMemberByName(@Param("name") String name);
}
