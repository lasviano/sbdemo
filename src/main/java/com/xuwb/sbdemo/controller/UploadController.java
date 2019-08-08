package com.xuwb.sbdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadController {

    Map<String,Object> result = new HashMap<String, Object>();

    @RequestMapping("/uploadfile")
    public Map<String,Object> uploadfile(@RequestParam("attach") MultipartFile file) throws IOException {

        System.out.println("文件原名："+file.getOriginalFilename());

        file.transferTo(new File("D:\\xuwb-b\\file\\"+file.getOriginalFilename()));
        result.put("success",true);

        return result;
    }
}
