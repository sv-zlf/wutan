package com.bf.wutan.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.Message;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2022-05-06
 */
public interface MessageService extends IService<Message> {

    /**
     * 添加留言信息
     *
     * @param message 留言信息
     * @return 是否添加留言信息
     */
    Boolean addMessage(Message message);

    /**
     * 获取留言信息列表
     *
     * @param page mybatis分页
     * @return 留言信息列表
     */
    IPage<Message> getMessage(Page<Message> page);

}
