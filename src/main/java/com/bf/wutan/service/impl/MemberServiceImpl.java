package com.bf.wutan.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.Member;
import com.bf.wutan.mapper.MemberMapper;
import com.bf.wutan.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2022-05-16
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    final MemberMapper memberMapper;

    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public Boolean addMember(Member member){
        return memberMapper.addMember(member);
    }

    @Override
    public Boolean deleteMemberByName(String name){
        return memberMapper.deleteMemberByName(name);
    }

    @Override
    public Boolean deleteMemberByTeamId(Integer teamId){
        return memberMapper.deleteMemberByTeamId(teamId);
    }

    @Override
    public Boolean updateMember(Member member){
        return memberMapper.updateMember(member);
    }

    @Override
    public List<Member> getMemberByTeamId(Integer teamId){
        return memberMapper.getMemberByTeamId(teamId);
    }

    @Override
    public Member getMemberByName(String name){
        return memberMapper.getMemberByName(name);
    }

    @Override
    public IPage<Member> getMemberList(Page<Member> page){
        return memberMapper.getMemberList(page);
    }
}
