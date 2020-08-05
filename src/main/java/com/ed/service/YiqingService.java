package com.ed.service;

import java.util.HashMap;
import java.util.List;

public interface YiqingService {
    List<HashMap<String, String>> yiqingfenxi();

    List<List<String>> provinceCuredQianWu(String cityName);

    List<List<String>> deadCountQianWu(String cityName);

    List<HashMap<String, String>> provinceyiqingfenxi(String cityName);

    List<HashMap<String, String>> selectChinaInfo();
}
