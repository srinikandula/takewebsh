package com.web.HarshaJava;

import org.hibernate.annotations.*;

/**
 * Created by sriharshakota on 4/6/17.
 */
public class vendor {
    private static int count;
    private static float sellingPrice;
    private static float costPrice;

    public void setCount(int val){
        count = val;
    }
    public void setSellingPrice(float val){
        sellingPrice = val;
    }
    public void setCostPrice(float val){
        costPrice = val;
    }
    public  int getCount(){
        return count;
    }
    public double getSellingPrice(){
        return sellingPrice;
    }
    public double getCostPrice(){
        return  costPrice;
    }
    public static final void init(int ct, float sell, float cost){
        count = ct;
        sellingPrice = sell;
        costPrice = cost;
        System.out.println("Values initiated");
        System.out.println("Count : "+ ct );
        System.out.println( "Selling Price : "+ sell );
        System.out.println("Cost Price : "+ cost);
    }

}
