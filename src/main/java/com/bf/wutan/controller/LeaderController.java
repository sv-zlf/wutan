package com.bf.wutan.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.config.GlobalResult;
import com.bf.wutan.entity.Leader;
import com.bf.wutan.service.LeaderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  领袖前端控制器
 * </p>
 *
 * @author bf
 * @since 2022-05-16
 */
@RestController
@RequestMapping("/leader")
@CrossOrigin
@Api(tags = "团队领袖")
public class LeaderController {

    final LeaderService leaderService;

    public LeaderController(LeaderService leaderService) {
        this.leaderService = leaderService;
    }

    private GlobalResult result;

    @PostMapping("")
    @ApiOperation(value = "添加领袖及团队信息")
    public GlobalResult addLeader(@RequestBody Leader leader){

        if(leaderService.getLeaderByName(leader.getName())!=null){
            return GlobalResult.errorMsg("该领袖及其团队已存在");
        }

        try {
            if(leaderService.addLeader(leader)){
                result = GlobalResult.ok();
            }
            else{
                result = GlobalResult.errorMsg("添加领袖及团队信息失败");
            }
        }
        catch (Exception e) {
            result=GlobalResult.errorException(e.getMessage());
            result = GlobalResult.build(500,"添加领袖及团队信息异常",e.getMessage());
        }
        return result;
    }

    @DeleteMapping("/name/{name}")
    @ApiOperation(value = "删除领袖及团队信息")
    public GlobalResult deleteLeaderByName(@PathVariable String name){

        try {
            if(leaderService.deleteLeaderByName(name)){
                result = GlobalResult.ok();
            }
            else{
                result=GlobalResult.errorMsg("删除领袖及团队信息失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @PutMapping("")
    @ApiOperation(value = "更新领袖及团队信息")
    public GlobalResult updateLeader(@RequestBody Leader leader){

        try {
            if(leaderService.updateLeader(leader)){
                result = GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("更新领袖及团队信息失败");
            }
        }
        catch(Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @GetMapping("")
    @ApiOperation(value = "获取领袖列表")
    public GlobalResult getLeaderList(Integer pageIndex,Integer pageSize){

        Page<Leader> page=new Page<Leader>(pageIndex,pageSize);
        try {
            IPage<Leader> data = leaderService.getLeaderList(page);
            if(data!=null){
                result=GlobalResult.build(200, String.valueOf(data.getTotal()),data.getRecords());
            }
            else{
                result=GlobalResult.errorMsg("获取领袖列表失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @GetMapping("name/{name}")
    @ApiOperation(value = "通过领袖名称（name）获取信息")
    public GlobalResult getLeaderByName(@PathVariable String name){

        try {
            Leader leader=leaderService.getLeaderByName(name);
            if(leader!=null){
                result=GlobalResult.ok(leader);
            }
            else {
                result=GlobalResult.errorMsg("获取领袖信息失败");
            }
        }
        catch(Exception e){
            result = GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @GetMapping("/all")
    @ApiOperation(value = "获取所有领袖")
    public GlobalResult getAllLeader(){

        try{
            List<Leader> leaderList =leaderService.getAllLeader();
            if(leaderList!=null){
                result=GlobalResult.ok(leaderList);
            }
            else {
                result=GlobalResult.errorMsg("获取所有领袖以及团队失败");
            }
        }
        catch(Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }
}
