package com.web.service;

import com.web.dao.StudentDAO;
import com.web.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by devendra on 4/2/2016.
 */
public class StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentDAO studentDAO;

    private Student createAccount(final String firstName, final String lastName) {
        if (firstName == null || firstName.trim().length() == 0) {
            throw new NullPointerException("First name is not valid");
        }
        if (lastName == null || lastName.trim().length() == 0) {
            throw new NullPointerException("Last name is not valid");
        }
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        return studentDAO.save(student);
    }
}
