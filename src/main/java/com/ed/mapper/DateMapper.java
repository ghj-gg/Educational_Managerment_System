package com.ed.mapper;

import com.ed.pojo.Date;

public interface DateMapper {
    int deleteByPrimaryKey(Integer dateId);

    int insert(Date record);

    int insertSelective(Date record);

    Date selectByPrimaryKey(Integer dateId);

    int updateByPrimaryKeySelective(Date record);

    int updateByPrimaryKey(Date record);

    Date selectDateBySemesterId(String semester);
}