package com.web.service;

import com.web.dao.EmployeeDAO;
import com.web.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by CrazyNaveen on 4/2/16.
 */
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;


    public Employee createAccount(final String name, final String address){
        if(name == null || name.trim().length() == 0){
            throw new NullPointerException("First name is not valid");
        }
        if(address == null || address.trim().length() == 0){
            throw new NullPointerException("Last name is not valid");
        }
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAddress(address);
        return employeeDAO.save(employee);
    }

}
