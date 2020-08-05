package com.ed.service.impl;

import com.ed.mapper.FileResourcesMapper;
import com.ed.pojo.FileResources;
import com.ed.pojo.User;
import com.ed.service.FileResourcesService;
import com.ed.utils.FileSizeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class FileResourcesServiceImpl implements FileResourcesService {

    @Autowired
    FileResourcesMapper fileResourcesMapper;

    @Override
    public Map<String, Object> pageMap(FileResources fileResources) {
        PageHelper.startPage(fileResources.getPage(),fileResources.getRow());
        List<FileResources> files = fileResourcesMapper.queryAll(fileResources);
        PageInfo<FileResources> pageInfo = new PageInfo<FileResources>(files);
        Map<String, Object> mapList = new HashMap<>();
        mapList.put("list",pageInfo.getList());
        if(fileResources.getPage()==pageInfo.getNavigateFirstPage()){
            mapList.put("prePage",1);
        }else {
            mapList.put("prePage",pageInfo.getPrePage());
        }
        if(fileResources.getPage()==pageInfo.getNavigateLastPage()){
            mapList.put("nextPage",1);
        }else {
            mapList.put("nextPage",pageInfo.getNextPage());
        }
        mapList.put("total",pageInfo.getTotal());
        mapList.put("currentPage",fileResources.getPage());
        mapList.put("countPage",pageInfo.getPages());
        mapList.put("firstPage",pageInfo.getNavigateFirstPage());
        mapList.put("lastPage",pageInfo.getNavigateLastPage());
        return mapList;
    }

    @Override
    public String fileTrans(@RequestParam("file") MultipartFile[] multipartFiles) {
          List<FileResources> files = new ArrayList<>();
          String pathString = null;
          if(multipartFiles!=null&&multipartFiles.length>0){
              try{
              for (MultipartFile file : multipartFiles) {
                  //将文件存储到此路径
                  String realPath ="D:\\resources";
                  String originalFilename = file.getOriginalFilename();
                  String fileSize = FileSizeUtil.readableFileSize(file.getSize());
                  //将文件大小，文件名称装入对象
                  FileResources fileResources = new FileResources();
                  fileResources.setFileName(originalFilename);
                  fileResources.setFileSize(fileSize);
                  fileResources.setFileCount(0);
                  User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
                  fileResources.setFileProvider(user.getUserName());
                 //设置上传时间
                  Date date = new Date();
                  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                  String format = sdf.format(date);
                  fileResources.setFileDate(format);
                 //得到登录用户信息,设置上传人
                  //将上传的信息添加到集合中
                  files.add(fileResources);
                  pathString =realPath+"\\"+originalFilename;
                  //创建文件对象
                  File file1 = new File(pathString);
                  //判断文件目录是否存在，如果不存在则创建
                  if (!file1.isDirectory()){
                      file1.mkdirs();
                  }
                  file.transferTo(file1);
              }
              }catch (IOException e){
                  e.printStackTrace();
              }
          }
          //批量插入
       fileResourcesMapper.insert(files);
        return "true";
    }

    @Override
    public int insert(List<FileResources> files) {
        return fileResourcesMapper.insert(files);
    }


    @Override
    public ResponseEntity<byte[]> fileDownLoad(FileResources fileResources) throws IOException {
        //获取资源路径
        String realPath ="D:\\resources";
        File file1 = new File(realPath+"\\"+fileResources.getFileName());
        //获取响应头
        HttpHeaders http = new HttpHeaders();
        //设置下载响应头部
        http.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //处理中文乱码
        String downName= new String(fileResources.getFileName().getBytes("utf-8"),"ISO8859-1");
        //下载文件
        http.set("Content-Disposition","attachment;filename="+downName);
        //修改下载次数
        fileResourcesMapper.updateByPrimaryKeySelective(fileResources);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file1),http, HttpStatus.CREATED);
    }


}
