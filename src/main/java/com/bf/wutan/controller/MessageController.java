package com.bf.wutan.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.config.GlobalResult;
import com.bf.wutan.entity.Message;
import com.bf.wutan.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author bf
 * @since 2022-05-06
 */
@RestController
@RequestMapping("/message")
@CrossOrigin
@Api(tags = "留言信息")
public class MessageController {


    final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    private GlobalResult result;

    @PostMapping("")
    @ApiOperation("添加反馈信息")
    public GlobalResult addMessage(@RequestBody Message message){

        try {
            if(messageService.addMessage(message)){
                result=GlobalResult.ok();
            }
            else {
                result=GlobalResult.errorMsg("反馈信息添加失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }

    @GetMapping("")
    @ApiOperation(value ="获取反馈信息")
    public GlobalResult getMessage(Integer pageIndex,Integer pageSize){

        Page<Message> page=new Page<>(pageIndex,pageSize);
        try {
            IPage<Message> data= messageService.getMessage(page);
            if(data!=null){
                result=GlobalResult.build(200, String.valueOf(data.getTotal()),data.getRecords());
            }
            else {
                result=GlobalResult.errorException("获取反馈信息失败");
            }
        }
        catch (Exception e){
            result=GlobalResult.errorException(e.getMessage());
        }
        return result;
    }
}
