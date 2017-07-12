package com.web.AbhinavJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by surap on 7/8/2017.
 */
public class BankAppMap {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static Map<Integer, Account> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        int option = 0;
        do {
            System.out.println("1. Create New Account");
            System.out.println("2. Find Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Delete Account");
            System.out.println("6. Balance Transfer");
            System.out.println("0. Exit");
            System.out.println("please enter your option");
            option = Integer.parseInt(bufferedReader.readLine());
            switch (option) {
                case 1:
                    newAccountCreate();
                    break;
                case 2:
                    findAccountBalance();
                    break;
                case 3:
                    depositCash();
                    break;
                case 4:
                    withdrawCash();
                    break;
                case 5:
                    deleteAccount();
                    break;
                case 6:
                    balanceTransfer();
                    break;
            }
        } while (option != 0);
    }

    private static void balanceTransfer() throws IOException {
        System.out.println("Please enter Source Account Number");
        int srcAccountNumber = Integer.parseInt(bufferedReader.readLine());
        if (map.containsKey(srcAccountNumber)){
            Account srcAccount = map.get(srcAccountNumber);
            System.out.println("Please enter Destination Account number");
            int dstAccountNumber = Integer.parseInt(bufferedReader.readLine());
            if (map.containsKey(dstAccountNumber)){
                Account dstAccount = map.get(dstAccountNumber);
                System.out.println("Enter Transfer amount");
                int tranAmount = Integer.parseInt(bufferedReader.readLine());
                if (srcAccount.getBalance() >= tranAmount){
                    srcAccount.setBalance(srcAccount.getBalance() - tranAmount);
                    dstAccount.setBalance(dstAccount.getBalance() + tranAmount);
                    System.out.println("Amount transfer Successful");
                }
                else { System.out.println("Amount exceeds your Balance"); }
            }
            else { System.out.println("Destination Account not found! Please check your account number"); }
        }
        else { System.out.println("Source Account not found! Please check your account number"); }
    }

    private static void depositCash() throws IOException {
        System.out.println("Please enter Account Number");
        int accountNumber = Integer.parseInt(bufferedReader.readLine());
        if (map.containsKey(accountNumber)){
            System.out.println("Enter Your deposit Amount");
            int depAmount = Integer.parseInt(bufferedReader.readLine());
            Account findAccount = map.get(accountNumber);
            double a = findAccount.getBalance() + depAmount;
            findAccount.setBalance(a);
            System.out.println("Amount Deposited, your final balance is: " + findAccount.getBalance());
        }
        else { System.out.println("Account not found! Please check your account number"); }
    }

    private static void withdrawCash() throws IOException {
        System.out.println("Please enter Account Number");
        int accountNumber = Integer.parseInt(bufferedReader.readLine());
        if (map.containsKey(accountNumber)){
            Account findAccount = map.get(accountNumber);
            System.out.println("Enter Your Amount");
            int depAmount = Integer.parseInt(bufferedReader.readLine());
            if (findAccount.getBalance() >= depAmount){
                double a = findAccount.getBalance() - depAmount;
                findAccount.setBalance(a);
                System.out.println("Amount Dispensed, your final balance is: " + findAccount.getBalance());
            }
            else { System.out.println("Withdraw amount is higher than your Balance"); }
        }
        else { System.out.println("Account not found! Please check your account number"); }
    }

    private static void deleteAccount() throws IOException {
        System.out.println("Please enter Account Number");
        int accountNumber = Integer.parseInt(bufferedReader.readLine());
        if (map.containsKey(accountNumber)){
            map.remove(accountNumber);
            System.out.println("Account deleted");
        }
        else { System.out.println("Account not found! Please check your account number"); }
    }

    private static void findAccountBalance() throws IOException {
        System.out.println("Please enter Account Number");
        int accountNumber = Integer.parseInt(bufferedReader.readLine());
        if (map.containsKey(accountNumber)){
            Account findAccount = map.get(accountNumber);
            System.out.println("Your Account Balance is: " + findAccount.getBalance());
        }
        else { System.out.println("Account not found! Please check your account number"); }
    }

    private static void newAccountCreate() throws IOException {
        Account account = new Account();
        System.out.println("Please enter name");
        account.setName(bufferedReader.readLine());
        System.out.println("Please enter your ssn");
        account.setSsn(Long.valueOf(bufferedReader.readLine()));
        System.out.println("Please enter deposit balance");
        account.setBalance(Double.valueOf(bufferedReader.readLine()));
        account.setAccountId((int) (Math.random() * 10000));
        System.out.println("Account Number:" + account.getAccountId());
        map.put(account.getAccountId(), account);
    }
}

