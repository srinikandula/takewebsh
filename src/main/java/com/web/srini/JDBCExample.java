package com.web.srini;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

/**
 * Created by busda001 on 7/10/17.
 */
public class JDBCExample {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        JDBCExample example = new JDBCExample();
        //example.insert();
        example.update();
        example.runSelect();
    }
    public void insert() throws Exception {
        System.out.println("Please enter id");
        int id = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Please enter firstname");
        String firstName = bufferedReader.readLine();
        System.out.println("Please enter lastname");
        String lastname = bufferedReader.readLine();
        System.out.println("Please enter address");
        String address = bufferedReader.readLine();
        System.out.println("Please enter city");
        String city = bufferedReader.readLine();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //load the JDBC driver
            Class.forName("org.postgresql.Driver");
            //create a connection to the database
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

            //create a statement
            statement = connection.prepareStatement("insert into persons values(?,?,?,?,?)");
            statement.setInt(1, id);
            statement.setString(2, firstName);
            statement.setString(3, lastname);
            statement.setString(4, address);
            statement.setString(5, city);
            int count = statement.executeUpdate();

        }finally {

            statement.close();
            connection.close();
        }
        System.out.println("Record inserted ");
    }


    public void update() throws Exception {
        System.out.println("Please enter id");
        int id = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Please enter lastname to update");
        String lastname = bufferedReader.readLine();

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //load the JDBC driver
            Class.forName("org.postgresql.Driver");
            //create a connection to the database
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

            //create a statement
            statement = connection.prepareStatement("update persons set lastname =? where personid =? ");
            statement.setInt(2, id);
            statement.setString(1, lastname);
            int count = statement.executeUpdate();

        }finally {

            statement.close();
            connection.close();
        }
        System.out.println("Record inserted ");
    }
    public  void runSelect() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            //load the JDBC driver
            Class.forName("org.postgresql.Driver");
            //create a connection to the database
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

            //create a statement
            statement = connection.createStatement();

            //execute
            rs = statement.executeQuery("select * from persons");
            while (rs.next()) {
                System.out.println(rs.getString("firstname")  + " " + rs.getString("lastname"));
            }
        }finally {
            rs.close();
            statement.close();
            connection.close();
        }
        System.out.println("******End of results");
    }
}
