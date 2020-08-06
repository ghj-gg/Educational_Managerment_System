package com.ed.pojo;

public class Class extends MyPage{
    private Integer claasId;

    private String classTecherSno;

    private String classDep;

    private String classC;

    private String classLocation;

    private String classWeek;

    private String classNum;

    public Integer getClaasId() {
        return claasId;
    }

    public void setClaasId(Integer claasId) {
        this.claasId = claasId;
    }

    public String getClassTecherSno() {
        return classTecherSno;
    }

    public void setClassTecherSno(String classTecherSno) {
        this.classTecherSno = classTecherSno;
    }

    public String getClassDep() {
        return classDep;
    }

    public void setClassDep(String classDep) {
        this.classDep = classDep;
    }

    public String getClassC() {
        return classC;
    }

    public void setClassC(String classC) {
        this.classC = classC;
    }

    public String getClassLocation() {
        return classLocation;
    }

    public void setClassLocation(String classLocation) {
        this.classLocation = classLocation;
    }

    public String getClassWeek() {
        return classWeek;
    }

    public void setClassWeek(String classWeek) {
        this.classWeek = classWeek;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public Class() {
    }

    public Class(Integer claasId, String classTecherSno, String classDep, String classC, String classLocation, String classWeek, String classNum) {
        this.claasId = claasId;
        this.classTecherSno = classTecherSno;
        this.classDep = classDep;
        this.classC = classC;
        this.classLocation = classLocation;
        this.classWeek = classWeek;
        this.classNum = classNum;
    }

    @Override
    public String toString() {
        return "Class{" +
                "claasId=" + claasId +
                ", classTecherSno='" + classTecherSno + '\'' +
                ", classDep='" + classDep + '\'' +
                ", classC='" + classC + '\'' +
                ", classLocation='" + classLocation + '\'' +
                ", classWeek='" + classWeek + '\'' +
                ", classNum='" + classNum + '\'' +
                '}';
    }
}