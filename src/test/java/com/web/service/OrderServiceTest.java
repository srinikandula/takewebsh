package com.web.service;

import com.web.dao.AccountDAO;
import com.web.dao.OrderDAO;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by njonnala on 4/5/2016.
 */
public class OrderServiceTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testSaveOrderWithNoOrderName(){
        OrderService orderService = new OrderService();
        String orderName = null;
        String orderType = "shoes";
        int OrderPrice = 100;
        int OrderQuantity = 10;
        expectedEx.expect(NullPointerException.class);
        orderService.createOrder(orderName ,orderType,OrderPrice,OrderQuantity);
    }
    @Test
    public void testSaveOrderWithNegativeOrderPrice(){
        OrderService orderService = new OrderService();
        String orderName = "skecthers shoes";
        String orderType = "shoes";
        int OrderPrice = -1;
        int OrderQuantity = 10;
        expectedEx.expect(ArithmeticException.class);
        orderService.createOrder(orderName ,orderType,OrderPrice,OrderQuantity);
    }

    @Test
    public void testSaveOrder(){
        OrderService orderService = new OrderService();
        String orderName = "skecthers shoes";
        String orderType = "shoes";
        int OrderPrice = 100;
        int OrderQuantity = 10;
        expectedEx.expect(NullPointerException.class);
        orderService.createOrder(orderName , orderType , OrderPrice , OrderQuantity);
    }

    @Test
    public void testInvalidOrderId(){
        OrderService orderService = new OrderService();
        int orderId = 999;
        String orderName = "skecthers shoes";
        String orderType = "shoes";

        int OrderQuantity = 10;
        OrderDAO orderDAO = mock(OrderDAO.class);
        when(orderDAO.findOne(999)).thenThrow(NullPointerException.class);
        expectedEx.expect(NullPointerException.class);
        orderService.updateAccount(orderId , orderName ,orderType , OrderQuantity);
    }

}
