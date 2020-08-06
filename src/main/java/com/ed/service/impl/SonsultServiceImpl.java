package com.ed.service.impl;

import com.ed.mapper.*;
import com.ed.pojo.Course;
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

    @Autowired
    CourseMapper courseMapper;

    @Override
    public int sonsultPage() throws Exception{
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User)session.getAttribute("user");
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
        //添加评教对象
        Sonsult s = new Sonsult();
        //查询当前学期
        User u = userMapper.selectByPrimaryKey(user.getUserId());
        //查询课程、教师
        List<Course> list = courseMapper.selectByUserSon(user.getUserSno());
        //通过查询到的课程查询Sonsult表中是否已经存在了该课程
        for (Course c : list){
            List<Course> list1 = sonsultMapper.selectByCourse(c.getCourseName());
            System.out.println(list1.size());
            if (list1.size()==0){
                System.out.println("进来了");
                    s.setSonsultSemester(u.getUserSemester());
                    s.setSonsultCourse(c.getCourseName());
                    s.setSonsultTeacher(c.getCourseTeacher());
                    s.setSonsultState(0);
                    s.setUserSno(user.getUserSno());
                    sonsultMapper.insertSelective(s);
            }
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
        List<Sonsult> list = sonsultMapper.selectByUserId(user.getUserSno());
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
}
