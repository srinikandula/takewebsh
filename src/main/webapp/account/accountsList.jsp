<%@ page import="com.web.model.Account" %>
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
<table>
  <tbody>
    <%
      List<Account> accounts = (List<Account>) request.getAttribute("accounts");
      for(Account account:accounts) {
        out.print("<tr><td>"+account.getId()+"</td><td>"+account.getFirstName()+"</td></tr>");
      }
    %>
  <%= request.getAttribute("accounts")%>
  </tbody>
</table>


</body>
</html>
