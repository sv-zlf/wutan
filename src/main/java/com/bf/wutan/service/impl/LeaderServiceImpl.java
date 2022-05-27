package com.bf.wutan.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.Leader;
import com.bf.wutan.mapper.LeaderMapper;
import com.bf.wutan.service.LeaderService;
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
public class LeaderServiceImpl extends ServiceImpl<LeaderMapper, Leader> implements LeaderService {


    final LeaderMapper leaderMapper;

    public LeaderServiceImpl(LeaderMapper leaderMapper) {
        this.leaderMapper = leaderMapper;
    }


    @Override
    public Boolean addLeader(Leader leader){
        return leaderMapper.addLeader(leader);
    }



    @Override
    public Boolean deleteLeaderByName(String name){
        return leaderMapper.deleteLeaderByName(name);
    }

    @Override
    public Boolean updateLeader(Leader leader){
        return leaderMapper.updateLeader(leader);
    }

    @Override
    public IPage<Leader> getLeaderList(Page<Leader> page){
        return leaderMapper.getLeaderList(page);
    }

    @Override
    public Leader getLeaderByName(String name){
        return leaderMapper.getLeaderByName(name);
    }

    @Override
    public List<Leader> getAllLeader(){
        return leaderMapper.getAllLeader();
    }

}
