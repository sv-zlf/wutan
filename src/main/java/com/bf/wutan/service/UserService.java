package com.bf.wutan.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bf.wutan.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  用户服务类
 * </p>
 *
 * @author bf
 * @since 2022-04-19
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param user 用户信息
     * @return 是否添加用户信息
     */
    Boolean createUser(User user);

    /**
     * 登陆
     *
     * @param username 用户名称
     * @param password 用户密码
     * @return 用户信息
     */
    User loadUser(String username,String password);

    /**
     * 检测是否存在该用户名
     *
     * @param username 用户名称
     * @return 用户信息
     */
    User selectUserByUsername(String username);

    /**
     * 更新用户token
     *
     * @param username 用户名称
     * @param token token
     * @return 是否更新token
     */
    Boolean updateUserToken(String username,String token);

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     * @return 是否更新用户信息
     */
    Boolean updateUser(User user);

    /**
     * 获取指定token用户信息
     *
     * @param token 连接标示
     * @return 用户信息
     */
    User selectUserByToken(String token);

    /**
     * 获取用户信息列表
     *
     * @param page mybatis分页
     * @return 用户信息列表
     */
    IPage<User> selectUsers(Page<User> page);

    /**
     * 根据编号删除用户信息
     *
     * @param id 编号
     * @return 是否删除用户
     */
    Boolean deleteUserById(Integer id);
}
