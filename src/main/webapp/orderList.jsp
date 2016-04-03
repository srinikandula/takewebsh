<%@ page import="com.web.model.MyOrder" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: skandula
  Date: 3/10/16
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <script>
      </script>
</head>
<body>
<table border="1" style="width:100%">
  <%
    List<MyOrder> orders = (List<MyOrder>)request.getAttribute("orders");

    for(MyOrder order:orders) {
      out.print("<tr>");
      out.print("<td>" + order.getOrderId() + "</td>");
      out.print("<td>" + order.getOrderName()+ "</td>");
      out.print("<td>" + order.getOrderType()+ "</td>");
      out.print("<td>" + order.getOrderQuantity() + "</td>");
      out.print("<td>" + order.getOrderPrice() + "</td>");
      out.print("<td>" + order.getOrderAmount() + "</td>");
      //out.print("<td>" + order.getUserName()+ "</td>");
     // session.setAttribute("order" , order);
      out.print("<td><a href='loadOrder?orderId=" + order.getOrderId()+"'>Update</a></td>");
      //out.print("<td><a href='createOrder.jsp#tabs-2'>Update</a></td>");

      //out.print("<td><a href='createOrder.jsp'>Create</a></td>");
      out.print("<td><a href='deleteOrder?orderId=" + order.getOrderId() + "'>Delete</a></td>");

      out.print("</tr>");

    }
  %>
</table>

</body>
</html>
