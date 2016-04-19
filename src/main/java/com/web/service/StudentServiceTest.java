package com.web.service;

import com.web.dao.StudentDAO;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

/**
 * Created by devendra on 4/5/2016.
 */
public class StudentServiceTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testSaveStudent() throws Exception {
        StudentService studentService = new StudentService();
        String id = "123";
        String firstName =null;
        String lastName = "hello";
        expectedException.expect(NullPointerException.class);
        studentService.updateStudent(id, firstName, lastName);

    }

    @Test
    public void testUpdateWithInvalidId() throws Exception {
        StudentService studentService = new StudentService();
        String id = "123";
        String firstName ="hi";
        String lastName = "hello";
        StudentDAO studentDAO = mock(StudentDAO.class);
        when(studentDAO.findByStudentId(("123"))).thenThrow(NullPointerException.class);
        studentService.setStudentDAO(studentDAO);
        expectedException.expect(NullPointerException.class);
        studentService.updateStudent((id), firstName, lastName);
    }

    @Test(expected = Exception.class)
    public void testDeleteWithInvalidId() throws Exception {
            StudentService studentService = new StudentService();
            String id = "123";
            StudentDAO studentDAO = mock(StudentDAO.class);
            when(studentDAO.findByStudentId(("123"))).thenThrow(NullPointerException.class);
            studentService.setStudentDAO(studentDAO);
            //expectedException.expect(NullPointerException.class);
            studentService.deleteStudent((id));
        throw  new NullPointerException();

    }

}