package com.bf.wutan.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2022-05-06
 */
@Mapper
public interface MessageMapper extends BaseMapper<Message> {

    @Insert("insert into message(name,phone,email,advice,time) values(#{name},#{phone},#{email},#{advice},#{time})")
    Boolean addMessage(Message message);

    @Select("select * from message")
    IPage<Message> getMessage(Page<Message> page);

    @Select("select count(*) from message")
    Integer getMessageCount();
}
