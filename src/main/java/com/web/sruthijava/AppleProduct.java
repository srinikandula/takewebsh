package com.web.sruthijava;

class Apple{
    String model;
    double cost;
    Boolean available;
}
final class Iphone extends Apple{
     public String color(){
         return "Gold";
     }
     public static String name(){
         return "6 plus";
     }
}

class AppleProduct{
   public static void main(String args[]){
     Iphone mobile = new Iphone();
     mobile.model = "7 Plus";
     mobile.cost = 899.99;
     mobile.available = true;

     System.out.println("Model of the mobile is " + mobile.model);
     System.out.println("Color of the mobile is " + mobile.color());
     System.out.println("Cost Of the mobile is " + mobile.cost);
     System.out.println("Previous Model is " + Iphone.name());
     System.out.println("Phone available: " + mobile.available);
   }
}
