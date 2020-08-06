package com.ed.service.impl;

import com.ed.mapper.ClassMapper;
import com.ed.mapper.SonsultTotalMapper;
import com.ed.pojo.Class;
import com.ed.pojo.SonsultTotal;
import com.ed.pojo.User;
import com.ed.service.SonsulTotalService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SonsulTotalServiceImpl implements SonsulTotalService {
    @Autowired
    ClassMapper classMapper;

    @Autowired
    SonsultTotalMapper sonsultTotalMapper;

    @Override
    public HashMap<String, Object> selectClassByPage(Class class1) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User)session.getAttribute("user");
        //通过教师id查询班级
        List<Class> list = classMapper.selectClassByUserSon(user.getUserSno());
        PageHelper.startPage(class1.getPage(),class1.getRow());
        PageInfo<Class> pageInfo = new PageInfo<>(list);
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("list",pageInfo.getList());
        map.put("numPage",pageInfo.getPageNum());
        map.put("count",pageInfo.getTotal());
        map.put("prePage",pageInfo.getPrePage());
        map.put("nextPage",pageInfo.getNextPage());
        map.put("indexPage",pageInfo.getFirstPage());
        map.put("endPage",pageInfo.getLastPage());
        map.put("allPage",pageInfo.getPageSize());
        return map;
    }

    @Override
    public String selectCountByClass(String classC) {
        Double avg = sonsultTotalMapper.selectAvg(classC);
        if(avg == null){
            return "未评分";
        }
        return avg+"";
    }

}
