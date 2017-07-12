package com.web.AbhinavJava;

import com.web.AbhinavJava.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by surap on 7/9/2017.
 */
public class MapExample {
    public static void main(String[] args) {
        MapExample example = new MapExample();
        List<Employee> employees = new ArrayList<>();
        for(int i=0;i<20;i++){
            String DeptName;
            if(i%3 == 0) {
                DeptName = "Sales";
            }
            else if(i%2 == 0) {
                DeptName = "Marketing";
            }
            else {
                DeptName = "Admin";
            }
            employees.add(new Employee(DeptName,100+i));
        }
        Map<String, List<Employee>> group = example.groupEmployeesByDept(employees);
        System.out.println("Count of Employees in Sales " + group.get("Sales").size());
    }


    public Map<String, List<Employee>> groupEmployeesByDept(List<Employee> employees) {
        Map<String, List<Employee>> group = new HashMap<>();
        for(Employee employee: employees) {
            if(group.get(employee.getDeptName()) == null){ // if department does not exist
                group.put(employee.getDeptName(), new ArrayList<Employee>());
            }
            group.get(employee.getDeptName()).add(employee);
        }
        //{"Admin":[{101,Admin},{104,Admin}],"Sales":[{102,Sales}],"Marketing":[{103,Marketing}]}
        return group;
    }

}