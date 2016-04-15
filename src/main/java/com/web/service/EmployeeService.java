package com.web.service;

import com.web.dao.EmployeeDAO;
import com.web.model.Employee;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by CrazyNaveen on 4/2/16.
 */
@Component
@Transactional
public class EmployeeService {

    @Autowired
    @Setter
    private EmployeeDAO employeeDAO;


    public Employee createEmployee(final String name, final String address, final String salary){
        if(name == null || name.trim().length() == 0){
            throw new NullPointerException("Invalid name, address, salary");
        }
        if(address == null || address.trim().length() == 0){
            throw new NullPointerException("Invalid name, address, salary");
        }
        if(salary == null || salary.trim().length() == 0){
            throw new NullPointerException("Invalid name, address, salary");
        }
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAddress(address);
        employee.setSalary(Integer.parseInt(salary));
       // employee.setSalary(salary);
        return employeeDAO.save(employee);
    }

    public void nullCheck(String id, String name, String address, String salary) {
        if(name == null){
            throw new NullPointerException("Invalid data for Employee name");
        }
        Employee employee = employeeDAO.findByEmployeeId(Integer.parseInt(id));

        if(employee == null) {
            throw new NullPointerException("Invalid employee id found");
        }
        employee.setName(name);
        employee.setAddress(address);
        employee.setSalary(Integer.parseInt(salary));
        //employee.setSalary(salary);
        employeeDAO.save(employee);

    }


    public void updateEmployee(String id, String name, String address, String salary) {
        if(name == null){
            throw new NullPointerException("Invalid data for Employee name");
        }
        Employee employee = employeeDAO.findByEmployeeId(Integer.parseInt(id));

        if(employee == null) {
            throw new NullPointerException("Invalid employee id found");
        }
        employee.setName(name);
        employee.setAddress(address);
        employee.setSalary(Integer.parseInt(salary));
        //employee.setSalary(salary);
        employeeDAO.save(employee);

    }



    public void deleteEmployee(String id){

        if( id == null ){
            throw  new NullPointerException("Invalid id found..");
        }
        Employee employee = employeeDAO.findByEmployeeId(Integer.parseInt(id));
        employeeDAO.save(employee);

    }


}
