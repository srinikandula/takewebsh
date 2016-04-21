package com.web.controller;

import com.web.controller.utils.ControllerUtils;
import com.web.dao.StudentDAO;
import com.web.model.Student;
import com.web.service.StudentService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by devendra on 4/12/2016.
 */
@Api(value =" Student Controller")
@RequestMapping(value ="/api/student")
@RestController
public class StudentRestController {
    private  static final Logger logger = LoggerFactory.getLogger((StudentRestController.class));

    @Autowired(required = true)
    private StudentService studentService;

    @Autowired
    private StudentDAO studentDAO;

    @RequestMapping(value ="/list",method = { RequestMethod.GET}, produces = ControllerUtils.JSON_UTF8)
    public Iterable<Student> getAccounts(final HttpServletRequest request) throws Exception {
        return studentDAO.findAll();
    }


    @RequestMapping(value = "/create", method = {RequestMethod.POST}, produces= MediaType.TEXT_PLAIN_VALUE)
    public  String createAccount(final HttpServletRequest request) throws  Exception {
        String firstName = request.getParameter("fName");
        String lastName = request.getParameter("lName");
        Iterable<Student> students = studentDAO.findByFirstNameAndLastName(firstName, lastName);
        if(students.iterator().hasNext()){
            throw  new RuntimeException("Account with same names Found");
        }
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        studentDAO.save(student);
        return "Account Created Successfully";
    }

    @RequestMapping(value = "/{studentId}", method = {RequestMethod.GET}, produces = ControllerUtils.JSON_UTF8)

    //public String getAccount(final HttpServletRequest request) throws Exception {
       // String firstName = request.getParameter("firstName");
       // String lastName = request.getParameter("lastName");
        //Student student = new Student();
        //student.setFirstName(firstName);
        //student.setLastName(lastName);
        //studentDAO.save(student);
      //  return "Account Created Successfully";
    public Student getStudent(final HttpServletRequest request, @PathVariable String studentId) throws  Exception {
        Student student = studentDAO.findByStudentId (new Integer(studentId));
        return student;
    }

    @RequestMapping(value = "/update/{studentId}", method = { RequestMethod.PUT},produces =MediaType.TEXT_PLAIN_VALUE)
    public String updateStudent(final HttpServletRequest request, @PathVariable String studentId) throws Exception {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        studentService.updateStudent(studentId, firstName, lastName);
        return "Account Updated Successfully";
    }

    @RequestMapping(value = "/delete", method ={ RequestMethod.DELETE},produces =MediaType.TEXT_PLAIN_VALUE)
    public String deleteStudent(final HttpServletRequest request) throws Exception {
        int studentId = Integer.parseInt((request.getParameter("id")));
       Student student = studentDAO.findByStudentId((studentId));
        // Student student = studentDAO.findByStudentId(Integer.parseInt(studentId));
//        Student student = studentDAO.findByStudentId(String.valueOf(new String[Integer.parseInt(studentId)]));
        studentDAO.delete(student);
        return ("Account Deleted Successfully");
    }

    @RequestMapping(value = "/hasFirstNameUsed", method = { RequestMethod.GET},produces =MediaType.TEXT_PLAIN_VALUE)
    public boolean findStudentByFirstName(final HttpServletRequest request) throws Exception {
        String fName = request.getParameter("fName");
        Iterable<Student> students = studentDAO.findByFirstName(fName);
        if(students != null && students.iterator().hasNext()){
            return true;
        }else {
            return false;
        }
    }

}
