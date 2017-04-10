package com.web.AbhinavJava;
import java.util.Calendar;

/**
 * Created by surap on 4/6/2017.
 */
public class Hotel{
    public static void main(String args[]){
        Calendar c = Calendar.getInstance();
        System.out.format("%tm/%td/%tY%n", c, c, c);
        System.out.format("%tl:%tM %tp%n", c, c, c);
        Menu m = new Menu();
        System.out.println("Cost Of Chicken Dum Biryani is " + m.getChickentDumBiryaniPrice() + "$");
        System.out.println("Cost Of Chicken Spl Biryani is " + m.getChickenSplBiryaniPrice() + "$");
        System.out.println("Cost Of Chicken Manchuria is " + m.getChickenManchuriaPrice() + "$");
        System.out.println("Cost Of Chilli Chicken is " + m.getChilliChickenPrice() + "$");
        System.out.println("Cost Of Chicken Popcorn is " + m.getChickenPopcornPrice()+ "$");
    }
}

final class Menu implements RiceItems,Starters{
    double price;
    public double getChickentDumBiryaniPrice(){
        this.price = 14.99;
        return this.price;
    }
    public double getChickenSplBiryaniPrice(){
        this.price = 15.99;
        return this.price;
    }
    public double getChickenManchuriaPrice(){
        this.price = 9.99;
        return this.price;
    }
    public double getChilliChickenPrice(){
        this.price = 10.99;
        return this.price;
    }
    public double getChickenPopcornPrice(){
        this.price = 11.99;
        return this.price;
    }
}