package com.ed.controller;

import com.ed.pojo.Sonsult;
import com.ed.pojo.SonsultTotal;
import com.ed.pojo.User;
import com.ed.service.SonsultService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;

@Controller
@RequestMapping("sonsultController")
public class SonsultController {

    @Autowired
    SonsultService sonsultService;

    /**
     * 跳转评教页面，判断评教时间
     * @return
     */
    @RequestMapping("sonsultPage.do")
    public String sonsultPage() throws Exception{
            int flag = sonsultService.sonsultPage();
            if (flag == 1){
                System.out.println("未到评教之间");
                return "student/notTime";
            }else if(flag == 2){
                System.out.println("评教时间已结束");
                return "student/overTime";
            }
            return "student/sonsult";
    }

    /**
     * 评教Ajax
     * @param sonsult
     * @return
     */
    @RequestMapping("sonsult.ajax")
    @ResponseBody
    public HashMap<String,Object> sonsult(Sonsult sonsult){
        return sonsultService.selectSonsultByPage(sonsult);
    }

    //跳转评教页面
    @RequestMapping("addSonsult.do")
    public String addSonsult(Sonsult sonsult){
        System.out.println(sonsult.toString());
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("sonsult",sonsult);
        return "student/addSonsult";
    }

    //评教
    @RequestMapping("sonsultPage.ajax")
    @ResponseBody
    public HashMap sonsult(SonsultTotal sonsultTotal){
        System.out.println("进入评教");
        HashMap map = new HashMap();
        int count = sonsultService.addSonsultTotal(sonsultTotal);
        System.out.println("count="+count);
        if(count>0){
            map.put("info",true);
        }else {
            map.put("info",false);

        }
        return map;
    }

    /**
     * 跳转综合评教页面
     * @return
     */
    @RequestMapping("sonsultTotalPage.do")
    public String sonsultTotalPage(){
        return "student/sonsultTotal";
    }

    @RequestMapping("sonsultTotal.ajax")
    @ResponseBody
    public HashMap<String,Object> sonsultTotal(SonsultTotal sonsultTotal){
        return sonsultService.selectSonsultTotalByPage(sonsultTotal);
    }
}
