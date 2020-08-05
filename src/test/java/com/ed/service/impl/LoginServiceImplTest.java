package com.ed.service.impl;

import com.ed.mapper.FileResourcesMapper;
import com.ed.mapper.UserMapper;
import com.ed.pojo.FileResources;
import com.ed.pojo.User;
import com.ed.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class LoginServiceImplTest {

    @Autowired
    UserMapper mapper;
    @Autowired
    FileResourcesMapper fileResourcesMapper;

    @Test
    public void selectRole() {
        User user = mapper.queryPersonByPersonName("20203");
        System.out.println(user);
    }
}