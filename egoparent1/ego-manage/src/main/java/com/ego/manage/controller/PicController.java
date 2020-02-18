package com.ego.manage.controller;

//import com.ego.manage.service.PicService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.util.Map;
//
//@Controller
//public class PicController {
//    @Autowired
//    private PicService picService;
//    /**
//     * 文件上传
//     * */
//    @RequestMapping("pic/upload")
//    @ResponseBody
//    public Map<String,Object> upload(MultipartFile uploadFile){
//        return picService.upload(uploadFile);
//    }
//}
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ego.manage.service.PicService;

@Controller
public class PicController {
    @Resource
    private PicService picServiceImpl;

    /**
     * 图片上传
     * @param uploadFile
     * @return
     */
    @RequestMapping("pic/upload")
    @ResponseBody
    public Map<String,Object> upload(MultipartFile uploadFile){
        Map<String,Object> map = null;
        try {
            map= picServiceImpl.upload(uploadFile);
        } catch (IOException e) {
            e.printStackTrace();
            map.put("error", 1);
            map.put("message","上传图片时服务器异常");
        }
        return map;
    }
}

