package com.bf.wutan.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.News;
import com.bf.wutan.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2022-04-19
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Insert("insert into user(username,password,role,introduce,avatar) values(#{username},#{password},#{role},#{introduce},#{avatar})")
    Boolean createUser(User user);

    @Delete("delete from user where id=#{id}")
    Boolean deleteUserById(@Param("id") Integer id);

    @Update("update user set token=#{token} where username=#{username}")
    Boolean updateUserToken(@Param("username")String username,@Param("token")String token);

    @Update("update user set username=#{username},introduce=#{introduce},password=#{password},role=#{role} where id=#{id}")
    Boolean updateUser(User user);

    @Select("select * from user ")
    IPage<User> selectUsers(Page<User> page);

    @Select("select * from user where username=#{username} and password=#{password}")
    User loadUser(@Param("username")String username,@Param("password")String password);

    @Select("select * from user where username=#{username}")
    User selectUserByUsername(@Param("username")String username);

    @Select("select * from user where token=#{token}")
    User selectUserByToken(@Param("token")String token);
}
