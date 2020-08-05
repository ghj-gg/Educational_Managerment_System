package com.ed.pojo;

public class Date {
    private Integer dateId;

    private String sonsultDateStart;

    private String sonsultDateEnd;

    private String courseDateStart;

    private String courseDateEnd;

    private String userSno;

    private String semester;

    public Integer getDateId() {
        return dateId;
    }

    public void setDateId(Integer dateId) {
        this.dateId = dateId;
    }

    public String getSonsultDateStart() {
        return sonsultDateStart;
    }

    public void setSonsultDateStart(String sonsultDateStart) {
        this.sonsultDateStart = sonsultDateStart;
    }

    public String getSonsultDateEnd() {
        return sonsultDateEnd;
    }

    public void setSonsultDateEnd(String sonsultDateEnd) {
        this.sonsultDateEnd = sonsultDateEnd;
    }

    public String getCourseDateStart() {
        return courseDateStart;
    }

    public void setCourseDateStart(String courseDateStart) {
        this.courseDateStart = courseDateStart;
    }

    public String getCourseDateEnd() {
        return courseDateEnd;
    }

    public void setCourseDateEnd(String courseDateEnd) {
        this.courseDateEnd = courseDateEnd;
    }

    public String getUserSno() {
        return userSno;
    }

    public void setUserSno(String userSno) {
        this.userSno = userSno;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Date() {
    }

    public Date(Integer dateId, String sonsultDateStart, String sonsultDateEnd, String courseDateStart, String courseDateEnd, String userSno, String semester) {
        this.dateId = dateId;
        this.sonsultDateStart = sonsultDateStart;
        this.sonsultDateEnd = sonsultDateEnd;
        this.courseDateStart = courseDateStart;
        this.courseDateEnd = courseDateEnd;
        this.userSno = userSno;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Date{" +
                "dateId=" + dateId +
                ", sonsultDateStart='" + sonsultDateStart + '\'' +
                ", sonsultDateEnd='" + sonsultDateEnd + '\'' +
                ", courseDateStart='" + courseDateStart + '\'' +
                ", courseDateEnd='" + courseDateEnd + '\'' +
                ", userSno='" + userSno + '\'' +
                ", semester='" + semester + '\'' +
                '}';
    }
}