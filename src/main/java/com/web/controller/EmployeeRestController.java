package com.web.controller;

import com.web.controller.util.ControllerUtils;
import com.web.dao.EmployeeDAO;
import com.web.model.Account;
import com.web.model.Employee;
import com.web.service.EmployeeService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

/**
 * Created by CrazyNaveen on 4/12/16.
 */
@Api(value = "Employee Controller")
@RequestMapping(value = "/api/employee")
@RestController
public class EmployeeRestController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired(required = true)
    private EmployeeService employeeService;

    @RequestMapping(value = "/employeeListJstl", method = { RequestMethod.GET },  produces = ControllerUtils.JSON_UTF8)
    public Iterable<Employee> getEmployees(final HttpServletRequest request) throws Exception {
        return employeeDAO.findAll();
    }

    @RequestMapping(value = "/create", method = { RequestMethod.POST }, produces = MediaType.TEXT_PLAIN)
    public String createEmployee(final HttpServletRequest request) throws Exception {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String salary = request.getParameter("salary");
        Iterable<Employee> employees = employeeDAO.findByName(name) ;
        if(employees.iterator().hasNext()) {
            throw new RuntimeException("Employee with same names found");
        }
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAddress(address);
        employee.setSalary(Integer.parseInt(salary));
        employeeDAO.save(employee);
        return "Employee is created";
    }

    @RequestMapping(value = "/update/{employeeId}", method = { RequestMethod.PUT }, produces = MediaType.TEXT_PLAIN)
    public String updateEmployee(final HttpServletRequest request, @PathVariable String employeeId) throws Exception {
       // String id = request.getParameter("id");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String salary = request.getParameter("salary");
        employeeService.updateEmployee(employeeId, name, address, salary);
        return "Employee is updated";
    }

    @RequestMapping(value = "/delete", method = { RequestMethod.DELETE },  produces = MediaType.TEXT_PLAIN)
    public String deleteEmployee(final HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        //Employee employee = new Employee();
       // employee.setEmployeeId(Integer.parseInt(id));
        Employee employee = employeeDAO.findByEmployeeId(Integer.parseInt(id));
        employeeDAO.delete(employee);
        return "Employee is deleted";
    }

    @RequestMapping(value = "/{id}", method = { RequestMethod.GET }, produces = ControllerUtils.JSON_UTF8)
    public Employee getEmployee(final HttpServletRequest request, @PathVariable String id) throws Exception {
       // int id = Integer.parseInt(request.getParameter("id"));
       Employee employee = employeeDAO.findByEmployeeId(new Integer(id));
        return employee;
    }

    @RequestMapping(value = "/hasNameUsed", method = { RequestMethod.GET }, produces = MediaType.TEXT_PLAIN)
    public boolean findEmployeeByName(final HttpServletRequest request) throws Exception {
        String name = request.getParameter("name");
        Iterable<Employee> employees = employeeDAO.findByName(name);
        if(employees != null && employees.iterator().hasNext()) {
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping(value = "/test", method = { RequestMethod.GET })
    public String test(final HttpServletRequest request) {
        return "helloWorld";
    }

}
