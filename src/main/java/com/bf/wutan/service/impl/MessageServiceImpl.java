package com.bf.wutan.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.Message;
import com.bf.wutan.mapper.MessageMapper;
import com.bf.wutan.service.MessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bf.wutan.utils.DateUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2022-05-06
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

    final MessageMapper messageMapper;

    public MessageServiceImpl(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @Override
    public Boolean addMessage(Message message){
        message.setTime(DateUtils.getCurrentTime());
        return messageMapper.addMessage(message);
    }

    @Override
    public IPage<Message> getMessage(Page<Message> page){
        return messageMapper.getMessage(page);
    }


}
