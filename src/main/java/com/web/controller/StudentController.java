package com.web.controller;

import com.web.dao.StudentDAO;
import com.web.model.Student;
import com.web.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.models.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by devendra on 4/2/2016.
 */
@Api(value = "Student Controller")
@RestController
@RequestMapping(value = "/student")
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

   // @Autowired(required = true)
    //private StudentService accountService;

    @Autowired
    private StudentDAO studentDAO;

    @RequestMapping(value = "/studentsList", method = { RequestMethod.GET })
    public ModelAndView getAccounts(final HttpServletRequest request) throws Exception {
        return gotoStudentListpage();
    }

    private ModelAndView gotoStudentListpage(){
        ModelAndView modelAndView = new ModelAndView("studentsList");
        modelAndView.addObject("students", studentDAO.findAll());
        return modelAndView;
    }


    @RequestMapping(value = "/student", method = { RequestMethod.POST })
    public ModelAndView createAccount(final HttpServletRequest request) throws Exception {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        if(!student.getLastName().equals(null)&&!student.getFirstName().equals(null)){
        studentDAO.save(student);}
        return gotoStudentListpage();
    }


    @RequestMapping (value = "/update", method = { RequestMethod.GET })

      public  ModelAndView update(final HttpServletRequest request) throws Exception{
        int id = Integer.parseInt(request.getParameter("id"));
        ModelAndView modelAndView = new ModelAndView("studentsList");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Student student = studentDAO.findByStudentId(id);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        studentDAO.save(student);
        return gotoStudentListpage();
        //public ModelAndView update( @RequestParam("id") String id) throws Exception {
        //Student student = new Student();
        //student.setStudentId(Long.valueOf(id));
        //student.getFirstName();
        //student.getLastName();

        ////Student student1 = studentDAO.findOne(id);
        //ModelAndView modelAndView = new ModelAndView("update");
          //  modelAndView.addObject("a",student);


        //return gotoStudentListpage();
    }


    @RequestMapping(value = "/delete", method = { RequestMethod.GET })
    public ModelAndView delete(final HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = new Student();
        student.setStudentId(id);
        studentDAO.delete(student);
        return gotoStudentListpage();
    }

    @RequestMapping(value = "/loadStudent", method = {RequestMethod.GET})
    public ModelAndView loadStudent(final  HttpServletRequest request) throws Exception{
        int id = Integer.parseInt(request.getParameter("id"));
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("load",studentDAO.findByStudentId(id));
        return modelAndView;
    }

}

