package com.web.AbhinavJava;

import java.util.Comparator;

/**
 * Created by surap on 7/8/2017.
 */
public class OrderComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Account1 order1 = (Account1) o1;
        Account1 order2 = (Account1) o2;
        if (order1.getBalance() > order2.getBalance()){
            return -1;
        }
        else if (order1.getBalance() < order2.getBalance()){
            return 1;
        }else {
            return 0;
        }
    }
}
