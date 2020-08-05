package com.ed.pojo;

import java.util.HashMap;

public class SonsultTotal extends MyPage{
    private Integer sonsultTotalId;

    private Integer sonsultTotalA;

    private Integer sonsultTotalB;

    private Integer sonsultTotalC;

    private Integer sonsultTotalD;

    private String sonsultTotalMessage;

    private Integer sonsultTotalCount;

    private Integer sonsultTotalTid;

    private String sonsultTotalClass;

    public Integer getSonsultTotalId() {
        return sonsultTotalId;
    }

    public void setSonsultTotalId(Integer sonsultTotalId) {
        this.sonsultTotalId = sonsultTotalId;
    }

    public Integer getSonsultTotalA() {
        return sonsultTotalA;
    }

    public void setSonsultTotalA(Integer sonsultTotalA) {
        this.sonsultTotalA = sonsultTotalA;
    }

    public Integer getSonsultTotalB() {
        return sonsultTotalB;
    }

    public void setSonsultTotalB(Integer sonsultTotalB) {
        this.sonsultTotalB = sonsultTotalB;
    }

    public Integer getSonsultTotalC() {
        return sonsultTotalC;
    }

    public void setSonsultTotalC(Integer sonsultTotalC) {
        this.sonsultTotalC = sonsultTotalC;
    }

    public Integer getSonsultTotalD() {
        return sonsultTotalD;
    }

    public void setSonsultTotalD(Integer sonsultTotalD) {
        this.sonsultTotalD = sonsultTotalD;
    }

    public String getSonsultTotalMessage() {
        return sonsultTotalMessage;
    }

    public void setSonsultTotalMessage(String sonsultTotalMessage) {
        this.sonsultTotalMessage = sonsultTotalMessage;
    }

    public Integer getSonsultTotalCount() {
        return sonsultTotalCount;
    }

    public void setSonsultTotalCount(Integer sonsultTotalCount) {
        this.sonsultTotalCount = sonsultTotalCount;
    }

    public Integer getSonsultTotalTid() {
        return sonsultTotalTid;
    }

    public void setSonsultTotalTid(Integer sonsultTotalTid) {
        this.sonsultTotalTid = sonsultTotalTid;
    }

    public String getSonsultTotalClass() {
        return sonsultTotalClass;
    }

    public void setSonsultTotalClass(String sonsultTotalClass) {
        this.sonsultTotalClass = sonsultTotalClass;
    }

    public SonsultTotal() {
    }

    public SonsultTotal(Integer sonsultTotalId, Integer sonsultTotalA, Integer sonsultTotalB, Integer sonsultTotalC, Integer sonsultTotalD, String sonsultTotalMessage, Integer sonsultTotalCount, Integer sonsultTotalTid, String sonsultTotalClass) {
        this.sonsultTotalId = sonsultTotalId;
        this.sonsultTotalA = sonsultTotalA;
        this.sonsultTotalB = sonsultTotalB;
        this.sonsultTotalC = sonsultTotalC;
        this.sonsultTotalD = sonsultTotalD;
        this.sonsultTotalMessage = sonsultTotalMessage;
        this.sonsultTotalCount = sonsultTotalCount;
        this.sonsultTotalTid = sonsultTotalTid;
        this.sonsultTotalClass = sonsultTotalClass;
    }

    @Override
    public String toString() {
        return "SonsultTotal{" +
                "sonsultTotalId=" + sonsultTotalId +
                ", sonsultTotalA=" + sonsultTotalA +
                ", sonsultTotalB=" + sonsultTotalB +
                ", sonsultTotalC=" + sonsultTotalC +
                ", sonsultTotalD=" + sonsultTotalD +
                ", sonsultTotalMessage='" + sonsultTotalMessage + '\'' +
                ", sonsultTotalCount=" + sonsultTotalCount +
                ", sonsultTotalTid=" + sonsultTotalTid +
                ", sonsultTotalClass='" + sonsultTotalClass + '\'' +
                '}';
    }
}