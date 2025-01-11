package com.example.get_the_tickets.Database;

import java.sql.*;

public class DatabaseConnection {

    public static int insertMessage(String trainNumber, String trainName, String fromStation, String toStation, String pnrNumber ) {
        // Database URL, Username, and Password
        String url = "jdbc:mysql://localhost:3306/get_the_tickets";
        String username = "root";
        String password = "Bharathi2004";

        Connection connection = null;
        int rowsAffected = 0;  // Variable to store the number of rows affected by the query

        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);

            // Prepare the SQL statement with placeholders
            String query = "INSERT INTO train_details(trainNumber, trainName, fromStation, toStation, pnr) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query);

            // Set the values for the placeholders
            pstmt.setString(1, trainNumber);
            pstmt.setString(2, trainName);
            pstmt.setString(3, fromStation);
            pstmt.setString(4, toStation);
            pstmt.setString(5, pnrNumber);



            // Execute the update and get the number of rows affected
            rowsAffected = pstmt.executeUpdate();

            // Optionally, you can check if rows were affected (indicating a successful insertion)
            if (rowsAffected > 0) {
                System.out.println("Train details inserted successfully.");
            } else {
                System.out.println("No rows inserted.");
            }

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

        return rowsAffected;  // Return the number of rows affected by the insert operation
    }

    public static int tableTwoInsert(String trainNumber, String trainName, String fromStation, String toStation, String pnrNumber) throws Exception {
        // Database URL, Username, and Password
        String url = "jdbc:mysql://localhost:3306/get_the_tickets";
        String username = "root";
        String password = "Bharathi2004";

        Connection connection = null;
        int rowsAffected = 0;  // Variable to store the number of rows affected by the query

        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);

            // Prepare the SQL statement with placeholders
            String query = "INSERT INTO dailyDetails(trainNumber, trainName, fromStation, toStation, pnr) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query);

            // Set the values for the placeholders
            pstmt.setString(1, trainNumber);
            pstmt.setString(2, trainName);
            pstmt.setString(3, fromStation);
            pstmt.setString(4, toStation);
            pstmt.setString(5, pnrNumber);



            // Execute the update and get the number of rows affected
            rowsAffected = pstmt.executeUpdate();

            // Optionally, you can check if rows were affected (indicating a successful insertion)
            if (rowsAffected > 0) {
                System.out.println("Train details inserted successfully.");
            } else {
                System.out.println("No rows inserted.");
            }

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

        return rowsAffected;  // Return the number of rows affected by the insert operation
    }
}
