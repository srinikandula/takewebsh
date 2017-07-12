package com.web.AbhinavJava;

import javax.persistence.criteria.Order;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by surap on 7/8/2017.
 */
public class BankAppTree {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static Set<Account1> treeSet = new TreeSet<>(new OrderComparator());

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int option = 0;
        do {
            System.out.println("1. Create Account");
            System.out.println("2. Find Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Delete Account");
            System.out.println("6. Order Accounts");
            System.out.println("0. Exit");
            System.out.println("please enter your option");
            option = Integer.parseInt(bufferedReader.readLine());
            switch (option) {
                case 1:
                    newAccount();
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
                case 6:
                    orderAccounts();
                    break;
            }
        } while (option != 0);
    }
    public static void newAccount() throws IOException {
        Account1 newAcc = new Account1();
        System.out.println("Please enter name");
        newAcc.setName(bufferedReader.readLine());
        System.out.println("Please enter your ssn");
        newAcc.setSsn(Long.valueOf(bufferedReader.readLine()));
        System.out.println("Please enter deposit balance");
        newAcc.setBalance(Double.valueOf(bufferedReader.readLine()));
        newAcc.setAccountId((int) (Math.random() * 10000));
        System.out.println("Account Number:" + newAcc.getAccountId());
        //System.out.println(treeSet);
        treeSet.add(newAcc);
    }

    public static void findBalance() throws IOException {
        System.out.println("Please enter your account number");
        int accountNumber = Integer.parseInt(bufferedReader.readLine());
        Iterator<Account1> itrtr = treeSet.iterator();
        while (itrtr.hasNext()){
            Account1 check = itrtr.next();
            if(check.getAccountId() == accountNumber)
            {
                System.out.println("Your current Balance:" + check.getBalance());
            }
        }
    }
    public static void deleteAccount() throws IOException{
        System.out.println("Please enter your account number");
        int accountNumber = Integer.parseInt(bufferedReader.readLine());
        Iterator<Account1> itrtr = treeSet.iterator();
        while (itrtr.hasNext()){
            Account1 check = itrtr.next();
            if(check.getAccountId() == accountNumber)
            {
                itrtr.remove();
                System.out.println("account deleted successfully");
                break;
            }
        }
    }
    public static void deposit() throws IOException{
        System.out.println("Please enter your account num");
        int accountNum = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Please enter deposit amount");
        int depAmount = Integer.parseInt(bufferedReader.readLine());
        Iterator<Account1> itrtr = treeSet.iterator();
        while (itrtr.hasNext()){
            Account1 check = itrtr.next();
            if(check.getAccountId() == accountNum)
            {
                check.setBalance( check.getBalance() + depAmount);
                System.out.println("New balance "+ check.getBalance());
            }
        }
    }
    public static void withdraw() throws IOException{
        System.out.println("Please enter your account number ");
        int accountNum = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Please enter withdraw amount ");
        int withdrawAmo = Integer.parseInt(bufferedReader.readLine());
        Iterator<Account1> itrtr = treeSet.iterator();
        while (itrtr.hasNext()){
            Account1 checks = itrtr.next();
            if(checks.getAccountId() == accountNum)
            {
                checks.setBalance( checks.getBalance() - withdrawAmo);
                System.out.println("New balance "+ checks.getBalance());
            }
        }
    }

    public static void orderAccounts() {
        Iterator<Account1> itrtr = treeSet.iterator();
        while (itrtr.hasNext()){
            Account1 checks = itrtr.next();
            System.out.println("Account Num:"+ checks.getAccountId() + "  Account Balance:" + checks.getBalance());
        }
    }
}
