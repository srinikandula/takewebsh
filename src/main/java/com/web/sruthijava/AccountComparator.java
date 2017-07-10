package com.web.sruthijava;

import java.util.Comparator;

/**
 * Created by chsru on 7/8/2017.
 */
public class AccountComparator implements Comparator {
    @Override
    public int compare(Object o1,Object o2){
        Account acc1 = (Account) o1;
        Account acc2 = (Account) o2;
        System.out.println(acc1.getBalance());
        if (acc1.getBalance() > acc2.getBalance()){
            return -1;
        }else if (acc1.getBalance()< acc2.getBalance()){
            return 1;
        }else{
            return 0;
        }
    }
}
