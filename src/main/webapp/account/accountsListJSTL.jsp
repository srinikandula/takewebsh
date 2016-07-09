<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: skandula
  Date: 3/31/16
  Time: 9:07 PM
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title></title>
</head>
<body>

<table border="2" cellpadding="4" cellspacing="4">
  <tbody>

  <c:forEach items="${accounts}" var="acc">
    <tr>
      <td><c:out value="${acc.id}"/></td> <td><c:out value="${acc.firstName}"/></td><td><c:out value="${acc.lastName}"/></td>


      <td>
        <c:if test="${acc.balance > 1000}">
          <b> <c:out value="${acc.balance}"/></b>
        </c:if>
        <c:if test="${acc.balance <= 1000}">
          <i> <c:out value="${acc.balance}"/></i>
        </c:if>
      </td>
      <td><button onclick="deleteAccount(<c:out value='${acc.id}'/>)">Delete</button> </td>

    </tr>
  </c:forEach>
  </tbody>
  </table>




</body>
</html>
