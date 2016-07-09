package com.web.dao;

import com.web.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by devendra on 4/2/2016.
 */
@Repository
public interface StudentDAO extends CrudRepository<Student, String> {
    public Student findByStudentId (int id);
    public Student findByStudentId(String studentId);
    Iterable<Student> findByFirstNameAndLastName(String firstName, String lastName);
    //@Query("delete from Student s where s.StudentId=?1")
    void delete(String studentId);
    Iterable<Student> findByFirstName(String fName);
}
