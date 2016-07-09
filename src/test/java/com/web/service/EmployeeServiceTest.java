package com.web.service;

import com.web.dao.EmployeeDAO;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by CrazyNaveen on 4/12/16.
 */
public class EmployeeServiceTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();


    @Test
    public void testCreateEmployee() throws Exception {
        EmployeeService employeeService = new EmployeeService();
        String name = "kee";
        String address = null;
        String  salary = "789";
        /*EmployeeDAO employeeDAO = mock(EmployeeDAO.class);
        employeeService.setEmployeeDAO(employeeDAO);*/
        expectedEx.expect(NullPointerException.class);
        expectedEx.expectMessage("Invalid name, address, salary");
        employeeService.createEmployee(name,address,salary);

    }

    @Test
    public void testNullCheck() throws Exception {
        EmployeeService employeeService = new EmployeeService();
        String id = "100";
        String name = null;
        String address = "NJ";
        String salary = "7000";
        EmployeeDAO employeeDAO = mock(EmployeeDAO.class);
        when(employeeDAO.findByEmployeeId(Integer.parseInt("100"))).thenThrow(NullPointerException.class);
        employeeService.setEmployeeDAO(employeeDAO);
        expectedEx.expect(NullPointerException.class);
        employeeService.nullCheck(id, name,address, salary);

    }

    @Test
    public void testDeleteEmployee() throws Exception {
        EmployeeService employeeService = new EmployeeService();
        String id = null;
        /*EmployeeDAO employeeDao = mock(EmployeeDAO.class);
        when(employeeDao.findByEmployeeId(Integer.parseInt("123"))).thenThrow(NullPointerException.class);
        employeeService.setEmployeeDAO(employeeDao);*/
        expectedEx.expect(NullPointerException.class);
        expectedEx.expectMessage("Invalid id found..");
        employeeService.deleteEmployee(id);
    }

    @Test
    public void testDeleteEmployeeWithInvalidId() throws Exception {
        EmployeeService employeeService = new EmployeeService();
        String id = "123";
        EmployeeDAO employeeDao = mock(EmployeeDAO.class);
        when(employeeDao.findByEmployeeId(Integer.parseInt("123"))).thenThrow(NullPointerException.class);
        //employeeService.setEmployeeDAO(employeeDao);
        expectedEx.expect(NullPointerException.class);
        //expectedEx.expectMessage("Invalid id found..");
        employeeService.deleteEmployee(id);
    }

}