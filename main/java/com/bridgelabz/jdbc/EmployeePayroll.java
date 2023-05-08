package com.bridgelabz.jdbc;
import java.sql.*;
import java.time.LocalDate;

public class EmployeePayroll extends DataBase{
    public void employeePayrollData() throws SQLException {
        connection = dataBase();
        Statement statement = connection.createStatement();
        String query = "select * from employee_payroll";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int emp_id = resultSet.getInt(1);
            String emp_name = resultSet.getString(2);
            String gender = resultSet.getString(3);
            double salary = resultSet.getDouble(4);
            String startdate = resultSet.getString(5);
            System.out.println(emp_id + " " + emp_name + " " + gender + " " + salary + " " + startdate);
        }

        System.out.println("Retrieve all the employee payroll data");
    }
    public void insertEmployeePayrollData() throws SQLException {
        connection =dataBase();
        String insertQuery = "insert into employee_payroll (emp_name, gender, phone,department,address, salary, startdate) VALUES (?, ?, ?, ?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, "Ramesh");
        preparedStatement.setString(2, "M");
        preparedStatement.setDouble(3, 96408274);
        preparedStatement.setString(4, "IT");
        preparedStatement.setString(5, "Ap");
        preparedStatement.setString(6, "25000000.0");
        preparedStatement.setString(7, "2020-05-25");
        preparedStatement.execute();
        System.out.println("Record added successfully");
    }
    public void updateEmployeePayrollData() throws SQLException {
        connection = dataBase();
        String updateQuery = "update employee_payroll set salary = 3000000.00 where name = 'Ramesh'";
        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
        preparedStatement.executeUpdate();
        System.out.println("Record updated successfully");
    }
    public void updateWithPreparedStatementEmployeePayrollData() throws SQLException {
        connection= dataBase();
        String updateQuery = "update employee_payroll set salary = ? where name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
        preparedStatement.setDouble(1, 3000000.00);
        preparedStatement.setString(2, "Ramesh");
        preparedStatement.executeUpdate();
        System.out.println("Record updated successfully");
    }
    public static void getEmployeesByJoiningDateRange(LocalDate startDate, LocalDate endDate) throws SQLException {
        connection = dataBase();
        String query = "select * from employee_payroll where start between ? and ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setDate(1, Date.valueOf(startDate));
        preparedStatement.setDate(2, Date.valueOf(endDate));
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            LocalDate start = resultSet.getDate(8).toLocalDate();
            System.out.println( start);
        }

    }
}
