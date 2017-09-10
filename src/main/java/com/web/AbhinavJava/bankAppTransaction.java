package com.web.AbhinavJava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

/**
 * Created by surap on 7/17/2017.
 */
public class bankAppTransaction {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int option = 0;
        do {
            System.out.println("1. Create New Account");
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
                    deleteAccount();
                    break;
                case 6:
                    trasnsfer();
                    break;
            }
        } while (option != 0);
    }

    private static void trasnsfer() throws Exception {
        System.out.println("Please enter your Source account number");
        int sourceAccountNumber = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Please enter destination account number");
        int destAccountNumber = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Please enter amount");
        int amount = Integer.parseInt(bufferedReader.readLine());
        try(Connection connection = getConnection()){
            connection.setAutoCommit(false);
            if(withdraw(connection, sourceAccountNumber, amount)) {
                if(deposit(connection, destAccountNumber, amount)) {
                    connection.commit();
                    System.out.println("Transfer success");
                } else {
                    System.out.println("Check your Destination account number, Transfer failed and Amount refunded");
                    connection.rollback();
                }
            } else {
                System.out.println("Transfer failed");
                connection.rollback();
            }
        };
    }

    public static void createAccount() throws Exception {
        System.out.println("Please enter First Name");
        String firstName = bufferedReader.readLine();
        System.out.println("Please enter Last Name");
        String lastName = bufferedReader.readLine();
        System.out.println("Please enter deposit balance");
        Double amount = Double.valueOf(bufferedReader.readLine());
        int id = (int) (Math.random() * 10000);
        System.out.println("Account Number:" + id);

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement("INSERT into accounts values(?,?,?,?)");
            statement.setInt(1, id);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setDouble(4, amount);
            statement.executeUpdate();
        }
        finally {
            statement.close();
            connection.close();
        }
        System.out.println("Account Created");
    }


    public static void findBalance() throws Exception {
        System.out.println("Please enter your account number");
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
                    System.out.println("Your Account Number : " + accountNumber + " Your Balance : " + rs.getDouble("balance"));
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

    public static void deposit() throws Exception{
        System.out.println("Please enter account number");
        int accountNumber = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Please enter deposit amount");
        int depositAmount = Integer.parseInt(bufferedReader.readLine());

        Connection connection = getConnection();
        deposit(connection, accountNumber, depositAmount);
        connection.close();
    }

    private static boolean deposit(Connection connection, int accountNumber, int depositAmount) throws Exception {
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement2 = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement("select * from accounts where accountId = ?");
            preparedStatement.setInt(1, accountNumber);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                if (rs.getInt("accountId") == accountNumber) {
                    double oldBalns = rs.getDouble("balance");
                    double newBalns = depositAmount+oldBalns;
                    preparedStatement2 = connection.prepareStatement("update accounts set balance =? where accountid =? ");
                    preparedStatement2.setInt(2, accountNumber);
                    preparedStatement2.setDouble(1, newBalns);
                    preparedStatement2.executeUpdate();
                    System.out.println("Account Number : "+accountNumber + " New Balance : "+newBalns);
                    return true;
                }
            }
            else {
                System.out.println("Account Not found");
            }
            return false;
        }finally {
            rs.close();
            preparedStatement.close();
            if(preparedStatement2 != null){
                preparedStatement2.close();
            }
        }
    }

    public static void withdraw() throws Exception{
        System.out.println("Please enter account number");
        int accountNumber = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Please enter withdraw amount");
        int withdrawAmount = Integer.parseInt(bufferedReader.readLine());

        Connection connection = getConnection();
        withdraw(getConnection(),accountNumber, withdrawAmount);
        connection.close();
    }

    private static boolean withdraw(Connection connection, int accountNumber, int withdrawAmount) throws Exception {
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement2 = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement("select * from accounts where accountId = ?");
            preparedStatement.setInt(1, accountNumber);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                if (rs.getInt("accountId") == accountNumber) {
                    double oldBalns = rs.getDouble("balance");
                    if (oldBalns > withdrawAmount) {
                        double newBalns = oldBalns - withdrawAmount;
                        preparedStatement2 = connection.prepareStatement("update accounts set balance =? where accountid =? ");
                        preparedStatement2.setInt(2, accountNumber);
                        preparedStatement2.setDouble(1, newBalns);
                        preparedStatement2.executeUpdate();
                        System.out.println("Account Number : "+accountNumber + " New Balance : "+newBalns);
                        return true;
                    }else{
                        System.out.println("Insufficient funds in account");
                        return false;
                    }
                }
            }else {
                System.out.println("Account Not found");
                return false;
            }
            return false;
        }
        finally {
            rs.close();
            preparedStatement.close();
            if(preparedStatement2 != null){
                preparedStatement2.close();
            }
        }
    }

    public static void deleteAccount() throws Exception{
        System.out.println("Please enter account number");
        int accountNumber = Integer.parseInt(bufferedReader.readLine());

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement statement2 = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM accounts WHERE accountId = ?");
            preparedStatement.setInt(1, accountNumber);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                statement2 = connection.prepareStatement("DELETE FROM accounts WHERE accountid = ?");
                statement2.setInt(1, accountNumber);
                statement2.executeUpdate();
                System.out.println(" Account DELETED ");
            }
            else {
                System.out.println("Account not found");
            }
        }finally {
            preparedStatement.close();
            if(statement2 != null){
                statement2.close();
            }
            connection.close();
        }
    }

    private static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        return connection;
    }

}
