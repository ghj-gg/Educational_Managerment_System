package com.ed.mapper;

import com.ed.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User queryPersonByPersonName(String userSno);

    String selectRole(String userSno);

    User selectTIdByTeacherName(String sonsultTeacher);
}