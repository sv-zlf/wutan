package com.bf.wutan.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.config.GlobalResult;
import com.bf.wutan.entity.User;
import com.bf.wutan.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * <p>
 *  用户前端控制器
 * </p>
 *
 * @author bf
 * @since 2022-04-19
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
@Api(tags = "用户管理")
public class UserController {

    final UserService userService;

    private GlobalResult result;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ApiOperation(value = "注册用户",notes = "id省略")
    public GlobalResult register(@RequestBody User user) {
        if(userService.selectUserByUsername(user.getUsername())!=null){

            result=GlobalResult.errorMsg("该用户名已存在无法注册");
            return result;
        }
        try {
            if(userService.createUser(user)){
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("注册失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }
    @PostMapping("/login")
    @ApiOperation(value = "用户登陆",notes = "id省略")
    public GlobalResult login(String username,String password) {

        try {
            User user =userService.loadUser(username,password);
            if(user!=null){
                String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
                if(userService.updateUserToken(username,token)){
                    result=GlobalResult.ok(token);
                }
                else{
                    result=GlobalResult.errorMsg("更新token失败");
                }
            }
            else{
                if(userService.selectUserByUsername(username)==null){
                    result=GlobalResult.errorMsg("该用户不存在，请重新输入!");
                }
                else {
                    result=GlobalResult.errorMsg("用户密码输入错误");
                }
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @PostMapping("/logout")
    @ApiOperation(value = "登出用户")
    public GlobalResult logout(){
        return GlobalResult.ok();
    }

    @DeleteMapping("/id/{id}")
    @ApiOperation(value = "获取用户列表",notes = "全部用户")
    public GlobalResult deleteUserById(@PathVariable Integer id){

        try {
            if(userService.deleteUserById(id)){
              result=GlobalResult.ok();
            }
            else{
                result=GlobalResult.errorMsg("用户删除失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @PutMapping("")
    @ApiOperation(value = "更新用户信息",notes = "指定id用户")
    public GlobalResult updateUser(@RequestBody User user){

        if(userService.selectUserByUsername(user.getUsername())!=null){
            result=GlobalResult.errorMsg("该用户名已存在");
            return result;
        }

        try {
            if(userService.updateUser(user)){
                result=GlobalResult.ok();
            }
            else{
                result=GlobalResult.errorMsg("更新用户信息失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }
    @GetMapping("")
    @ApiOperation(value = "获取用户列表",notes = "全部用户")
    public GlobalResult selectUsers(Integer pageIndex,Integer pageSize){

        Page<User> page = new Page<>(pageIndex, pageSize);
        try {
            IPage<User> data = userService.selectUsers(page);
            if(data!=null){
                result= GlobalResult.build(200, String.valueOf(data.getTotal()), data.getRecords());
            }
            else{
                result=GlobalResult.errorMsg("获取用户列表失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @GetMapping("/username/{username}")
    @ApiOperation(value = "获取用户信息",notes = "根据用户名称获取用户信息")
    public GlobalResult selectUserByusername(@PathVariable String username){

        try {
            User user=userService.selectUserByUsername(username);
            if(user!=null){
                result=GlobalResult.ok(user);
            }
            else {
                result=GlobalResult.errorMsg("获取用户列表失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @GetMapping("/token/{token}")
    @ApiOperation(value = "获取用户信息",notes = "通过token获取用户信息")
    public GlobalResult selectUserByToken(@PathVariable String token){

        try {
            User user=userService.selectUserByToken(token);
            if(user!=null){
                result=GlobalResult.ok(user);
            }
            else {
                result=GlobalResult.errorMsg("获取用户列表失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }
}
