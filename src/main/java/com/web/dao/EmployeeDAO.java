package com.web.dao;

import com.web.model.Account;
import com.web.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeDAO extends CrudRepository<Employee, String> {


     Employee findByEmployeeId(int id);
     Employee findByEmployeeId(String id);

    void deleteByEmployeeId(int id);

    Iterable<Employee> findByName(String name);

}
