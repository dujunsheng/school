package com.school.po;

public class Class {
    private Integer classId;

    private Integer clazz;

    private Integer grade;

    private String headTeaId;

    private String momitorId;

    private Integer sum;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getClazz() {
        return clazz;
    }

    public void setClazz(Integer clazz) {
        this.clazz = clazz;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getHeadTeaId() {
        return headTeaId;
    }

    public void setHeadTeaId(String headTeaId) {
        this.headTeaId = headTeaId == null ? null : headTeaId.trim();
    }

    public String getMomitorId() {
        return momitorId;
    }

    public void setMomitorId(String momitorId) {
        this.momitorId = momitorId == null ? null : momitorId.trim();
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
}