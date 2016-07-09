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
    <script src="bower_components/jquery/dist/jquery.js"></script>
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.css">
    <script src="js/keerthiCreate.js"></script>
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
    <script>
        function deleteEmployee(id) {
            $("#responseMessage").html("");
            $("#errorMessage").html("");
            $.ajax({
                type: "DELETE",
                url: '/api/employee/delete?id='+id,
                success: function(data, status, req) {
                    $("#responseMessage").html(data);
                    loadEmployees();
                },
                error:function(req, status, message) {
                    $("#errorMessage").html("Error: " + message);
                }
            });
        }
    </script>
</head>
<body>
<h1>Hello Keerthi...</h1>

<table id="tab1" cellspacing="2" cellpadding="2">
    <tbody>

<%
    List<Employee> employeeList = (List<Employee>) request.getAttribute("employees");
    for (Employee emp : employeeList){
        out.print("<tr><td>"+emp.getEmployeeId()+"</td><td>"+emp.getAddress()+"</td><td>"+emp.getName()+"</td><td>"+emp.getSalary()+"</td>");
        out.print("<td><a href='loadEmployee?id="+emp.getEmployeeId()+"'>Update</a></td>");
       // out.print("<td><input type='submit' name='delete' value = 'Delete' onclick=deleteEmployee()/></td></tr>");
        out.print("<td><a href='delete?id="+emp.getEmployeeId()+"'>Delete</a></td></tr>");
    }
%>
    </tbody>
</table>
</body>
</html>
