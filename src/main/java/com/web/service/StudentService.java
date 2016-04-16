package com.web.service;

import com.web.dao.StudentDAO;
import com.web.model.Student;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by devendra on 4/2/2016.
 */
@Service
public class StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    @Setter
    public StudentDAO studentDAO;

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
    public void updateStudent(String id, String firstName, String lastName) {
        if(firstName == null){
            throw new NullPointerException("Invalid Data found for First Name");
        }

        Student student = studentDAO.findByStudentId(Integer.parseInt(id));
        if(student == null){
            throw new NullPointerException("Invalid ID");
        }
        student.setFirstName(firstName);
        student.setLastName(lastName);
        studentDAO.save(student);
    }

    public void deleteStudent(String id) {
        Student student = new Student();
        if(student == null){
            throw new NullPointerException("Invalid ID");
        }
        student.setStudentId(Integer.parseInt(id));
        studentDAO.delete(student);
    }

}

