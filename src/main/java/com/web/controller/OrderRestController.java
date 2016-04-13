package com.web.controller;

import com.web.dao.OrderDAO;
import com.web.model.MyOrder;
import com.web.service.AccountService;
import com.web.service.OrderService;
import org.apache.tomcat.util.modeler.modules.ModelerSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static com.web.dao.OrderDAO.*;

/**
 * Created by njonnala on 4/1/2016.
 */
@Api(value = "Order Controller")
@RequestMapping (value = "/api/order")
@RestController
public class OrderRestController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired(required = true)
    private OrderService orderService;

    @Autowired
    private OrderDAO orderDAO;

    @RequestMapping(value = "/orderList", method = { RequestMethod.GET })
    public Iterable<MyOrder> getOrders(final HttpServletRequest request) throws Exception {
        return orderDAO.findAll();
    }



    @RequestMapping(value = "/create", method = { RequestMethod.POST })
    public String createOrder(final HttpServletRequest request) throws Exception {
        String orderName = request.getParameter("ordername");
        String orderType = request.getParameter("ordertype");
        int orderPrice = Integer.parseInt(request.getParameter("orderprice"));
        int orderQuantity = Integer.parseInt(request.getParameter("orderquantity"));


        orderService.createOrder(orderName , orderType , orderPrice , orderQuantity);
       /* MyOrder order = new MyOrder();
        order.setOrderName(orderName);
        order.setOrderType(orderType);
        order.setOrderPrice(orderPrice);
        order.setOrderQuantity(orderQuantity);
        order.setOrderAmount(orderAmount);
        orderDAO.save(order);*/
        return "Order Placed Successfully";
    }

    @RequestMapping( value ="/deleteOrder" , method = { RequestMethod.DELETE })
    public String deleteOrder(final HttpServletRequest request) throws Exception {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
       /* MyOrder order = new MyOrder();
        order.setOrderId(orderId);
        orderDAO.delete(order);*/
       orderService.deleteOrder(orderId);
        return "Order deleted successfully";
    }

    @RequestMapping(value = "/update", method = { RequestMethod.PUT })
    public String updateAccount(final HttpServletRequest request) throws Exception {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        String orderName = request.getParameter("orderName");
        String orderType = request.getParameter("orderType");
        int orderQuantity = Integer.parseInt("orderQuantity");
        orderService.updateAccount(orderId, orderName, orderType , orderQuantity);
        return "Account updated successfully";
    }

    @RequestMapping (value ="/load" , method ={RequestMethod.GET})
    public MyOrder loadOrder(final HttpServletRequest request) throws Exception{
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        return orderService.findOneOrder(orderId);


    }
}
