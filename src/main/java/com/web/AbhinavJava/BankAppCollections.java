package com.web.AbhinavJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by surap on 7/5/2017.
 */
public class BankAppCollections {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<Account> arrl = new ArrayList<Account>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int option = 0;
        do {
            System.out.println("1. Create Account");
            System.out.println("2. Find Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Delete Account");
            System.out.println("0. Exit");
            System.out.println("please enter your option");
            option = Integer.parseInt(bufferedReader.readLine());
            switch (option) {
                case 1:
                    createNewAccount();
                    break;
                case 2:
                    findBalance();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    withdraw();
                    break;
                case 5:
                    deleteAccount();
                    break;
            }
        } while (option != 0);
    }
        public static void createNewAccount() throws IOException {
            Account newAccount = new Account();
            arrl.add(newAccount);
            System.out.println("Please enter name");
            newAccount.setName(bufferedReader.readLine());
            System.out.println("Please enter your ssn");
            newAccount.setSsn(Long.valueOf(bufferedReader.readLine()));
            System.out.println("Please enter deposit balance");
            newAccount.setBalance(Double.valueOf(bufferedReader.readLine()));
            newAccount.setAccountId((int) (Math.random() * 10000));
            System.out.println("Account Number:" + newAccount.getAccountId());
            System.out.println(arrl);
        }

    public static void findBalance() throws IOException {
        System.out.println("Please enter your account number");
        int accountNumber = Integer.parseInt(bufferedReader.readLine());
        Iterator<Account> itr = arrl.iterator();
        while (itr.hasNext()){
            Account check = itr.next();
            if(check.getAccountId() == accountNumber)
            {
                System.out.println("Your current Balance:" + check.getBalance());
            }
        }
    }
    public static void deleteAccount() throws IOException{
        System.out.println("Please enter your account number");
        int accountNumber = Integer.parseInt(bufferedReader.readLine());
        Iterator<Account> itr = arrl.iterator();
        while (itr.hasNext()){
            Account check = itr.next();
            if(check.getAccountId() == accountNumber)
            {
                itr.remove();
                System.out.println("account deleted successfully");
                break;
            }
        }
    }
    public static void deposit() throws IOException{
        System.out.println("Please enter your account number");
        int accountNumber = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Please enter deposit amount");
        int depositAmount = Integer.parseInt(bufferedReader.readLine());
        Iterator<Account> itr = arrl.iterator();
        while (itr.hasNext()){
            Account check = itr.next();
            if(check.getAccountId() == accountNumber)
            {
               check.setBalance( check.getBalance() + depositAmount);
                System.out.println("New balance "+ check.getBalance());
            }
        }
    }
    public static void withdraw() throws IOException{
        System.out.println("Please enter your account number");
        int accountNumber = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Please enter withdraw amount");
        int withdrawAmount = Integer.parseInt(bufferedReader.readLine());
        Iterator<Account> itr = arrl.iterator();
        while (itr.hasNext()){
            Account check = itr.next();
            if(check.getAccountId() == accountNumber)
            {
                check.setBalance( check.getBalance() - withdrawAmount);
                System.out.println("New balance "+ check.getBalance());
            }
        }
    }
}
