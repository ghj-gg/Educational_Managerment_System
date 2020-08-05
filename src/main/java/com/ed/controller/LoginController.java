package com.ed.controller;

import com.ed.pojo.User;
import com.ed.service.LoginService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
@RequestMapping("loginController")
public class LoginController {
    @Autowired
    private LoginService loginService;


    @RequestMapping("welcome.do")
    public String welcome(Model model){
      model.addAttribute("user",(User)SecurityUtils.getSubject().getSession().getAttribute("user"));
        return "login/welcome";
    }


    @RequestMapping("index.do")
    public String index(Model model) {
      String role = loginService.selectRole();
       model.addAttribute("role",role);
        return "login/index";
    }

    @RequestMapping("noLogin.do")
    public String nologin() {
        return "login/login";
    }

    @RequestMapping("checkLogin.ajax")
    @ResponseBody
    public String checkLogin(User user) {
        String check = loginService.checkLogin(user);
        return check;
    }

    @RequestMapping("login.do")
    public String language(@RequestParam("locale") String locale, HttpServletRequest request, HttpServletResponse response){
            if (locale.equals("zh")) {
                Locale locale1 = new Locale("zh", "CN");
                (new CookieLocaleResolver()).setLocale(request, response, locale1);
            } else if (locale.equals("en")) {
                Locale locale1 = new Locale("en", "US");
                (new CookieLocaleResolver()).setLocale(request, response, locale1);
            } else
                (new CookieLocaleResolver()).setLocale(request, response, LocaleContextHolder.getLocale());

        return "login/login";
    }
}
