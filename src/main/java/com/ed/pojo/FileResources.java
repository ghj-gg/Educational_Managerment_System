package com.ed.pojo;

import java.io.Serializable;

public class FileResources extends MyPage implements Serializable {
    private Integer fileId;

    private String fileName;

    private String fileSize;

    private String fileProvider;

    private String fileDate;

    private Integer fileCount;

    @Override
    public String toString() {
        return "FileResources{" +
                "fileId=" + fileId +
                ", fileName='" + fileName + '\'' +
                ", fileSize='" + fileSize + '\'' +
                ", fileProvider='" + fileProvider + '\'' +
                ", fileDate='" + fileDate + '\'' +
                ", fileCount=" + fileCount +
                '}';
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileProvider() {
        return fileProvider;
    }

    public void setFileProvider(String fileProvider) {
        this.fileProvider = fileProvider;
    }

    public String getFileDate() {
        return fileDate;
    }

    public void setFileDate(String fileDate) {

        this.fileDate = fileDate;
    }

    public Integer getFileCount() {
        return fileCount;
    }

    public void setFileCount(Integer fileCount) {
        this.fileCount = fileCount;
    }
}