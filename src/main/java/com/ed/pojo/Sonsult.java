package com.ed.pojo;

public class Sonsult extends MyPage{
    private Integer sonsultId;

    private String sonsultSemester;

    private String sonsultCourse;

    private String sonsultTeacher;

    private Integer sonsultState;

    private String sonsultStart;

    private String sonsultEnd;

    public Integer getSonsultId() {
        return sonsultId;
    }

    public void setSonsultId(Integer sonsultId) {
        this.sonsultId = sonsultId;
    }

    public String getSonsultSemester() {
        return sonsultSemester;
    }

    public void setSonsultSemester(String sonsultSemester) {
        this.sonsultSemester = sonsultSemester;
    }

    public String getSonsultCourse() {
        return sonsultCourse;
    }

    public void setSonsultCourse(String sonsultCourse) {
        this.sonsultCourse = sonsultCourse;
    }

    public String getSonsultTeacher() {
        return sonsultTeacher;
    }

    public void setSonsultTeacher(String sonsultTeacher) {
        this.sonsultTeacher = sonsultTeacher;
    }

    public Integer getSonsultState() {
        return sonsultState;
    }

    public void setSonsultState(Integer sonsultState) {
        this.sonsultState = sonsultState;
    }

    public String getSonsultStart() {
        return sonsultStart;
    }

    public void setSonsultStart(String sonsultStart) {
        this.sonsultStart = sonsultStart;
    }

    public String getSonsultEnd() {
        return sonsultEnd;
    }

    public void setSonsultEnd(String sonsultEnd) {
        this.sonsultEnd = sonsultEnd;
    }

    public Sonsult() {
    }

    public Sonsult(Integer sonsultId, String sonsultSemester, String sonsultCourse, String sonsultTeacher, Integer sonsultState, String sonsultStart, String sonsultEnd) {
        this.sonsultId = sonsultId;
        this.sonsultSemester = sonsultSemester;
        this.sonsultCourse = sonsultCourse;
        this.sonsultTeacher = sonsultTeacher;
        this.sonsultState = sonsultState;
        this.sonsultStart = sonsultStart;
        this.sonsultEnd = sonsultEnd;
    }

    @Override
    public String toString() {
        return "Sonsult{" +
                "sonsultId=" + sonsultId +
                ", sonsultSemester='" + sonsultSemester + '\'' +
                ", sonsultCourse='" + sonsultCourse + '\'' +
                ", sonsultTeacher='" + sonsultTeacher + '\'' +
                ", sonsultState=" + sonsultState +
                ", sonsultStart='" + sonsultStart + '\'' +
                ", sonsultEnd='" + sonsultEnd + '\'' +
                '}';
    }
}