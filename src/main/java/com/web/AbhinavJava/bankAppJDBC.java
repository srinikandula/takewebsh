package com.web.AbhinavJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;


/**
 * Created by surap on 7/11/2017.
 */
public class bankAppJDBC {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int option = 0;
        do {
            System.out.println("1. Create New Account");
            System.out.println("2. Find Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Delete Account");
//            System.out.println("6. Balance Transfer");
            System.out.println("0. Exit");
            System.out.println("please enter your option");
            option = Integer.parseInt(bufferedReader.readLine());
            switch (option) {
                case 1:
                    createNew();
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
//                case 6:
//                    balanceTransfer();
//                    break;
            }
        } while (option != 0);
    }

    private static void createNew() throws Exception {
        System.out.println("Please enter your First Name");
        String firstName = bufferedReader.readLine();
        System.out.println("Please enter Last Name");
        String lastName = bufferedReader.readLine();
        System.out.println("Please enter deposit balance");
        Double amount = Double.valueOf(bufferedReader.readLine());
        int id = (int) (Math.random() * 10000);
        System.out.println("Account Number:" + id);

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("insert into accounts values(?,?,?,?)");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setDouble(4, amount);
            preparedStatement.executeUpdate();
        }
        finally {
            preparedStatement.close();
            connection.close();
        }
        System.out.println("Account Created");
    }
    private static void findAccountBalance() throws Exception {
        System.out.println("Please enter account number");
        int accountNumber = Integer.parseInt(bufferedReader.readLine());

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select * from accounts where accountId = ?");
            preparedStatement.setInt(1,accountNumber);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                if (rs.getInt("accountId") == accountNumber) {
                    System.out.println("Account Number : " + accountNumber + " Your Balance : " + rs.getDouble("balance"));
                }
            } else {
                System.out.println("Account Not found");
            }
        }
        finally {
            preparedStatement.close();
            connection.close();
        }
    }
    private static void withdrawCash() throws Exception {
        System.out.println("Please enter your account number");
        int accountNumber = Integer.parseInt(bufferedReader.readLine());

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select * from accounts where accountId = ?");
            preparedStatement.setInt(1,accountNumber);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                if (rs.getInt("accountId") == accountNumber) {
                    double oldBalns = rs.getDouble("balance");
                    System.out.println("Please enter withdraw amount");
                    int withdrawAmount = Integer.parseInt(bufferedReader.readLine());
                    if (oldBalns > withdrawAmount) {
                        double newBalns = oldBalns - withdrawAmount;
                        PreparedStatement statement2 = null;
                        statement2 = connection.prepareStatement("update accounts set balance =? where accountid =? ");
                        statement2.setInt(2, accountNumber);
                        statement2.setDouble(1, newBalns);
                        statement2.executeUpdate();
                        System.out.println("Account Number : "+accountNumber + " Your New Balance : "+newBalns);
                    }else{
                        System.out.println("Insufficient funds in account");
                    }
                }
            }else {
                System.out.println("Account Not found");
            }
        }finally {
            rs.close();
            preparedStatement.close();
            connection.close();
        }
    }
    private static void depositCash() throws Exception {
        System.out.println("Please enter your account number");
        int accountNumber = Integer.parseInt(bufferedReader.readLine());

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM accounts WHERE accountId = ?");
            preparedStatement.setInt(1,accountNumber);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                if (rs.getInt("accountId") == accountNumber) {
                    double oldBal = rs.getDouble("balance");
                    System.out.println("Please enter deposit amount");
                    int depositAmount = Integer.parseInt(bufferedReader.readLine());
                    double newBal = depositAmount+oldBal;
                    PreparedStatement statement2 = null;
                    statement2 = connection.prepareStatement("update accounts set balance =? where accountid = ? ");
                    statement2.setInt(2, accountNumber);
                    statement2.setDouble(1, newBal);
                    statement2.executeUpdate();
                    System.out.println("Account Number : "+accountNumber + " Your New Balance : "+newBal);
                }
            }else {
                System.out.println("Account Not found");
            }
        }finally {
            rs.close();
            preparedStatement.close();
            connection.close();
        }
    }

    private static void deleteAccount() throws Exception {
        System.out.println("Please enter your account number");
        int accountNumber = Integer.parseInt(bufferedReader.readLine());

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement2 = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM accounts WHERE accountId = ?");
            preparedStatement.setInt(1, accountNumber);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                preparedStatement2 = connection.prepareStatement("DELETE FROM accounts WHERE accountid = ?");
                preparedStatement2.setInt(1, accountNumber);
                preparedStatement2.executeUpdate();
                System.out.println(" Account Successfully DELETED ");
            }
            else {
                System.out.println("Account not found");
            }
        }finally {
           preparedStatement.close();
           preparedStatement2.close();
           connection.close();
        }
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        return connection;
    }
    }
