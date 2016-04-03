package com.web.dao;

import com.web.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by devendra on 4/2/2016.
 */
@Repository
public interface StudentDAO extends CrudRepository<Student, String> {
    public Student findByStudentId (int id);
}
