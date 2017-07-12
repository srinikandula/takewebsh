package com.web.srini;

/**
 * Created by busda001 on 7/12/17.
 */

import com.web.HarshaJava.Account;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;


/**
 * Created by sriharshakota on 7/11/17.
 */
public class TrasactionExample {

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int option = 0;
        do {
            System.out.println("1. Create Account");
            System.out.println("2. Find Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Delete Account");
            System.out.println("6. Transfer");
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
                case 6:
                    trasnsfer();
                    break;
            }
        } while (option != 0);
    }

    private static void trasnsfer() throws Exception {
        System.out.println("Please enter Source account number");
        int sourceAccountNumber = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Please enter destination account number");
        int destAccountNumber = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Please enter balance");
        int amount = Integer.parseInt(bufferedReader.readLine());
        try(Connection connection = getConnection()){
            connection.setAutoCommit(false);
            if(withdraw(connection, sourceAccountNumber, amount)) {
               if(deposit(connection, destAccountNumber,amount)) {
                   connection.commit();
                   System.out.println("success");

               } else {
                   //revert the withdraw
                   connection.rollback();
               }
            } else {
                System.out.println("Transfer failed");
            }
        };
    }

    public static void createNewAccount() throws Exception {
        Account newAccount = new Account();
        System.out.println("Please enter name");
        newAccount.setName(bufferedReader.readLine());
        System.out.println("Please enter deposit balance");
        newAccount.setBalance(Double.valueOf(bufferedReader.readLine()));
        newAccount.setAccountId((int) (Math.random() * 10000));
        System.out.println("Account Number:" + newAccount.getAccountId());
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
//interest into accounts values(101,'srini')
            statement = connection.prepareStatement("insert into Accounts values(?,?,?)");
                    statement.setInt(1, newAccount.getAccountId());
            statement.setString(2, newAccount.getName());
            statement.setDouble(3, newAccount.getBalance());
            int count = statement.executeUpdate();

        }finally {

            statement.close();
            connection.close();
        }
        System.out.println(" New Account Record inserted ");
    }


    public static void findBalance() throws Exception {
        System.out.println("Please enter your account number");
        int accountNumber = Integer.parseInt(bufferedReader.readLine());

        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;


        try {
            connection = getConnection();
            statement = connection.createStatement();

            rs = statement.executeQuery("select * from Accounts");
            while (rs.next()) {
                if (rs.getInt("accountId") == accountNumber) {
                    System.out.println("Account Number : " + accountNumber + " Balance : " + rs.getDouble("balance"));
                } else {
                    System.out.println("Account Not found");
                }
            }
        }
        finally {
            rs.close();
            statement.close();
            connection.close();
        }
    }

    public static void deposit() throws Exception{
        System.out.println("Please enter your account number");
        int accountNumber = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Please enter deposit amount");
        int depositAmount = Integer.parseInt(bufferedReader.readLine());


        deposit(getConnection(), accountNumber, depositAmount);
    }

    private static boolean deposit(Connection connection, int accountNumber, int depositAmount) throws ClassNotFoundException, SQLException {
        Statement statement = null;
        ResultSet rs = null;
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("select * from Accounts where accontId = ?");
            preparedStatement.setInt(1, accountNumber);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                if (rs.getInt("accountId") == accountNumber) {
                    double oldBalns = rs.getDouble("balance");
                    double newBalns = depositAmount+oldBalns;
                    PreparedStatement statement2 = null;
                    statement2 = connection.prepareStatement("update accounts set balance =? where accountid =? ");
                    statement2.setInt(2, accountNumber);
                    statement2.setDouble(1, newBalns);
                    int count = statement2.executeUpdate();
                    System.out.println("Account Number : "+accountNumber + "New Balance : "+newBalns);
                    return true;
                } else {
                    System.out.println("Account Not found");
                }
            }
            return false;
        }finally {
            statement.close();
        }
    }

    public static void withdraw() throws Exception{
        System.out.println("Please enter your account number");
        int accountNumber = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Please enter withdraw amount");
        int withdrawAmount = Integer.parseInt(bufferedReader.readLine());

        withdraw(getConnection(),accountNumber, withdrawAmount);

    }

    private static boolean withdraw(Connection connection, int accountNumber, int withdrawAmount) throws ClassNotFoundException, SQLException {
        Statement statement = null;
        ResultSet rs = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Accounts where accontId = ?");
            preparedStatement.setInt(1, accountNumber);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                if (rs.getInt("accountId") == accountNumber) {
                    double oldBalns = rs.getDouble("balance");
                    if (oldBalns > withdrawAmount) {
                        double newBalns = oldBalns - withdrawAmount;
                        PreparedStatement statement2 = null;
                        statement2 = connection.prepareStatement("update accounts set balance =? where accountid =? ");
                        statement2.setInt(2, accountNumber);
                        statement2.setDouble(1, newBalns);
                        int count = statement2.executeUpdate();
                        System.out.println("Account Number : "+accountNumber + "New Balance : "+newBalns);
                        return true;
                    }else{
                        System.out.println("Insufficient funds in account");
                        return false;
                    }

                } else {
                    System.out.println("Account Not found");
                    return false;
                }
            } else {
                return false;
            }

        }finally {
            statement.close();
        }
    }

    public static void deleteAccount() throws Exception{
        System.out.println("Please enter your account number");
        int accountNumber = Integer.parseInt(bufferedReader.readLine());

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement("DELETE FROM Accounts WHERE accountid = ?");
            statement.setInt(1, accountNumber);
            int count = statement.executeUpdate();

        }finally {

            statement.close();
            connection.close();
        }
        System.out.println(" Account DELETED ");


    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        return connection;
    }


}
