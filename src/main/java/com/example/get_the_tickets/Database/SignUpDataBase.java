package com.example.get_the_tickets.Database;

import java.sql.*;

public class SignUpDataBase {

    public static void  getSignUpMsg(String[] args)throws Exception {

        String url = "jdbc:mysql://localhost:3306/get_the_tickets";
        String username = "root";
        String password = "Bharathi2004";

        Connection connection = null;
        String message = "";
        String message2 = "";
        String message3 = "";
        String message4 = "";
        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);
            Statement stmt = connection.createStatement();
            // Execute a query
            stmt.executeUpdate("INSERT INTO sign_up_form(id, name, username, password) VALUES(1, 'Bharathi', 'bharathi@gmial.com', 'bharathi');");

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection closed.");
                } catch (SQLException e) {
                    System.out.println("Failed to close the connection.");
                    e.printStackTrace();
                }
            }
        }

    }
}
