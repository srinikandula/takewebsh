<%@ page import="com.web.model.Employee" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Employee</title>
    <link rel="stylesheet" href="js/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/ui/1.11.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="/resources/demos/style.css">

    <style>
        #tab1 {
            border: 1px solid black;
            border-collapse: collapse;
        }
        tr,td{
            padding: 5px;
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
<form action="update" method="get">
<table id="tab1" align="center">
        <%
                    Employee employee = (Employee) request.getAttribute("load");

                        out.print("<tr>");
                        out.print("<td>Id:</td>");
                        out.print("<td> <input type='text' name='id' readonly value="+employee.getEmployeeId() +"></td>");
                        out.print("</tr>");
                        out.print("<tr>");
                        out.print("<td>Employee Name:</td>");
                        out.print("<td> <input  type=\"text\" name=\"name\" value="+employee.getName() +"></td>");
                        out.print("</tr>");
                        out.print("<tr>");
                        out.print("<td>Address:</td>");
                        out.print("<td> <input  type=\"text\" name=\"address\" value="+employee.getAddress() +"></td>");
                        out.print("</tr>");
                        out.print("<tr>");
                        out.print("<td colspan='2'> <input type=\"submit\" name=\"submit\" value=\"Update\"> </td>");
                        out.print("</tr>");
        %>

    </table>
    </form>
</body>
</html>