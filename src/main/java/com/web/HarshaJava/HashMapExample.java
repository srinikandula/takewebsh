package com.web.HarshaJava;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by sriharshakota on 7/9/17.
 */
public class HashMapExample {
    public static void main(String[] args) {
        HashMapExample example = new HashMapExample();
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String dept = "Admin";
            if (i % 3 == 0) {
                dept = "Sales";
            } else if (i % 2 == 0) {
                dept = "Marketing";
            }
            employees.add(new Employee(dept, 100 + i));
        }
        Map<String, List<Employee>> group = example.groupEmployeesByDept(employees);

        System.out.println("Count of Employees in Sales " + group.get("Sales").size());
    }

        public Map<String, List<Employee>> groupEmployeesByDept (List < Employee > employees) {
            Map<String, List<Employee>> group = new HashMap<>();
            for (Employee employee : employees) {
                if (group.get(employee.getDeptName()) == null) {
                    group.put(employee.getDeptName(), new ArrayList<Employee>());
                }
                group.get(employee.getDeptName()).add(employee);
            }
            return group;
        }

    }
