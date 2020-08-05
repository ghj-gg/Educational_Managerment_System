package com.ed.mapper;

import com.ed.pojo.SonsultTotal;

import java.util.List;

public interface SonsultTotalMapper {
    int deleteByPrimaryKey(Integer sonsultTotalId);

    int insert(SonsultTotal record);

    int insertSelective(SonsultTotal record);

    SonsultTotal selectByPrimaryKey(Integer sonsultTotalId);

    int updateByPrimaryKeySelective(SonsultTotal record);

    int updateByPrimaryKey(SonsultTotal record);

    List<SonsultTotal> selectSonsultTotalByUserSno(int userId);
}