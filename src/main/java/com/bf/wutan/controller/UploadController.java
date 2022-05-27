package com.bf.wutan.controller;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.bf.wutan.config.GlobalResult;
import com.bf.wutan.utils.QiniuUtils;
import com.bf.wutan.utils.UploadGiteeImgBed;
import com.zaxxer.hikari.util.SuspendResumeLock;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @author zlf
 */
@RestController
@CrossOrigin
@Api(tags = "图片上传")
public class UploadController {

    /**
     *  上传图片
     * @param multipartFile 文件对象
     * @return
     * @throws IOException
     */
    @PostMapping("/uploadImg")
    public GlobalResult uploadImg(@RequestParam("file") MultipartFile multipartFile) throws IOException {

        String originalFilename = multipartFile.getOriginalFilename();
        //获取图片原始文件名
        int index = originalFilename.lastIndexOf(".");
        String extention = originalFilename.substring(index);
        //获得图片后缀名  .jpg
        String fileName = UUID.randomUUID().toString() + extention;
        //进行拼接
        fileName = fileName.replace("-","");
        //将文件路径中的-替换掉
        GlobalResult result;
        try {
            //使用工具类将文件上传到七牛云服务器
            String filePath = QiniuUtils.upload2Qiniu(multipartFile.getBytes(),fileName);
            result =GlobalResult.ok(filePath);

        } catch (IOException e) {
            result =GlobalResult.errorException(e.getMessage());
        }

        return result;
    }

}
