package com.web.sruthijava;

import java.io.*;

/**
 * Created by chsru on 4/18/2017.
 */
public class BankApplication {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int option = 0;
        do{
            System.out.println("1. Create Account");
            System.out.println("2. Find Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. Delete Account");
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
                case 4:
                    withdraw();
                    break;
                case 5:
                    transfer();
                    break;
                case 6:
                    deleteAccount();
                    break;
            }
        }while(option != 0);
    }

    private static void deleteAccount()throws IOException {
        System.out.println("Please enter account number");
        int accountNumber = Integer.parseInt(bufferedReader.readLine());
        File f = new File("accounts/"+accountNumber+".txt");
        if(!f.exists()) {
            System.err.println(" Source Account not found");
        }
        else{
            f.delete();
            System.out.println("Account Deleted");
        }
    }

    private static void transfer() throws IOException, ClassNotFoundException {
        System.out.println("Please enter source account number");
        int srcAccountNumber = Integer.parseInt(bufferedReader.readLine());
        File sf = new File("accounts/"+srcAccountNumber+".txt");
        System.out.println("Please enter destination account number");
        int dstAccountNumber = Integer.parseInt(bufferedReader.readLine());
        File df = new File("accounts/"+dstAccountNumber+".txt");
        if(!sf.exists()) {
            System.err.println(" Source Account not found");
        }
        else if(!df.exists()){
            System.err.println(" Destination Account not found");
        }
        else{
            System.out.println("Please enter transfer amount");
            double amount = Double.valueOf(bufferedReader.readLine());
            Account srcAccountRecord =  (Account)new ObjectInputStream(new FileInputStream(sf)).readObject();
            double srcBalance = srcAccountRecord.getBalance();
            if(amount > srcBalance){
                System.out.println("Transfer amount exceeds Balance");
            }
            else {
                Account dstAccountRecord =  (Account)new ObjectInputStream(new FileInputStream(df)).readObject();
                double dstBalance = dstAccountRecord.getBalance();
                dstBalance = amount + dstBalance;
                dstAccountRecord.setBalance(dstBalance);
                srcBalance = srcBalance - amount;
                srcAccountRecord.setBalance(srcBalance);
                System.out.println("Amount Transfered");
                FileOutputStream fos = new FileOutputStream(df);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(dstAccountRecord);
                FileOutputStream foss = new FileOutputStream(sf);
                ObjectOutputStream ooos = new ObjectOutputStream(foss);
                ooos.writeObject(srcAccountRecord);
            }
        }
    }

    private static void withdraw() throws IOException, ClassNotFoundException {
        System.out.println("Please enter your account number");
        int accountNumber = Integer.parseInt(bufferedReader.readLine());
        File f = new File("accounts/"+accountNumber+".txt");
        if(!f.exists()) {
            System.err.print("Account not found");
        } else {
            System.out.println("Please enter withdraw amount");
            double amount = Double.valueOf(bufferedReader.readLine());
            Account accountRecord =  (Account)new ObjectInputStream(new FileInputStream(f)).readObject();
            double balance = accountRecord.getBalance();
            if(amount > balance){
                System.out.println("Withdraw amount exceeds Balance");
            }
            else {
                balance = balance - amount;
                accountRecord.setBalance(balance);
                System.out.println("Balance is "+ balance);
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(accountRecord);
            }
        }
    }

    private static void deposit() throws IOException, ClassNotFoundException {
        FileOutputStream fos = null;
        try {
            System.out.println("Please enter your account number");
            int accountNumber = Integer.parseInt(bufferedReader.readLine());
            File f = new File("accounts/"+accountNumber+".txt");
            if(!f.exists()) {
                System.err.print("Account not found");
            } else {
                System.out.println("Please enter Deposit amount");
                double amount = Double.valueOf(bufferedReader.readLine());
                Account accountRecord =  (Account)new ObjectInputStream(new FileInputStream(f)).readObject();
                double balance = accountRecord.getBalance();
                balance = amount + balance;
                accountRecord.setBalance(balance);
                System.out.println("Balance is "+ balance);
                fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(accountRecord);
            }
        } catch (NumberFormatException ex) {
            System.out.println("Not a number !");
        }catch (ClassNotFoundException exe) {
            System.out.println("Class not found !");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos != null) {
                fos.close();
            }
        }
    }

    private static void findBalance() throws IOException, ClassNotFoundException {
        System.out.println("Please enter your account number");
        int accountNumber = Integer.parseInt(bufferedReader.readLine());
        File f = new File("accounts/"+accountNumber+".txt");
        if(!f.exists()) {
            System.err.print("Account not found");
        } else {
            Account accountRecord =  (Account)new ObjectInputStream(new FileInputStream(f)).readObject();
            System.out.println("Balance is "+ accountRecord.getBalance());
        }
    }

    private static void createAccount() throws IOException {
        FileOutputStream fos = null;
        try {
            Account acc = new Account();
            System.out.println("Please enter name");
            acc.setName(bufferedReader.readLine());
            System.out.println("Please enter deposit balance");
            acc.setBalance(Double.valueOf(bufferedReader.readLine()));
            acc.setAccountId((int)(Math.random()*10000));
            File f = new File("accounts/"+acc.getAccountId()+".txt");
            while(f.exists()) {
                acc.setAccountId((int)(Math.random()*10000));
                f = new File("accounts/"+acc.getAccountId()+".txt");
            }
            fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(acc);
            System.out.println("Account is created with number "+ acc.getAccountId());
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

