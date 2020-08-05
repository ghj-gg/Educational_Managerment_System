package com.ed.mapper;

import com.ed.pojo.Info;

import java.util.HashMap;
import java.util.List;

public interface YiqingMapper {

    int deadCount();
    int confimCount();
    int curedCount();

    List<Info> provinceCuredQianWu(String cityName);

    List<Info> deadCountQianWu(String cityName);

    Info provinceyiqingfenxi(String cityName);

    List<Info> selectChinaInfo();
}
