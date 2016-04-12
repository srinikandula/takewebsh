<%--
  Created by IntelliJ IDEA.
  User: njonnala
  Date: 4/8/2016
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Order Details</title>
</head>
<body>

<table border="1" style="width:100%">

    <c:forEach items="${orders}" var="order">

        <tr>

            <td><c:out value="${order.orderId}"/></td>
            <td><c:out value="${order.orderName}"/></td>
            <td><c:out value="${order.orderType}"/></td>
            <td><c:out value="${order.orderPrice}"/></td>
            <td><c:out value="${order.orderQuantity}"/></td>

            <td>
                <c:if test="${order.orderAmount > 100}">
                    <b> <c:out value="${order.orderAmount}"/></b>
                </c:if>
                <c:if test="${order.orderAmount <= 100}">
                    <i> <c:out value="${order.orderAmount}"/></i>
                </c:if>
            </td>
            <c:set var="orderId" value="${order.orderId}"/>
            <td><a href="<c:url value="/loadOrder">
                            <c:param name="orderId" value="${orderId}"/>
                                </c:url>"><c:out value="${'Update'}"></c:out></a></td>
            <td><a href='deleteOrder?orderId=" + order.getOrderId() + "'>Delete</a></td>

        </tr>
    </c:forEach>

</table>

</body>
</html>
