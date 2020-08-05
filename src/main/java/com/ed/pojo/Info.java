package com.ed.pojo;

import java.io.Serializable;

public class Info implements Serializable {
    private int code;
    private String time;
    private String provinceName;
    private String areaName;
    private String confirmCount;
    private String curedCount;
    private String deadCount;
    private String locationId;

    @Override
    public String toString() {
        return "Info{" +
                "code=" + code +
                ", time='" + time + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", areaName='" + areaName + '\'' +
                ", confirmCount='" + confirmCount + '\'' +
                ", curedCount='" + curedCount + '\'' +
                ", deadCount='" + deadCount + '\'' +
                ", locationId='" + locationId + '\'' +
                '}';
    }

    public Info() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getConfirmCount() {
        return confirmCount;
    }

    public void setConfirmCount(String confirmCount) {
        this.confirmCount = confirmCount;
    }

    public String getCuredCount() {
        return curedCount;
    }

    public void setCuredCount(String curedCount) {
        this.curedCount = curedCount;
    }

    public String getDeadCount() {
        return deadCount;
    }

    public void setDeadCount(String deadCount) {
        this.deadCount = deadCount;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }
}
