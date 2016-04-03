package com.web.dao;

import com.web.model.Account;
import com.web.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeDAO extends CrudRepository<Employee, String> {


    public Employee findByEmployeeId(int id);




}
