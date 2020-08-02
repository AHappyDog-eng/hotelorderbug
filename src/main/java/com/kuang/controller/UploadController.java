package com.kuang.controller;

import com.alibaba.fastjson.JSON;
import com.kuang.entity.filterMsg.uploadFilter;
import com.kuang.entity.oos;
import com.kuang.service.oosImp;
import com.kuang.tools.AliyunOSSUtil;
import com.kuang.tools.statuscode;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Controller
public class UploadController {
    @Autowired
    private AliyunOSSUtil ossUtil;
    @Autowired
    private oosImp oosImp;
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping("/oos/upload")
    @ResponseBody
    public String uploadBlog(MultipartFile file){
        logger.info("============>文件上传");
        try {
            if(null != file){
                String filename = file.getOriginalFilename();
                if(!"".equals(filename.trim())){
                    File newFile = new File(filename);
                    FileOutputStream os = new FileOutputStream(newFile);
                    os.write(file.getBytes());
                    os.close();
                    file.transferTo(newFile);
                    //上传到OSS
                    String uploadUrl = AliyunOSSUtil.upload(newFile);
                    uploadUrl = "https://java4all-file-oos.oss-cn-beijing.aliyuncs.com/"+uploadUrl;
                    /*上传到控制台 就返回照片Url 存储到数据库*/
                    String oos_cn = "oos_cn"+ UUID.randomUUID().toString().substring(0,8);
                    oosImp.insertOos(new oos(oos_cn,uploadUrl));
                    /*返回 文件id和地址*/
                    return JSON.toJSONString(new uploadFilter(oos_cn,uploadUrl,20000));
                }else {
                    return JSON.toJSONString(new statuscode(false,400,"上传失败"));
                }
            }else {
                return JSON.toJSONString(new statuscode(false,400,"上传失败"));
            }
        }catch (Exception ex){
            return JSON.toJSONString(new statuscode(false,400,"上传失败"));
        }
    }
    @RequestMapping("/oos/readoos")
    @ResponseBody
    public String readoos(@RequestBody String msg) {
        oos oos = JSON.parseObject(msg, oos.class);
        com.kuang.entity.oos byOosId = oosImp.getByOosId(oos.getOosId());
        return JSON.toJSONString(byOosId);
    }
}
