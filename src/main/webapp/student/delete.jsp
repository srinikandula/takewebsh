<%--
  Created by IntelliJ IDEA.
  User: devendra
  Date: 4/2/2016
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="../js/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="../js/jquery-1.10.2.js"></script>
    <script src="../js/ui/1.11.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script>
        $(function() {
            $( "#tabs" ).tabs();
        });
    </script>
    <title>Title</title>
</head>
<body>

<form action="deleteStudent" method="post">
    <table>
        <tr>
            <td>ID : </td>
            <td><input type="text" name="ID"></td>
        </tr>
        </table>
    </form>
</body>
</html>
