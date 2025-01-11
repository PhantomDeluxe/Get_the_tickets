package com.example.get_the_tickets.RailXplor;

import com.example.get_the_tickets.Database.DatabaseConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import static java.lang.System.out;


public class TrainBetweenStation extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String fromCode = (String) req.getAttribute("fromCode");
        String toCode = (String) req.getAttribute("toCode");
        String pnrNumber = req.getParameter("pnr");
        Long DateOfJourney = (Long) req.getAttribute("DOJ");
        Long bookingDate = (Long) req.getAttribute("BD");
        HttpURLConnection connection = getHttpURLConnection(fromCode, toCode);

        // Get the response code from the connection
        int responseCode = connection.getResponseCode();
        out.println("Response Code: " + responseCode);  // Debug: Print response code

        // Check if the response code is 200 (OK)
        String trainNumber = null;
        String trainName = null;
        String fromStation = null;
        String toStation = null;
        if (responseCode == 200) {
            // If the response is OK, read the response input stream
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            // Read the response line by line and append to the response
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Print the successful response
            out.println("API Response: " + response);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response.toString());

            // Navigate to "data" node
            JsonNode dataArray = rootNode.get("data");
            if (dataArray != null && dataArray.isArray()) {
                // Iterate over the array
                for (JsonNode trainNode : dataArray) {
                    // Extract train details safely
                    trainNumber = trainNode.has("train_number") ? trainNode.get("train_number").asText() : "N/A";
                    trainName = trainNode.has("train_name") ? trainNode.get("train_name").asText() : "N/A";
                    fromStation = trainNode.has("from") ? trainNode.get("from").asText() : "N/A";
                    toStation = trainNode.has("to") ? trainNode.get("to").asText() : "N/A";

                    // Print extracted details
                    out.println("-----------------------");
                    out.println("Train Number: " + trainNumber);
                    out.println("Train Name: " + trainName);
                    out.println("From Station: " + fromStation);
                    out.println("To Station: " + toStation);
                    System.out.println("Date of Journey: " + DateOfJourney);
                    System.out.println("Booking Date: " + bookingDate);

                    DatabaseConnection.insertMessage(trainNumber, trainName, fromStation, toStation, pnrNumber);
                }
            } else {
                out.println("No train data available.");
            }

        } else {
            // If response is not OK, read and print the error response
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            StringBuilder errorResponse = new StringBuilder();
            String errorLine;

            while ((errorLine = errorReader.readLine()) != null) {
                errorResponse.append(errorLine);
            }
            errorReader.close();

            // Print error message
            out.println("Failed to retrieve data. Response code: " + responseCode);
            out.println("Error Response: " + errorResponse.toString());

        }
        RequestDispatcher dispatche = req.getRequestDispatcher("dailyCheck");
        dispatche.forward(req, res);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String fromCode = (String) req.getAttribute("fromCode");
        String toCode = (String) req.getAttribute("toCode");
        String pnrNumber = req.getParameter("pnr");
        Long DateOfJourney = (Long) req.getAttribute("DOJ");
        Long bookingDate = (Long) req.getAttribute("BD");

        HttpURLConnection connection = getHttpURLConnection(fromCode, toCode);

        // Get the response code from the connection
        int responseCode = connection.getResponseCode();
        out.println("Response Code: " + responseCode);  // Debug: Print response code

        // Check if the response code is 200 (OK)
        if (responseCode == 200) {
            // If the response is OK, read the response input stream
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            // Read the response line by line and append to the response
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Print the successful response
            out.println("API Response: " + response);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response.toString());

            // Navigate to "data" node
            JsonNode dataArray = rootNode.get("data");
            if (dataArray != null && dataArray.isArray()) {
                // Iterate over the array
                for (JsonNode trainNode : dataArray) {
                    // Extract train details safely
                    String trainNumber = trainNode.has("train_number") ? trainNode.get("train_number").asText() : "N/A";
                    String trainName = trainNode.has("train_name") ? trainNode.get("train_name").asText() : "N/A";
                    String fromStation = trainNode.has("from") ? trainNode.get("from").asText() : "N/A";
                    String toStation = trainNode.has("to") ? trainNode.get("to").asText() : "N/A";

                    // Print extracted details
                    out.println("-----------------------");
                    out.println("Train Number: " + trainNumber);
                    out.println("Train Name: " + trainName);
                    out.println("From Station: " + fromStation);
                    out.println("To Station: " + toStation);
                    System.out.println("Date of Journey: " + DateOfJourney);
                    System.out.println("Booking Date: " + bookingDate);

                    DatabaseConnection.insertMessage(trainNumber, trainName, fromStation, toStation, pnrNumber);
                }
            } else {
                out.println("No train data available.");
            }

        } else {
            // If response is not OK, read and print the error response
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            StringBuilder errorResponse = new StringBuilder();
            String errorLine;

            while ((errorLine = errorReader.readLine()) != null) {
                errorResponse.append(errorLine);
            }
            errorReader.close();

            // Print error message
            out.println("Failed to retrieve data. Response code: " + responseCode);
            out.println("Error Response: " + errorResponse.toString());

        }

        req.setAttribute("fromCode", fromCode);
        req.setAttribute("toCode", toCode);
        req.setAttribute("DOJ", DateOfJourney);
        req.setAttribute("BD", bookingDate);
        req.setAttribute("pnr", pnrNumber);

        RequestDispatcher dispatche = req.getRequestDispatcher("dailyCheck");
        dispatche.forward(req, res);
    }


    private static  HttpURLConnection getHttpURLConnection(String fromStation, String toStation) throws IOException {

        String dateOfJourney = "2025-01-01";
        String urlString = "https://irctc.proxy-production.allthingsdev.co/api/v3/trainBetweenStations"
                + "?fromStationCode=" + fromStation
                + "&toStationCode=" + toStation
                + "&dateOfJourney=" + dateOfJourney;
        URL url = new URL(urlString);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method to GET
        connection.setRequestMethod("GET");

        // Set the required request headers
        connection.setRequestProperty("X-RapidAPI-Host", "irctc1.p.rapidapi.com");
        connection.setRequestProperty("X-RapidAPI-Key", "fb8dbe5110mshcf13c98485917cfp100148jsnc69d7b39758b");
        connection.setRequestProperty("x-apihub-key", "CgDYrJ9pcHSFI7uvRWkLQpTJkRXYkh995fix4xtRItZvRTfS3Z");
        connection.setRequestProperty("x-apihub-host", "IRCTC.allthingsdev.co");
        connection.setRequestProperty("x-apihub-endpoint", "ba186358-897d-4f31-8c78-33941455b792");

        // Return the connection object
        return connection;
    }
}
