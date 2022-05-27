package com.bf.wutan.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.config.GlobalResult;
import com.bf.wutan.entity.App;
import com.bf.wutan.service.AppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  案例前端控制器
 * </p>
 *
 * @author bf
 * @since 2022-04-20
 */
@RestController
@RequestMapping("/app")
@CrossOrigin
@Api(tags = "案例信息")
public class AppController {

    final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    private GlobalResult result;

    @PostMapping("")
    @ApiOperation(value = "添加案例")
    public GlobalResult addApp(@RequestBody App app){

        if(appService.getAppByName(app.getAppname())!=null){
            return result=GlobalResult.errorMsg("该案例名称已存在");
        }
        try {
            if(appService.createApp(app)){
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("应用创建失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @DeleteMapping("/name/{name}")
    @ApiOperation(value = "删除案例",notes = "通过案例名称（appname）删除对应案例")
    public GlobalResult deleteAppByName(@PathVariable String name){

        try {
            if(appService.deleteAppByName(name)){
                result=GlobalResult.ok();
            }
            else{
                result=GlobalResult.errorMsg("删除案例失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @PutMapping("")
    @ApiOperation(value = "编辑案例")
    public GlobalResult updateApp(@RequestBody App app){

        try {
            if(appService.updateApp(app)){
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("编辑案例失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @GetMapping("")
    @ApiOperation(value="获取案例列表")
    public GlobalResult getAppList(Integer pageIndex,Integer pageSize){

        Page<App> page=new Page<>(pageIndex,pageSize);
        try {
            IPage<App> data=appService.getApp(page);
            if(data!=null){
                result=GlobalResult.build(200, String.valueOf(data.getTotal()),data.getRecords());
            }
            else {
                result=GlobalResult.errorMsg("案例获取失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

//    @GetMapping("/all")
//    public GlobalResult getAllApp(){
//
//        try {
//            List<App> apps= appService.getAllApp();
//            if (apps!=null){
//                result=GlobalResult.build(200,"获取所有应用",apps);
//            }
//            else {
//                result=GlobalResult.build(400,"应用为空",null);
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        return result;
//    }

    @GetMapping("/name/{name}")
    @ApiOperation(value = "获取指定名称的案例")
    public GlobalResult getAppByName(@PathVariable String name){

        try {
            App app= appService.getAppByName(name);
            if(app!=null){
                result=GlobalResult.ok(app);
            }
            else {
                result=GlobalResult.errorMsg("获取指定名称的案例失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @GetMapping("/typId/{typeId}")
    @ApiOperation(value="根据应用场景类别获取案例列表")
    public GlobalResult getAppByTypeId(Integer pageIndex,Integer pageSize,@PathVariable Integer typeId){

        Page<App> page=new Page<>(pageIndex,pageSize);
        try {
            IPage<App> data=appService.selectAppByAppType(page,typeId);
            if(data!=null){
                result=GlobalResult.build(200, String.valueOf(data.getTotal()),data.getRecords());
            }
            else {
                result=GlobalResult.errorMsg("案例获取失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return  result;
    }

//    @GetMapping("/length")
//    @ApiOperation(value = "获取所有案例长度")
//    public GlobalResult getAppLength(){
//        try {
//            Integer length=appService.countApp();
//            result=GlobalResult.build(200,"已获取所有案例长度",length);
//        }
//        catch (Exception e){
//            result=GlobalResult.build(500,"获取所有案例长度异常",e.getMessage());
//        }
//        return result;
//    }
}
