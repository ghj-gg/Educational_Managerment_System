package com.ed.service;

import com.ed.pojo.FileResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public interface FileResourcesService {

    public Map<String, Object> pageMap(FileResources fileResources);

    String fileTrans(@RequestParam("file") MultipartFile[] multipartFiles);

    int insert(List<FileResources> files);

    public ResponseEntity<byte[]> fileDownLoad(FileResources fileResources) throws IOException;
}
