package com.ya.spring.mvc.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Description
 * @Author ROCIA
 * @Date 2020/8/24
 */
@Controller
public class FileUploadController {

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public @ResponseBody String upload(MultipartFile file){ // MultipartFile接受文件
        try{
            //writeByteArrayToFile()快速将文件写入磁盘
            FileUtils.writeByteArrayToFile(new File("D:/data_space/loaclUpload/"+file.getOriginalFilename()),file.getBytes());
            return "success";
        }catch (IOException e){
            e.printStackTrace();
            return "wrong";
        }
    }


}
