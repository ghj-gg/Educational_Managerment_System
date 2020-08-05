package com.ed.service.impl;

import com.ed.mapper.YiqingMapper;
import com.ed.pojo.Info;
import com.ed.service.YiqingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class YiqingServiceImpl implements YiqingService {

   @Autowired
    YiqingMapper yiqingMapper;


    @Override
    public List<HashMap<String, String>> yiqingfenxi() {
        List<HashMap<String, String>> mapList = new ArrayList<>();
        HashMap<String,String> confimMap = new HashMap<>();
        confimMap.put("name","现有确诊");
        confimMap.put("value",yiqingMapper.confimCount()+"");
        HashMap<String,String> curedMap = new HashMap<>();
        curedMap.put("name","现有治愈");
        curedMap.put("value",yiqingMapper.curedCount()+"");
        HashMap<String,String> deadMap = new HashMap<>();
        deadMap.put("name","现有死亡");
        deadMap.put("value",yiqingMapper.deadCount()+"");
        mapList.add(confimMap);
        mapList.add(curedMap);
        mapList.add(deadMap);

       return mapList;
    }

    @Override
    public List<List<String>> provinceCuredQianWu(String cityName) {
        List<List<String>> lists = new ArrayList<>();
        List<String> listCity = new ArrayList<>();
        List<String> listCount= new ArrayList<>();
        List<Info> infos = yiqingMapper.provinceCuredQianWu(cityName);
        for (Info info : infos) {
            listCity.add(info.getAreaName());
            listCount.add(info.getCuredCount()+"");
        }
        lists.add(listCity);
        lists.add(listCount);
        return lists;
    }

    @Override
    public List<List<String>> deadCountQianWu(String cityName) {
        List<List<String>> lists = new ArrayList<>();
        List<Info> infos = yiqingMapper.deadCountQianWu(cityName);
        List<String> listCity = new ArrayList<>();
        List<String> listCount = new ArrayList<>();
        for (Info info : infos) {
            listCity.add(info.getAreaName());
            listCount.add(info.getDeadCount()+"");
        }
        lists.add(listCity);
        lists.add(listCount);
        return lists;
    }

    @Override
    public List<HashMap<String, String>> provinceyiqingfenxi(String cityName) {
        List<HashMap<String, String>> mapList  = new ArrayList<>();
          HashMap<String,String> confimMap = new HashMap<>();
          HashMap<String,String> deadMap = new HashMap<>();
          HashMap<String,String> curedMap = new HashMap<>();
          Info info = yiqingMapper.provinceyiqingfenxi(cityName);
          confimMap.put("name","现有确诊");
          confimMap.put("value",info.getConfirmCount()+"");
          deadMap.put("name","现有死亡");
          deadMap.put("value",info.getDeadCount()+"");
          curedMap.put("name","现有治愈");
          curedMap.put("value",info.getCuredCount()+"");
           mapList.add(confimMap);
           mapList.add(deadMap);
           mapList.add(curedMap);
        return mapList;
    }

    @Override
    public List<HashMap<String, String>> selectChinaInfo() {
        List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
        List<Info>  infos = yiqingMapper.selectChinaInfo();
        for(Info i:infos){
            HashMap<String, String> map=new HashMap<>();
            map.put("name", i.getProvinceName());
            list.add(map);
        }
        return list;
    }
}
