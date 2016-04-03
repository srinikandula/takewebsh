<%--
  Created by IntelliJ IDEA.
  User: CrazyNaveen
  Date: 4/2/16
  Time: 7:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Employee</title>
    <style>
        #table1 {
            border: 1px solid black;
            border-collapse: collapse;
        }
        tr,td{
            padding: 5px;
        }
        #table1 tr:nth-child(even){
            background-color: #eee;
        }
        #table1 tr:nth-child(odd){
            background-color: #fff;
        }

    </style>
</head>
<body>
<form action="delete" method="get">
    <table id="table1" align="center">
        <tr>
            <td>Id:</td>
            <td>
                <input type="text" name="id" >
            </td>
        </tr>
        <tr>
            <td>
                <input type="reset" name="reset" value="Clear">
            </td>
            <td>
                <input type="submit" name="submit" value="submit">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
