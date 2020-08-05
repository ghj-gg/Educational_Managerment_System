package com.ed.controller;

import com.ed.pojo.FileResources;
import com.ed.service.FileResourcesService;
import com.ed.utils.FileSizeUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("fileResourcesController")
public class FileResourcesController {

    @Autowired
    FileResourcesService fileResourcesService;


// 文件页面
    @RequestMapping("fileResourcesPage.do")
    public String fileResourcesPage(FileResources fileResources,Model model){
        System.out.println("fileResources="+fileResources);
        model.addAttribute("fileResources",fileResources);
        Map<String, Object> mapList = fileResourcesService.pageMap(fileResources);
        model.addAttribute("mapList",mapList);
        return "fileResources/fileResourcesPage";
    }


    //文件上传
    @RequestMapping("fileTrans.do")
    @ResponseBody
    public String fileTrans(@RequestParam("file") MultipartFile[] multipartFiles){
        return fileResourcesService.fileTrans(multipartFiles);
    }

    //文件下载
    @RequestMapping("fileDownLoad.do")
    @ResponseBody
    public ResponseEntity<byte[]> fileDownLoad(FileResources fileResources) throws IOException {
    return fileResourcesService.fileDownLoad(fileResources);
    }




}
