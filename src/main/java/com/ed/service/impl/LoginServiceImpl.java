package com.ed.service.impl;

import com.ed.mapper.UserMapper;
import com.ed.pojo.User;
import com.ed.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public String checkLogin(User user) {
        Subject s = SecurityUtils.getSubject();
            //UsernamePasswordToken 令牌类  稍后会把保存在里面账号密码和shiro的身份和凭证比对
            UsernamePasswordToken upt = new UsernamePasswordToken(user.getUserSno(), user.getUserPassword());
            try {
                //进行认证(因为我们写了自定义的realm类，所以会自动到realm类里面去认证)
                System.out.println("进行验证的用户"+user);
                s.login(upt);
                return "success";
            } catch (AuthenticationException e) {
                //登录失败
                return "ERROR";
            }

    }

    @Override
    public String selectRole() {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getSession().getAttribute("user");
       String role = userMapper.selectRole(user.getUserSno());
        return role;
    }
}
