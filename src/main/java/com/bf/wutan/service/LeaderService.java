package com.bf.wutan.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.Leader;
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
public interface LeaderService extends IService<Leader> {

    /**
     * 添加领袖信息
     *
     * @param leader 领袖信息
     * @return 是否添加领袖
     */
    Boolean addLeader(Leader leader);

    /**
     * 根据姓名删除领袖信息
     *
     * @param name 姓名
     * @return 是否删除领袖
     */
    Boolean deleteLeaderByName(String name);

    /**
     * 更新领袖信息
     *
     * @param leader 领袖信息
     * @return 是否更新领袖信息
     */
    Boolean updateLeader(Leader leader);

    /**
     * 获取领袖信息列表
     *
     * @param page mybatis分页
     * @return 领袖信息列表
     */
    IPage<Leader> getLeaderList(Page<Leader> page);

    /**
     * 根据姓名获取领袖信息
     *
     * @param name 姓名
     * @return 领袖信息
     */
    Leader getLeaderByName(String name);

    /**
     * 获取所有团队信息
     *
     * @return 团队列表
     */
    List<Leader> getAllLeader();
}
