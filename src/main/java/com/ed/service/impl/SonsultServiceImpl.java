package com.ed.service.impl;

import com.ed.mapper.DateMapper;
import com.ed.mapper.SonsultMapper;
import com.ed.mapper.SonsultTotalMapper;
import com.ed.mapper.UserMapper;
import com.ed.pojo.Sonsult;
import com.ed.pojo.SonsultTotal;
import com.ed.pojo.User;
import com.ed.service.SonsultService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

@Service
public class SonsultServiceImpl implements SonsultService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    SonsultMapper sonsultMapper;

    @Autowired
    DateMapper dateMapper;

    @Autowired
    SonsultTotalMapper sonsultTotalMapper;

    @Override
    public int sonsultPage() throws Exception{
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = new User();
        user = (User)session.getAttribute("user");
        System.out.println("跳转评教页面获取的User："+user.toString());
        //通过学期查询时间
        com.ed.pojo.Date semesterDate = dateMapper.selectDateBySemesterId(user.getUserSemester());
        java.util.Date nowDate = new java.util.Date();
        java.util.Date beforeDate = new SimpleDateFormat("yyyy-MM-dd").parse(semesterDate.getSonsultDateStart());
        System.out.println(beforeDate);
        java.util.Date afterDate = new SimpleDateFormat("yyyy-MM-dd").parse(semesterDate.getSonsultDateEnd());
        if (nowDate.before(beforeDate)){
            System.out.println("未到评教之间");
            return 1;
        }else if(nowDate.after(afterDate)){
            System.out.println("评教时间已结束");
            return 2;
        }
        return 3;
    }

    @Override
    public HashMap<String,Object> selectSonsultByPage(Sonsult sonsult) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User)session.getAttribute("user");
        System.out.println("User："+user.toString());
        //通过用户id获取Sonsult对象
        List<Sonsult> list = sonsultMapper.selectByUserId(user.getUserId());
        PageHelper.startPage(sonsult.getPage(),sonsult.getRow());
        PageInfo<Sonsult> pageInfo = new PageInfo<Sonsult>(list);

        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("list",pageInfo.getList());
        map.put("count",pageInfo.getTotal());
        map.put("prePage",pageInfo.getPrePage());
        map.put("nextPage",pageInfo.getNextPage());
        map.put("indexPage",pageInfo.getFirstPage());
        map.put("endPage",pageInfo.getLastPage());
        map.put("allPage",pageInfo.getPageSize());
        return map;
    }

    @Override
    public int addSonsultTotal(SonsultTotal sonsultTotal) {
        //获取当前用户，获取当前用户所在的班级
        Subject subject1 = SecurityUtils.getSubject();
        Session session1 = subject1.getSession();
        User user = (User)session1.getAttribute("user");
        String userClass = user.getUserClass();
        //获取当前评教对象，得到教师名，通过教师名查询教师id
        Subject subject2 = SecurityUtils.getSubject();
        Session session2 = subject2.getSession();
        Sonsult sonsult = (Sonsult)session2.getAttribute("sonsult");
        System.out.println("sonsult"+sonsult.toString());
        User user1 = userMapper.selectTIdByTeacherName(sonsult.getSonsultTeacher());
        int tId = user1.getUserId();
        //总分
        int count = sonsultTotal.getSonsultTotalA()+sonsultTotal.getSonsultTotalB()+sonsultTotal.getSonsultTotalC()+sonsultTotal.getSonsultTotalD();
        //添加到数据库中
        sonsultTotal.setSonsultTotalClass(userClass);
        sonsultTotal.setSonsultTotalCount(count);
        sonsultTotal.setSonsultTotalTid(tId);
        int n = sonsultTotalMapper.insertSelective(sonsultTotal);
        //更改状态
        sonsult.setSonsultState(1);
        if (n>0){
            //修改sonsult的状态
            if(sonsultMapper.updateByPrimaryKeySelective(sonsult)>0){
                return 1;
            }
        }
        return 0;
    }

    @Override
    public HashMap<String, Object> selectSonsultTotalByPage(SonsultTotal sonsultTotal) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User)session.getAttribute("user");
        //通过教师id查询综合评教
        List<SonsultTotal> list = sonsultTotalMapper.selectSonsultTotalByUserSno(user.getUserId());
        PageHelper.startPage(sonsultTotal.getPage(),sonsultTotal.getRow());
        PageInfo<SonsultTotal> pageInfo = new PageInfo<>(list);
        //获取班级评教平均分
        int allCount = 0;
        for (SonsultTotal s : list){
            allCount += s.getSonsultTotalCount();
        }
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("list",pageInfo);


        return null;
    }
}
