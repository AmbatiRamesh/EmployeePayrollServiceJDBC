package com.bridgelabz.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
}
