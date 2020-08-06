package com.ed.service;

import com.ed.pojo.Class;
import com.ed.pojo.SonsultTotal;

import java.util.HashMap;

public interface SonsulTotalService {

    HashMap<String, Object> selectClassByPage(Class class1);

    String selectCountByClass(String classC);


}
