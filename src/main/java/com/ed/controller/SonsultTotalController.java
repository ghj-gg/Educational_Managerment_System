package com.ed.controller;

import com.ed.pojo.Class;
import com.ed.pojo.SonsultTotal;
import com.ed.service.SonsulTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("sonsultTotalController")
public class SonsultTotalController {
    @Autowired
    SonsulTotalService sonsulTotalService;

    /**
     * 跳转综合评教页面
     * @return
     */
    @RequestMapping("sonsultTotalPage.do")
    public String sonsultTotalPage(){
        return "teacher/sonsultTotal";
    }

    @RequestMapping("sonsultTotal.ajax")
    @ResponseBody
    public HashMap<String,Object> sonsultTotal(Class class1){

        return sonsulTotalService.selectClassByPage(class1);
    }

    @RequestMapping("allCount.ajax")
    @ResponseBody
    public HashMap allCount(Class c){
        //根据班级计算平均分
        String avg = sonsulTotalService.selectCountByClass(c.getClassC());
        HashMap map = new HashMap();
        map.put("info",avg);
        return map;
    }

    @RequestMapping("messagePage.do")
    public String massagePage(){
        return "teacher/massagePage";
    }

}
