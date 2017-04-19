package com.web.training;

import java.io.*;
import java.util.DoubleSummaryStatistics;
import java.util.Scanner;

public class Teller {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int option = 0;
        do{
            System.out.println("1. Create Account");
            System.out.println("2. Find Balance");
            System.out.println("3. Deposit");
            System.out.println("0. Exit");
            System.out.println("please enter your option");
            option = Integer.parseInt(bufferedReader.readLine());
            switch (option) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    findBalance();
                    break;
                case 3:
                    deposit();
                    break;
            }
        }while(option != 0);
    }

    private static void deposit() {
    }

    private static void findBalance() throws IOException {
        System.out.println("Please enter your account number");

        int accountNumber = Integer.parseInt(bufferedReader.readLine());
        File f = new File("accounts/"+accountNumber+".txt");
        if(!f.exists()) {
            System.err.print("Account not found");
        } else {
            String accountRecord =  new BufferedReader(new FileReader(f)).readLine();
            String args[] = accountRecord.split("_");
            System.out.println("Balance is "+ args[1]);
        }
    }

    private static void createAccount() throws IOException {
        FileOutputStream fos = null;
        try {

            System.out.println("Please enter name");
            String name = bufferedReader.readLine();
            System.out.println("Please enter deposit balance");
            double balance = Double.valueOf(bufferedReader.readLine());
            String accountRecord = name +"_"+balance;
            int accountNumber = (int)(Math.random()*10000); //324234.53443
            File f = new File("accounts/"+accountNumber+".txt");
            while(f.exists()) {
                accountNumber = (int)(Math.random()*10000); //324234.53443
                f = new File("accounts/"+accountNumber+".txt");
            }
            fos = new FileOutputStream (f) ;
            fos.write(accountRecord.getBytes());
            System.out.println("Account is created with number "+ accountNumber);

        } catch (NumberFormatException ex) {
            System.out.println("Not a number !");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos != null) {
                fos.close();
            }

        }
    }
}