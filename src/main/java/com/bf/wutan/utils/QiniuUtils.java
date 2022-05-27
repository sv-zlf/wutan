package com.bf.wutan.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

/**
 * 七牛云工具类
 * Zone.zone0:华东
 * Zone.zone1:华北
 * Zone.zone2:华南
 * Zone.zoneNa0:北美
 * ———http上传，自动识别上传区域——
 * Zone.httpAutoZone
 * ———https上传，自动识别上传区域—— //Zone.httpsAutoZone
 * Configuration cfg = new Configuration(Zone.zone2());其中Configuration中的Zone.zone2()可以改为Zone.zone0()
 */
public class QiniuUtils {
    //访问授权码
    public  static String accessKey = "mpRWFouGy6i3XT9Xe-TzxsIbstMo7s5HIv9YZDd6";
    //秘密钥匙
    public  static String secretKey = "yoDXwfsgxKve48RGmkPxlhjdEKVW622HFNsoUHCM";
    //空间名称
    public  static String bucket = "werwerweq";
    //外链域名
    public static String domain = "http://qiniuyun.zlfblog.top/";

    //上传方式一：外链+文件名 获取其他图片链接进行上传
    public static void upload2Qiniu(String filePath,String fileName){
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(filePath, fileName, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        } catch (QiniuException ex) {
            Response r = ex.response;
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
    }

    //上传方式二：文件上传 通过上传文件的方式上传到存储空间
    public static String upload2Qiniu(byte[] bytes, String fileName){
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = fileName;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(bytes, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
            //返回文件完整路径
            return domain+putRet.key;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
                return "";
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return "";
    }

    //删除文件 参数：存储的图片文件名
    public static void deleteFileFromQiniu(String fileName){
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        String key = fileName;
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.delete(bucket, key);
        } catch (QiniuException ex) {
            //如果遇到异常，说明删除失败
            System.err.println(ex.code());
            System.err.println(ex.response.toString());
        }
    }
}
