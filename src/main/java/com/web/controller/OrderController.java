package com.web.controller;

import com.web.dao.OrderDAO;
import com.web.model.MyOrder;
import org.apache.tomcat.util.modeler.modules.ModelerSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderDAO orderDAO;

    @RequestMapping(value = "/orderList", method = { RequestMethod.GET })
    public ModelAndView getOrders(final HttpServletRequest request) throws Exception {
        return orderListpage();
    }

    private ModelAndView orderListpage() {
        ModelAndView modelAndView = new ModelAndView("orderList");
        modelAndView.addObject("orders", orderDAO.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = { RequestMethod.POST })
    public ModelAndView createOrder(final HttpServletRequest request) throws Exception {
        String orderName = request.getParameter("ordername");
        String orderType = request.getParameter("ordertype");
        int orderPrice = Integer.parseInt(request.getParameter("orderprice"));
        int orderQuantity = Integer.parseInt(request.getParameter("orderquantity"));
        int orderAmount = orderPrice * orderQuantity;
        System.out.println("order details" +orderName +orderAmount +orderType);
        MyOrder order = new MyOrder();
        order.setOrderName(orderName);
        order.setOrderType(orderType);
        order.setOrderPrice(orderPrice);
        order.setOrderQuantity(orderQuantity);
        order.setOrderAmount(orderAmount);
        orderDAO.save(order);
        return orderListpage();
    }


    @RequestMapping(value ="/updateOrder" , method = {RequestMethod.POST})
    public ModelAndView updateOrder(final HttpServletRequest request) throws Exception{

        int orderId = Integer.parseInt(request.getParameter("orderid"));
       // int orderPrice = Integer.parseInt(request.getParameter("orderprice"));
        String orderName = request.getParameter("ordername");
        String orderType = request.getParameter("ordertype");
        int orderQuantity = Integer.parseInt(request.getParameter("orderquantity"));
        MyOrder myorder = orderDAO.findOne(orderId);
        //System.out.println("orderprice is" +myorder.getOrderPrice());


        int orderAmount = myorder.getOrderPrice() * orderQuantity;

        myorder.setOrderName(orderName);
        myorder.setOrderType(orderType);

        myorder.setOrderQuantity(orderQuantity);

        myorder.setOrderAmount(orderAmount);
        orderDAO.save(myorder);
        return orderListpage();

    }

    @RequestMapping (value ="/loadOrder" , method ={RequestMethod.GET})
    public ModelAndView loadOrder(final HttpServletRequest request) throws Exception{
        int orderId = Integer.parseInt(request.getParameter("orderId"));
       // MyOrder myorder = orderDAO.findOne(orderId);
        ModelAndView modelAndView = new ModelAndView("createOrder");
        modelAndView.addObject("pagename" ,"update");
        modelAndView.addObject("order", orderDAO.findOne(orderId));
        return modelAndView;
    }


    @RequestMapping( value ="/deleteOrder" , method = { RequestMethod.GET })
    public ModelAndView deleteOrder(final HttpServletRequest request) throws Exception {

        int orderId = Integer.parseInt(request.getParameter("orderId"));
        MyOrder order = new MyOrder();
        order.setOrderId(orderId);
        orderDAO.delete(order);

        return orderListpage();
    }
}
