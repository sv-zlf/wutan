package com.bf.wutan.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2022-05-16
 */
public interface MemberService extends IService<Member> {

    /**
     * 添加团队成员
     *
     * @param member 团队成员信息
     * @return 是否添加团队成员
     */
    Boolean addMember(Member member);

    /**
     * 根据名称删除团队成员
     *
     * @param name 姓名
     * @return 是否删除团队成员
     */
    Boolean deleteMemberByName(String name);

    /**
     * 删除指定团队的团队成员
     *
     * @param teamId 团队编号
     * @return 是否删除指定团队成员
     */
    Boolean deleteMemberByTeamId(Integer teamId);

    /**
     * 更新团队成员信息
     *
     * @param member 团队成员
     * @return 是否更新团队成员
     */
    Boolean updateMember(Member member);

    /**
     * 获取指定团队的团队成员
     *
     * @param teamId 团队编号
     * @return 团队成员列表
     */
    List<Member> getMemberByTeamId(Integer teamId);

    /**
     * 根据姓名获取指定团圆信息
     *
     * @param name 姓名
     * @return 团队成员信息
     */
    Member getMemberByName(String name);

    /**
     * 获取团队成员列表
     *
     * @param page mybatis分页
     * @return 团队成员列表
     */
    IPage<Member> getMemberList(Page<Member> page);
}
