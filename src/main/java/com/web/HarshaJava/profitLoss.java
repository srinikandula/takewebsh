package com.web.HarshaJava;

/**
 * Created by sriharshakota on 4/6/17.
 */
public class profitLoss extends vendor implements templete {

     private static float debt = 1000;
     private static float interest =0;
     private static int months = 12;
     private static int rate = 3;



     private float profit,loss,profitPercentage,lossPercentage;
     vendor check = new vendor();


    public void checkProfit (int count, float sellingPrice, float costPrice){
            if (sellingPrice > costPrice){
                profit = (sellingPrice - costPrice)*count;
                profitPercentage = (profit/(count*costPrice))*100;
                System.out.println("Profit Percentage = " + profitPercentage + "%");
            }
            else if(costPrice > sellingPrice ){
                loss = (costPrice - sellingPrice) * count;
                lossPercentage = (loss/(count*costPrice))*100;
                System.out.println("Loss Percentage = " + lossPercentage + "%");
            }
            else{
                System.out.println("No loss No Profit");
            }

    }

    public void Status(){
        profitLoss obj = new profitLoss();
        vendor.init(9,199,149);
        obj.checkProfit(9,199,149);
    }

    public static void main(String[] args) {
       profitLoss display = new profitLoss();
       profitLoss.simpleInterest();
       profitLoss.exmpleWapper();
       display.Status();

    }
    public static void simpleInterest(){
    interest = (debt * months * rate)/100;
        System.out.format("The debt of  %f at the rate of %d percentage for a period of %d months the simple interest is %f %n"
                , debt, rate, months,interest);

    }
    public static void exmpleWapper(){
        double x = 123.456;
        Double flt1 = new Double(x);
        int y = flt1.intValue();
        String num = "98765";
        Integer.parseInt(num);
        System.out.println(y + " converting double object to the integer data type");

    }

}
