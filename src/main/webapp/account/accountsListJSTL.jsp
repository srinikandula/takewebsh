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

<table border="2">
  <tbody>

  <c:forEach items="${accounts}" var="acc">
    <tr>
      <td><c:out value="${acc.id}"/></td> <td><c:out value="${acc.firstName}"/></td><td><c:out value="${acc.lastName}"/></td>


      <td>
        <c:if test="${acc.balance > 1000}">
          <b> <c:out value="${acc.balance}"/> <fmt:formatNumber value="1000" type="CURRENCY"/></b>
        </c:if>
        <c:if test="${acc.balance <= 1000}">
          <i> <c:out value="${acc.balance}"/></i>
        </c:if>
      </td>
      <td></td>

    </tr>
  </c:forEach>
  </tbody>
  </table>

Orders  is here
<table>

  <c:forEach items="${orders}" var="account">
    <tr>
      <td><c:out value="${account.id}"/></td>
      <td><c:out value="${account.firstName}"/></td>
      <td><c:out value="${account.lastName}"/></td>
      <td>
        <c:if test="${account.balance > 1000}">
          <b> <c:out value="${account.balance}"/></b>
        </c:if>
        <c:if test="${account.balance <= 1000}">
          <i> <c:out value="${account.balance}"/></i>
        </c:if>
      </td>

    </tr>
  </c:forEach>

</table>


</body>
</html>
