package com.ed.mapper;

import com.ed.pojo.FileResources;

import java.util.List;

public interface FileResourcesMapper {
    int deleteByPrimaryKey(Integer fileId);

    int insert(List<FileResources> fileResources);

    int insertSelective(FileResources record);

    FileResources selectByPrimaryKey(Integer fileId);

    int updateByPrimaryKeySelective(FileResources record);

    int updateByPrimaryKey(FileResources record);

    List<FileResources> queryAll(FileResources fileResources);
}