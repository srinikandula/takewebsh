<%@ page import="com.web.model.MyOrder" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="js/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/ui/1.11.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script>
        $(function() {
            $( "#tabs" ).tabs();
        });
        $(function() {
            var param = document.getElementById("selectedTabInput").value;
            if (param != 0) {
                $('#tabs').tabs({
                    active : param
                });
            } else {
                $('#tabs').tabs();
            }
        });
    </script>
</head>
<body>

<%
    /*Object obj = session.getAttribute("user");
    if(obj != null){
        User user = (User)obj;
        out.print("<p> User logged in <b>"+user.getUserName()+"  <a href=\"logout\">Logout</a></p>");
    }*/
%>
<%
   /* String msg = (String)request.getAttribute("message");
    if(msg != null) {
        if (msg.equals("Invalid")) {
            out.print("<p> Invalid OrderID entered</p>");
        }
    }*/
%>


<div id="tabs">
    <ul>
        <li><a href="#tabs-1">Create Order</a></li>
        <li><a href="#tabs-2">Update Order</a></li>
        <li><a href="#tabs-3">DeleteOrder</a></li>
        <li><a href="#tabs-4">Find OrderAmount</a></li>
    </ul>

    <div id="tabs-1">
        <p>

        <form action="create" method="post">
            <table>

                <tr>
                    <td>Enter OrderName: </td>
                    <td><input type="text" name="ordername" ></td>
                </tr>
                <tr>
                    <td>Enter OrderType: </td>
                    <td><input type="text" name="ordertype"></td>
                </tr>
                <tr>
                    <td>Enter OrderPrice: </td>
                    <td> <input type="text" name="orderprice"></td>
                </tr>
                <tr>
                    <td>Enter OrderQuanitty:</td>
                    <td><input type="text" name="orderquantity"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit"/></td>
                </tr>
            </table>
        </form>
        </p>
    </div>
    <div id="tabs-2">
<% /*String obj = (request.getParameter("orderId"));
    //MyOrder order = (MyOrder) obj;
out.print("orderid" +obj);*/%>
        <%
            int orderId=0;String orderName="";String orderType="";int orderQuantity=0;
            MyOrder order = (MyOrder) request.getAttribute("order");
            String tabs = (String) request.getAttribute("pagename");
            if(order!=null){
                orderId = order.getOrderId();
                orderName = order.getOrderName();
                orderType = order.getOrderType();
                orderQuantity = order.getOrderQuantity();
            }
            %>

        <p>
        <table>
        <form action="updateOrder" method="post">


            <tr><td>OrderID : <input type="text" name="orderid" value="<%=orderId%>"></td></tr>
            <tr><td>Order Name: <input type="text" name="ordername" value="<%=orderName%>"></td></tr>
            <tr><td> Order Type: <input type="text" name="ordertype" value="<%=orderType%>"></td></tr>

            <tr><td>Order Quantity: <input type="text" name="orderquantity" value="<%=orderQuantity%>"></td></tr>

           <tr> <td><input type="submit" name="submit" value="submit"></td></tr>
        </form>
          </table>


        </p>
    </div>
    <div id="tabs-3">
        <p>
        <form action="deleteOrder">
            OrderId : <input type="text" name="orderId">

            <input type="submit">

        </form>
        </p>

    </div>
    <div id="tabs-4">
        <p>
        <form action="findAmount">
            Enter your OrderId : <input type="text" name="orderId">

            <input type="submit">

        </form>
        </p>

    </div>
</div>




</body>
</html>