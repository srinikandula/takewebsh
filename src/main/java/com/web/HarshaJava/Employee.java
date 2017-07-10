package com.web.HarshaJava;

/**
 * Created by sriharshakota on 7/9/17.
 */
public class Employee {
    private String DeptName;
    private int Id;

    public Employee(String dept, int i) {
        this.DeptName = dept;
        this.Id = i;
    }

    public void setDeptName(String name) { this.DeptName = name; }
    public String getDeptName() {return DeptName;}
    public void setId(int Id){ this.Id = Id; }
    public int getId() {
        return Id;
    }

}
