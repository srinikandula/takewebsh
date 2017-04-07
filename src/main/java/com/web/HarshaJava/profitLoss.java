package com.web.HarshaJava;

/**
 * Created by sriharshakota on 4/6/17.
 */
public class profitLoss extends vendor implements templete {


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
       display.Status();

    }

}
