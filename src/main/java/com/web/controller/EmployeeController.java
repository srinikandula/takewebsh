package com.web.controller;


import com.web.dao.EmployeeDAO;
import com.web.model.Employee;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Api(value = "Employee Controller")
@RestController
@RequestMapping(value = "/employee/v1")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping(value = "/employeeList", method = { RequestMethod.GET })
    public ModelAndView getEmployees(final HttpServletRequest request) throws Exception {
        return gotoEmployeeListPage();
    }

    @RequestMapping(value = "/create", method = { RequestMethod.POST })
    public ModelAndView createEmployee(final HttpServletRequest request) throws Exception {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String salary = request.getParameter("salary");
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAddress(address);
        employee.setSalary(Integer.parseInt(salary));
        employeeDAO.save(employee);
        return gotoEmployeeListPage();
    }

    @RequestMapping(value = "/update", method = { RequestMethod.PUT })
    public ModelAndView updateEmployee(final HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        ModelAndView modelAndView = new ModelAndView("employeeList");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String salary = request.getParameter("salary");
        Employee employee =  employeeDAO.findByEmployeeId(id);
        employee.setName(name);
        employee.setAddress(address);
        employee.setSalary(Integer.parseInt(salary));
        employeeDAO.save(employee);
        return gotoEmployeeListPage();
    }

    @RequestMapping(value = "/delete", method = { RequestMethod.GET })
    public ModelAndView deleteEmployee(final HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = new Employee();
        employee.setEmployeeId(id);
        employeeDAO.delete(employee);
        return gotoEmployeeListPage();
    }

    @RequestMapping(value = "/loadEmployee", method = { RequestMethod.GET })
    public ModelAndView loadEmployee(final HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        ModelAndView modelAndView = new ModelAndView("updateEmployee");
        modelAndView.addObject("load", employeeDAO.findByEmployeeId(id));
        return modelAndView;
    }
    @RequestMapping(value = "/test", method = { RequestMethod.GET })
    public String test(final HttpServletRequest request) {
        return "helloWorld";
    }
    private ModelAndView gotoEmployeeListPage() {
        ModelAndView modelAndView = new ModelAndView("employeeList");
        modelAndView.addObject("employees", employeeDAO.findAll());
        return modelAndView;
    }


}
