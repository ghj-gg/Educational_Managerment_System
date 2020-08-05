package com.ed.config;

import com.ed.mapper.UserMapper;
import com.ed.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper um;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String  principal = (String) principalCollection.getPrimaryPrincipal();
        String role = um.selectRole(principal);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole(role);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)  {
        System.out.println(111111);
        //1.将token强转为UsernamePasswordToken类型（可以通过这个类型可以拿到身份(用户名)）
        UsernamePasswordToken token1 = (UsernamePasswordToken) token;
        User user = um.queryPersonByPersonName(token1.getUsername());
        System.out.println("user="+user);
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("user",user);
        if (user == null) {
           return  null;
        }
        ByteSource salt = ByteSource.Util.bytes(user.getUserSno());
        return new SimpleAuthenticationInfo(user.getUserSno(), user.getUserPassword(), salt, getName());
    }
}
