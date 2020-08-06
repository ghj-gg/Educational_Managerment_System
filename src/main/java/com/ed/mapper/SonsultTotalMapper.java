package com.ed.mapper;

import com.ed.pojo.SonsultTotal;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SonsultTotalMapper {
    int deleteByPrimaryKey(Integer sonsultTotalId);

    int insert(SonsultTotal record);

    int insertSelective(SonsultTotal record);

    SonsultTotal selectByPrimaryKey(Integer sonsultTotalId);

    int updateByPrimaryKeySelective(SonsultTotal record);

    int updateByPrimaryKey(SonsultTotal record);

    @Select("select AVG(sonsult_total_count) as avg from sonsult_total where sonsult_total_class = #{classC}")
    Double selectAvg(String classC);
}