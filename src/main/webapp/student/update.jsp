<%@ page import="com.web.model.Student" %><%--

  Created by IntelliJ IDEA.
  User: devendra
  Date: 4/2/2016
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="updateStudent" method="post">
    <table id ="tab1" align="center">
        <%
            Student student = (Student) request.getAttribute("load");%>

            <tr>
            <td>Id:</td>
            <td><input type='text' name='id' readonly value="+student.getStudentId()+"></td>
            </tr>
            <tr>
            <td>First Name:</td>
           <td> <input  type=\"text\" name=\"firstName\" value="+student.getFirstName() +"></td>
            </tr>
            <tr>
            <td>Last Name:</td>
            <td> <input  type=\"text\" name=\"lastName\" value="+student.getLastName() +"></td>
            </tr>
            <tr>
            <td colspan='2'> <input type=\"submit\" name=\"submit\" value=\"Update\"> </td>
            </tr>

    </table>

    
</form>
</body>
</html>
   