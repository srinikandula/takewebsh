<%@ page import="com.web.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: devendra
  Date: 4/2/2016
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="update" method="get">
    <table id ="tab1" align="center">
        <%
            Student student = (Student) request.getAttribute("load");

            out.print("<tr>");
            out.print("<td>Id:</td>");
            out.print("<td><input type='text' name='id' readonly value="+student.getStudentId()+"></td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>First Name:</td>");
            out.print("<td> <input  type=\"text\" name=\"firstName\" value="+student.getFirstName() +"></td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>Last Name:</td>");
            out.print("<td> <input  type=\"text\" name=\"lastName\" value="+student.getLastName() +"></td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td colspan='2'> <input type=\"submit\" name=\"submit\" value=\"Update\"> </td>");
            out.print("</tr>");
    %>
    </table>
</form>
</body>
</html>
