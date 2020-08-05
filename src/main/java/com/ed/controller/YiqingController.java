package com.ed.controller;

import com.ed.service.YiqingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("yiqingController")
public class YiqingController {

   @Autowired
   YiqingService yiqingService;

    @RequestMapping("yiqing.do")
    public String yiqing(){
        return "yiqing/yiqing";
    }

    @RequestMapping("yiqingfenxi.ajax")
    @ResponseBody
    public List<HashMap<String,String>> yiqingfenxi(){
        List<HashMap<String, String>> yiqingfenxi = yiqingService.yiqingfenxi();
        return yiqingfenxi;
    }

    @RequestMapping("selectChinaInfo.ajax")
    @ResponseBody
    public List<HashMap<String,String>> selectChinaInfo(){
        List<HashMap<String, String>> province = yiqingService.selectChinaInfo();
        return province;
    }




    @RequestMapping("provinceCuredQianWu.ajax")
    @ResponseBody
    public List<List<String >> provinceCuredQianWu(String cityName){
        return yiqingService.provinceCuredQianWu(cityName);
    }

    @RequestMapping("deadCountQianWu.ajax")
    @ResponseBody
    public  List<List<String>> deadCountQianWu(String cityName){
        return yiqingService.deadCountQianWu(cityName);
    }

    @RequestMapping("provinceyiqingfenxi.ajax")
    @ResponseBody
    public List<HashMap<String,String>> provinceyiqingfenxi(String cityName){
        return yiqingService.provinceyiqingfenxi(cityName);
    }





}
