package com.bf.wutan.controller;


import com.bf.wutan.config.GlobalResult;
import com.bf.wutan.entity.NewsDetail;
import com.bf.wutan.service.NewsDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  新闻详情前端控制器
 * </p>
 *
 * @author bf
 * @since 2022-04-20
 */
@RestController
@RequestMapping("/news-detail")
@CrossOrigin
@Api(tags = "新闻详情")
public class NewsDetailController {

    final NewsDetailService newsDetailService;

    private GlobalResult result;

    public NewsDetailController(NewsDetailService newsDetailService) {
        this.newsDetailService = newsDetailService;
    }

    @PostMapping("")
    @ApiOperation(value = "创建文章详细内容",notes = "id省略")
    public GlobalResult createNews(@RequestBody NewsDetail newsDetail) {

        try {
            if(newsDetailService.createNewsDetail(newsDetail)){
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("文章创建失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return  result;
    }

    @DeleteMapping("/title/{title}")
    @ApiOperation(value = "删除文章",notes = "通过文章标题（title）")
    public GlobalResult deleteNewsDetailByTitle(@PathVariable String title){

        try {
            if(newsDetailService.deleteNewsDetail(title)){
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("文章删除失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @PutMapping("")
    @ApiOperation(value = "更新文章内容")
    public GlobalResult updateNewsDetail(@RequestBody NewsDetail newsDetail){

        try {
            if(newsDetailService.updateNewsDetail(newsDetail)){
                result=GlobalResult.ok();
            }
            else{
                result=GlobalResult.errorMsg("更新文章失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @PutMapping("/title/{title}")
    @ApiOperation(value = "添加点击量")
    public GlobalResult updateNewsDetailReadCountByTitle(@PathVariable String title){

        try {
            if(newsDetailService.updateNewsDetailReadCountByTitle(title)){
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("添加点击量失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @GetMapping("/title/{title}")
    @ApiOperation(value = "获取文章详细内容")
    public GlobalResult getNewsDetailByTitle(@PathVariable String title){

        try {
            NewsDetail newsDetail= newsDetailService.getNewsDetailByTitle(title);
            if(newsDetail!=null){
                result=GlobalResult.ok(newsDetail);
            }
            else {
                result=GlobalResult.errorMsg("获取文章详细内容失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

}
