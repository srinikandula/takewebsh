package com.web.AbhinavJava;

/**
 * Created by surap on 4/6/2017.
 */
public class Hotel{
    public static void main(String args[]){
        Menu m = new Menu();
        System.out.println("Cost Of Chicken Dum Biryani is " + m.ChickentDumBiryani() + "$");
        System.out.println("Cost Of Chicken Spl Biryani is " + m.ChickenSplBiryani() + "$");
        System.out.println("Cost Of Chicken Manchuria is " + m.ChickenManchuria() + "$");
        System.out.println("Cost Of Chilli Chicken is " + m.ChilliChicken() + "$");
        System.out.println("Cost Of Chicken Popcorn is " + m.ChickenPopcorn() + "$");
    }
}

final class Menu implements RiceItems,Starters{
    double price;
    public double ChickentDumBiryani(){
        this.price = 14.99;
        return this.price;
    }
    public double ChickenSplBiryani(){
        this.price = 15.99;
        return this.price;
    }
    public double ChickenManchuria(){
        this.price = 9.99;
        return this.price;
    }
    public double ChilliChicken(){
        this.price = 10.99;
        return this.price;
    }
    public double ChickenPopcorn(){
        this.price = 11.99;
        return this.price;
    }
}