<%@ page import="com.web.model.Employee" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: CrazyNaveen
  Date: 4/1/16
  Time: 5:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee List</title>
    <style>
        #tab1 {
            border: 1px solid black;
            border-collapse: collapse;
            cellpadding:"1";
            cellspacing:"1";
            width:100%;
        }
        tr,td{
            padding: 10px;
            width: 65px;
        }
        #tab1 tr:nth-child(even){
            background-color: #eee;
        }
        #tab1 tr:nth-child(odd){
            background-color: #fff;
        }
    </style>
</head>
<body>
<h1>Hello Keerthi...</h1>

<table id="tab1">
    <tbody>

<%
    List<Employee> employeeList = (List<Employee>) request.getAttribute("employees");
    for (Employee emp : employeeList){
        out.print("<tr><td>"+emp.getEmployeeId()+"</td><td>"+emp.getAddress()+"</td><td>"+emp.getName()+"</td>");
        out.print("<td><a href='loadEmployee?id="+emp.getEmployeeId()+"'>Update</a></td>");
        out.print("<td><a href='delete?id="+emp.getEmployeeId()+"'>Delete</a></td></tr>");
    }
%>
    </tbody>
</table>
</body>
</html>
