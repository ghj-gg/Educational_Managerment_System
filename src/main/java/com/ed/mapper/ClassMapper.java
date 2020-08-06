package com.ed.mapper;

import com.ed.pojo.Class;

import java.util.List;

public interface ClassMapper {
    int deleteByPrimaryKey(Integer claasId);

    int insert(Class record);

    int insertSelective(Class record);

    Class selectByPrimaryKey(Integer claasId);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);

    List<Class> selectClassByUserSon(String userSno);
}