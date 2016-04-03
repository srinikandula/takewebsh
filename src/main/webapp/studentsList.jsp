<%@ page import="com.web.model.Student" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: skandula
  Date: 3/31/16
  Time: 9:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table border ="2" style="width: 100%">

  <tbody>
    <%



      List<Student> students = (List<Student>) request.getAttribute("students");
      for(Student student:students) {
        out.print("<tr><td>"+student.getStudentId()+"</td><td>"+student.getFirstName()+"</td><td>"+student.getLastName()+"</td>");
        out.print("<td><a href='loadStudent?id="+student.getStudentId()+"'>Update</a></td>");
        out.print("<td><a href='delete?id="+student.getStudentId()+"'>Delete</a></td></tr>");
      }
      //out.print("<td><a href='/createStudent"+"'>Home</a></td>");
    %>
  </tbody>
</table>


</body>
</html>
