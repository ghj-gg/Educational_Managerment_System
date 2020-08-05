package com.ed.service;

import com.ed.pojo.Date;
import com.ed.pojo.Sonsult;
import com.ed.pojo.SonsultTotal;

import java.util.HashMap;
import java.util.List;

public interface SonsultService {

    int sonsultPage() throws Exception;

    HashMap selectSonsultByPage(Sonsult sonsult);

    int addSonsultTotal(SonsultTotal sonsultTotal);

    HashMap<String, Object> selectSonsultTotalByPage(SonsultTotal sonsultTotal);
}
