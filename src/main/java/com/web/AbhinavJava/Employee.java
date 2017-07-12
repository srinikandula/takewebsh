package com.web.AbhinavJava;


/**
 * Created by surap on 7/9/2017.
 */

public class Employee {
    private String DeptName;
    private int id;
    public Employee(String DeptName, int id) {
        this.DeptName = DeptName;
        this.id = id;
    }

    public void setDeptName(String DeptName) { this.DeptName = DeptName; }
    public String getDeptName() {return DeptName;}
    public void setId(int id){ this.id = id; }
    public int getId() {
        return id;
    }
}
