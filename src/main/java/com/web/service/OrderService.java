package com.web.service;

import com.web.dao.AccountDAO;
import com.web.dao.OrderDAO;
import com.web.model.MyOrder;
import lombok.Setter;
import org.mockito.internal.matchers.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.stereotype.Service;

/**
 * Created by njonnala on 4/5/2016.
 */
@Service
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    @Setter
    private OrderDAO orderDAO;

    public void createOrder( final String orderName, final String orderType , final int orderPrice , final int orderQuantity){

        if(orderName == null || orderName.trim().length() == 0){
            throw new NullPointerException("Order name is not valid");
        }
        if(orderType == null || orderType.trim().length() == 0){
            throw new NullPointerException("Order type is not valid");
        }
        if(orderPrice < 0 ){
            throw new ArithmeticException("Order Price cannot be negative");
        }
        if(orderQuantity < 0){
            throw new ArithmeticException("Order quanitity cannot be negative");
        }
        MyOrder order = new MyOrder();
        order.setOrderName(orderName);
        order.setOrderType(orderType);
        order.setOrderPrice(orderPrice);
        order.setOrderQuantity(orderQuantity);
        int orderAmount = orderPrice * orderQuantity;
        order.setOrderAmount(orderAmount);

        MyOrder myorder = orderDAO.save(order);
        if(myorder == null){
            throw new NullPointerException();
        }
        else{
            System.out.println("order saved successfully");
        }
    }
    public void updateAccount(int orderId , String orderName , String orderType ,  int orderQuantity){
        MyOrder myorder = orderDAO.findOne(orderId);
        if(myorder == null){
            throw new NullPointerException("Invalid Id entered");
        }
        if(orderName == null || orderName.trim().length() == 0){
            throw new NullPointerException("Order name is not valid");
        }
        if(orderType == null || orderType.trim().length() == 0){
            throw new NullPointerException("Order type is not valid");
        }

        if(orderQuantity < 0){
            throw new ArithmeticException("Order quanitity cannot be negative");
        }
        int orderAmount = myorder.getOrderPrice() * orderQuantity;

        myorder.setOrderName(orderName);
        myorder.setOrderType(orderType);

        myorder.setOrderQuantity(orderQuantity);

        myorder.setOrderAmount(orderAmount);
        orderDAO.save(myorder);

    }
    public void deleteOrder(int orderId){
        MyOrder myorder = orderDAO.findOne(orderId);
        if(myorder == null){
            throw new NullPointerException("Invalid Id entered");
        }
        MyOrder order = new MyOrder();
        order.setOrderId(orderId);
        orderDAO.delete(order);

    }

    public Iterable<MyOrder> findOrders(){
        return orderDAO.findAll();
    }
    public MyOrder findOneOrder(int orderId){
        return orderDAO.findOne(orderId);
    }

}
