package com.xiaofan.retrofit_okhttp_rxjava_demo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fanjianhai on 2017/3/14.
 */
public class Student implements Serializable {

    private String stuName;

    private String deptName;

    private List<Course> courses;

    public Student() {}

    public Student(String stuName, String deptName, List<Course> courses) {
        this.stuName = stuName;
        this.deptName = deptName;
        this.courses = courses;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuName='" + stuName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", courses=" + courses +
                '}';
    }
}
