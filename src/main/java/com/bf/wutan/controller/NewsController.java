package com.bf.wutan.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.config.GlobalResult;
import com.bf.wutan.entity.News;
import com.bf.wutan.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  新闻动态前端控制器
 * </p>
 *
 * @author bf
 * @since 2022-04-19
 */
@RestController
@RequestMapping("/news")
@CrossOrigin
@Api(tags = "新闻动态")
public class NewsController {

    final NewsService newsService;

    private GlobalResult result;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping("")
    @ApiOperation(value = "创建文章",notes = "id省略")
    public GlobalResult createNews(@RequestBody News news) {

        String title=news.getTitle();
        if(newsService.selectNewsByTitle(title)!=null){
            result = GlobalResult.errorMsg("此标题已存在");
            return  result;
        }

        try {
            if( newsService.createNews(news)){
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("文章创建失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @DeleteMapping("/title/{title}")
    @ApiOperation(value = "删除文章",notes = "通过文章标题删除文章")
    public GlobalResult deleteNewsByTitle(@PathVariable String title){

        try {
            if(newsService.deleteNewsByTitle(title)) {
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("删除新闻失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return  result;
    }

//    @DeleteMapping("/id/{id}")
//    @ApiOperation(value = "删除文章",notes = "通过文章Id删除文章")
//    public GlobalResult deleteNewsById(@PathVariable Integer id){
//
//        try {
//            if(newsService.deleteNewsById(id)) {
//                result= GlobalResult.build(200, "删除新闻成功", null);
//            }
//            else {
//                result= GlobalResult.build(400, "删除新闻失败", null);
//            }
//        }
//        catch (Exception e){
//            result=GlobalResult.errorException(e.getMessage());
//        }
//        return  result;
//    }

    @PutMapping("")
    @ApiOperation(value = "修改文章",notes = "通过文章Id修改文章")
    public GlobalResult updateNews(@RequestBody News news){

        try {
            if(newsService.updateNews(news)) {
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("编辑新闻失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return  result;
    }

    @PutMapping("/title/{title}")
    @ApiOperation(value = "修改文章发布状态",notes = "通过文章标题（title）修改文章发布状态")
    public GlobalResult updateNewsStatus(@PathVariable String title){

        try {
            if(newsService.updateNewsStatus(title)) {
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("更新新闻状态失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return  result;
    }

    @GetMapping("")
    @ApiOperation(value = "获取文章信息",notes = "文章列表")
    public GlobalResult getNews(Integer pageIndex,Integer pageSize){

        Page<News> page = new Page<>(pageIndex, pageSize);
        try {
            IPage<News> data = newsService.getNews(page);
            if(data!=null){
                result= GlobalResult.build(200, String.valueOf(data.getTotal()), data.getRecords());
            }
            else{
                result=GlobalResult.errorMsg("获取文章列表失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return  result;
    }

//    @GetMapping("/id/{id}")
//    @ApiOperation(value = "获取文章信息",notes = "通过文章Id获取")
//    public GlobalResult selectNewsById(@PathVariable Integer id,Integer pageIndex,Integer pageSize){
//
//        Page<News> page = new Page<>(pageIndex, pageSize);
//        try {
//            IPage<News> data = newsService.selectNewsById(page,id);
//            if(data!=null){
//                result= GlobalResult.build(200, String.valueOf(data.getTotal()), data.getRecords());
//            }
//            else{
//                result= GlobalResult.build(400, "获取文章失败", null);
//            }
//        }
//        catch (Exception e){
//            result=GlobalResult.errorException(e.getMessage());
//        }
//        return result;
//    }

    @GetMapping("/title/{title}")
    @ApiOperation(value = "获取文章信息",notes = "通过文章标题获取")
    public GlobalResult selectNewsByTitle(@PathVariable String title){
        try {
            News news = newsService.selectNewsByTitle(title);
            if(news!=null){
                result=GlobalResult.ok(news);
            }
            else{
                result=GlobalResult.errorMsg("获取文章失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

//    @GetMapping("/length")
//    @ApiOperation(value = "获取所有新闻长度")
//    public GlobalResult getNewLength(){
//
//        try {
//            Integer length= newsService.countNews();
//            result=GlobalResult.build(200,"已获取所有新闻长度",length);
//        }
//        catch (Exception e){
//            result=GlobalResult.errorException(e.getMessage());
//        }
//        return result;
//    }


}
