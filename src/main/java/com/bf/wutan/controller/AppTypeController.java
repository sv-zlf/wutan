package com.bf.wutan.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.config.GlobalResult;
import com.bf.wutan.entity.AppType;
import com.bf.wutan.service.AppTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  应用场景类别前端控制器
 * </p>
 *
 * @author bf
 * @since 2022-04-20
 */
@RestController
@RequestMapping("/app-type")
@CrossOrigin
@Api(tags = "应用场景类别")
public class AppTypeController {

    final AppTypeService appTypeService;

    public AppTypeController(AppTypeService appTypeService) {
        this.appTypeService = appTypeService;
    }


    private GlobalResult result;

    @PostMapping("")
    @ApiOperation(value = "添加应用类别")
    public GlobalResult addAppType(@RequestBody AppType appType){

        if(appTypeService.getAppTypeByName(appType.getTypename())!=null){
            return GlobalResult.errorMsg("该应用类别已存在");
        }
        try {
            if(appTypeService.createAppType(appType)){
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("应用类别创建失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @DeleteMapping("/name/{name}")
    @ApiOperation(value = "删除应用类别",notes = "通过类别名称（typename）删除对应类别")
    public GlobalResult deleteAppTypeByName(@PathVariable String name){

        try {
            if(appTypeService.deleteAppTypeByName(name)){
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("删除应用类型失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return  result;
    }

    @PutMapping("")
    @ApiOperation(value = "编辑应用类型")
    public GlobalResult updateAppType(@RequestBody AppType appType){

        AppType appType1=appTypeService.getAppTypeByName(appType.getTypename());
        AppType appType2=appTypeService.getAppTypeById(appType.getId());
        if(appType1!=null&&!appType1.equals(appType2)){
            result=GlobalResult.errorMsg("该应用类型已存在");
            return result;
        }

        try {

            if(appTypeService.updateAppType(appType)){
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("编辑应用类型失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @GetMapping("")
    @ApiOperation(value = "获取案例类型列表")
    public GlobalResult getAppType(Integer pageIndex,Integer pageSize){

        Page<AppType> page=new Page<>(pageIndex,pageSize);
        try {
            IPage<AppType> data=appTypeService.getAppType(page);
            if(data!=null){
                result=GlobalResult.build(200, String.valueOf(data.getTotal()),data.getRecords());
            }
            else{
                result=GlobalResult.errorMsg("获取应用类型信息失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @GetMapping("/all")
    @ApiOperation(value = "获取所有案例类型")
    public GlobalResult getAppTypeList(){

        try {
            List<AppType> appTypes= appTypeService.getAppTypes();
            if (appTypes!=null){
                result=GlobalResult.ok(appTypes);
            }
            else {
                result=GlobalResult.errorMsg("应用类型为空");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @GetMapping("/id/{id}")
    @ApiOperation(value = "获取应用类型信息",notes = "通过应用Id")
    public GlobalResult getAppTypeById(@PathVariable Integer id){

        try {
            AppType appType=appTypeService.getAppTypeById(id);
            if(appType!=null){
                result=GlobalResult.ok(appType);
            }
            else {
                result=GlobalResult.errorMsg("获取应用类型信息失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }
}
