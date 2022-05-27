package com.bf.wutan.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.config.GlobalResult;
import com.bf.wutan.entity.Member;
import com.bf.wutan.service.MemberService;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2022-05-16
 */
@RestController
@RequestMapping("/member")
@CrossOrigin
@Api(tags = "团队成员")
public class MemberController {

    final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    private GlobalResult result;

    @PostMapping("")
    @ApiOperation(value = "添加团队成员")
    public GlobalResult addMember(@RequestBody Member member) {

        try{
            if(memberService.addMember(member)){
                result = GlobalResult.ok();
            }
            else{
                result = GlobalResult.errorMsg("添加团队成员失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }

        return result;
    }

    @DeleteMapping("/name/{name}")
    @ApiOperation(value = "根据名称删除该团队成员")
    public GlobalResult deleteMemberByName(@PathVariable String name){

        try{
            if (memberService.deleteMemberByName(name)){
                result=GlobalResult.ok();
            }
            else{
                result=GlobalResult.errorMsg("删除团队成员失败");
            }
        }
        catch(Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @DeleteMapping("/teamId/{teamId}")
    @ApiOperation(value = "根据团队Id删除所有该团队成员")
    public GlobalResult deleteMemberByTeamId(@PathVariable Integer teamId){

        try{
            if(memberService.deleteMemberByTeamId(teamId)){
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("删除团队成员失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @PutMapping("")
    @ApiOperation(value = "更新团队成员信息")
    public GlobalResult updateMember(@RequestBody Member member){

        try{
            if(memberService.updateMember(member)){
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("更新团队成员信息失败");
            }
        }
        catch(Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @GetMapping("/teamId/{teamId}")
    @ApiOperation(value = "根据团队Id获取所有团队成员")
    public GlobalResult getMemberByTeamId(@PathVariable Integer teamId){

        try{
            List<Member> memberList =memberService.getMemberByTeamId(teamId);
            if(memberList!=null){
                result=GlobalResult.ok(memberList);
            }
            else {
                result=GlobalResult.errorMsg("该团队成员不存在");
            }
        }
        catch(Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @GetMapping("/name/{name}")
    @ApiOperation(value = "依据名称获取团队成员具体信息")
    public GlobalResult getMemberByName(@PathVariable String name){

        try{
            Member member=memberService.getMemberByName(name);
            if(member!=null){
                result=GlobalResult.ok(member);
            }
            else {
                result=GlobalResult.errorMsg("该团队成员信息不存在");
            }
        }
        catch(Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @GetMapping("")
    @ApiOperation(value = "获取团队成员列表")
    public GlobalResult getMemberList(Integer pageIndex,Integer pageSize){

        Page<Member> page =new Page<>(pageIndex,pageSize);
        try {
            IPage<Member> data=memberService.getMemberList(page);
            if (data!=null){
                result=GlobalResult.build(200, String.valueOf(data.getTotal()),data.getRecords());
            }
            else {
                result=GlobalResult.errorMsg("获取团队成员列表失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

}
