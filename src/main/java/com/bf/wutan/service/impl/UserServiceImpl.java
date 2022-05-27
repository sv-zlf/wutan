package com.bf.wutan.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.User;
import com.bf.wutan.mapper.UserMapper;
import com.bf.wutan.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2022-04-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Boolean createUser(User user){
        return userMapper.createUser(user);
    }

    @Override
    public User loadUser(String username,String password){
        return userMapper.loadUser(username,password);
    }

    @Override
    public  User selectUserByUsername(String username){
        return userMapper.selectUserByUsername(username);
    }

    @Override
    public Boolean updateUserToken(String username,String token){
        return userMapper.updateUserToken(username,token);
    }

    @Override
    public User selectUserByToken(String token){
        return userMapper.selectUserByToken(token);
    }

    @Override
    public IPage<User> selectUsers(Page<User> page){
        return userMapper.selectUsers(page);
    }

    @Override
    public Boolean deleteUserById(Integer id){
        return userMapper.deleteUserById(id);
    }

    @Override
    public Boolean updateUser(User user){
        return userMapper.updateUser(user);
    }
}
