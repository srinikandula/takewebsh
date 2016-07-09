<%@ page import="com.web.model.Employee" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: CrazyNaveen
  Date: 4/1/16
  Time: 5:42 PM
  To change this template use File | Settings | File Templates.
--%>
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

<table id="tab1" cellpadding="2" cellspacing="2">
    <tbody>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td><c:out value="${employee.employeeId}"/></td>
            <td><c:out value="${employee.name}"/></td>
            <td><c:out value="${employee.address}"/></td>
            <td><c:out value="${employee.salary}"/></td>
            <td><button onclick="deleteEmployee(<c:out value='${employee.employeeId}'/>)">Delete</button> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
