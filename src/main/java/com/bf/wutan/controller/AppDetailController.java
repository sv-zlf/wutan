package com.bf.wutan.controller;


import com.bf.wutan.config.GlobalResult;
import com.bf.wutan.entity.AppDetail;
import com.bf.wutan.service.AppDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  案例详情前端控制器
 * </p>
 *
 * @author  bf
 * @since 2022-04-20
 */
@RestController
@RequestMapping("/app-detail")
@CrossOrigin
@Api(tags = "案例详情")
public class AppDetailController {

    final AppDetailService appDetailService;

    public AppDetailController(AppDetailService appDetailService) {
        this.appDetailService = appDetailService;
    }

    private GlobalResult result;

    @PostMapping("")
    @ApiOperation(value = "添加应用详细内容")
    public GlobalResult addAppDetail(@RequestBody AppDetail appDetail){

        try {
            if(appDetailService.addAppDetail(appDetail)){
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("添加应用详情失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @DeleteMapping("/name/{name}")
    @ApiOperation(value = "删除应用详情")
    public GlobalResult deleteAppDetailByName(@PathVariable String name){

        try {
            if(appDetailService.deleteAppDetailByName(name)){
                result=GlobalResult.ok();
            }
            else{
                result=GlobalResult.errorMsg("删除应用详情失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @PutMapping("")
    @ApiOperation(value = "更新应用详情")
    public GlobalResult updateAppDetail(@RequestBody AppDetail appDetail){

        try {
            if(appDetailService.updateAppDetail(appDetail)){
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("更新应用详情失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @PutMapping("/name/{name}")
    @ApiOperation(value = "更新案例阅读量")
    public GlobalResult updateAppDetailReadCount(@PathVariable String name){

        try {
            if(appDetailService.updateAppDetailReadCount(name)){
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("更新案例阅读量失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @GetMapping("/name/{name}")
    @ApiOperation(value = "获取应用案例详情")
    public GlobalResult getAppDetailByName(@PathVariable String name){

        try {
            AppDetail appDetail=appDetailService.getAppDetailByName(name);
            if(appDetail!=null){
                result=GlobalResult.ok(appDetail);
            }
        else {
            result=GlobalResult.errorMsg("获取应用案例详情失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

}
