package com.bridgelabz.jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class DataBase {
    public static Connection connection;

    public static void main(String[] args) throws SQLException {
        listOfDrivers();
        dataBase();
    }
    public static Connection dataBase(){
        String jdbcURL = "jdbc:mysql://localhost:3306/pay_roll?useSSL=false";
        String userName = "root";
        String password = "Ramesh@143";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver is loaded successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

            throw new IllegalStateException("Cannot load the driver successfully" + e);
        }

        try {
            System.out.println("Databases connected to the database: " + jdbcURL);
            connection = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("Connection established successfully" + connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

        public static void listOfDrivers () {
            Enumeration<java.sql.Driver> enumeration = DriverManager.getDrivers();
            while (enumeration.hasMoreElements()) {
                Driver driver = (Driver) enumeration.nextElement();
                System.out.println("  " + driver.getClass().getName());
            }
        }
    }

