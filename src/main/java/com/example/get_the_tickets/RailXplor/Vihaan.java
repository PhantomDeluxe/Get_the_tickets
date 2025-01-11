package com.example.get_the_tickets.RailXplor;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Vihaan extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String pnrNumber = req.getParameter("pnr");
        System.out.println("PNR Number: " + pnrNumber + " " + " I am here dude !!!!!");

        HttpURLConnection connect = getHttpURLConnection(pnrNumber);

        // Get the response code from the connection
        int responseCode = connect.getResponseCode();
        System.out.println("Response Code: " + responseCode);  // Debug: Print response code

        // Check if the response code is 200 (OK)
        String fromStationCode = null;
        String toStationCode = null;
        String DateofJourney = null;
        String BookingDate = null;

        if (responseCode == 200) {
            // If the response is OK, read the response input stream
            BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            // Read the response line by line and append to the response
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Print the successful response
            System.out.println("API Response: " + response.toString());
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response.toString());

            // Extract "fromStation" and "toStation" details

            JsonNode dataNode = rootNode.get("data");

            if (dataNode == null) {
                System.out.println("No data available.");
                return;
            }
            // Safely get "FromDetails"
            JsonNode fromDetailsNode = dataNode.get("FromDetails");

            if (fromDetailsNode != null) {
                fromStationCode = fromDetailsNode.has("stationCode") ? fromDetailsNode.get("stationCode").asText() : "N/A";
                String fromStationName = fromDetailsNode.has("stationName") ? fromDetailsNode.get("stationName").asText() : "N/A";
                System.out.println("From Station Code: " + fromStationCode);
                System.out.println("From Station Name: " + fromStationName);
            } else {
                System.out.println("FromDetails not available.");
            }

            // Safely get "ToDetails"
            JsonNode toDetailsNode = dataNode.get("ToDetails");
            if (toDetailsNode != null) {
                toStationCode = toDetailsNode.has("stationCode") ? toDetailsNode.get("stationCode").asText() : "N/A";
                String toStationName = toDetailsNode.has("stationName") ? toDetailsNode.get("stationName").asText() : "N/A";

                System.out.println("To Station Code: " + toStationCode);
                System.out.println("To Station Name: " + toStationName);
            } else {
                System.out.println("ToDetails not available.");
            }

            DateofJourney = dataNode.has("Doj") ? dataNode.get("Doj").asText() : "N/A";
            BookingDate = dataNode.has("BookingDate") ? dataNode.get("BookingDate").asText() : "N/A";

        }
        else{
            // If response is not OK, read and print the error response
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(connect.getErrorStream()));
            StringBuilder errorResponse = new StringBuilder();
            String errorLine;

            while ((errorLine = errorReader.readLine()) != null) {
                errorResponse.append(errorLine);
            }
            errorReader.close();

            // Print error message
            System.out.println("Failed to retrieve data. Response code: " + responseCode);
            System.out.println("Error Response: " + errorResponse.toString());
        }
        System.out.println("From Station Code: " + fromStationCode);
        System.out.println("To Station Code: " + toStationCode);
        System.out.println("Date of Journey: " + DateofJourney);
        System.out.println("Booking Date: " + BookingDate);

        Long millisDOJ = GetMillis(DateofJourney);
        System.out.println("The date of journey in millis: " + millisDOJ);

        Long millisBookingDate = GetMillis(BookingDate);
        System.out.println("The booking date in millis: " + millisBookingDate);

        req.setAttribute("fromCode", fromStationCode);
        req.setAttribute("toCode", toStationCode);
        req.setAttribute("DOJ", millisDOJ);
        req.setAttribute("BD", millisBookingDate);
        req.setAttribute("pnr", pnrNumber);

        RequestDispatcher dispatcher = req.getRequestDispatcher("trainsta");
        dispatcher.forward(req, res);
}

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String pnrNumber = req.getParameter("pnr");
        System.out.println("PNR Number: " + pnrNumber + " " + " I am here dude !!!!!");

        HttpURLConnection connect = getHttpURLConnection(pnrNumber);

        // Get the response code from the connection
        int responseCode = connect.getResponseCode();
        System.out.println("Response Code: " + responseCode);  // Debug: Print response code

        // Check if the response code is 200 (OK)
        String fromStationCode = null;
        String toStationCode = null;
        String DateofJourney = null;
        String BookingDate = null;

        if (responseCode == 200) {
            // If the response is OK, read the response input stream
            BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            // Read the response line by line and append to the response
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Print the successful response
            System.out.println("API Response: " + response.toString());
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response.toString());

            // Extract "fromStation" and "toStation" details

            JsonNode dataNode = rootNode.get("data");

            if (dataNode == null) {
                System.out.println("No data available.");
                return;
            }
            // Safely get "FromDetails"
            JsonNode fromDetailsNode = dataNode.get("FromDetails");

            if (fromDetailsNode != null) {
                fromStationCode = fromDetailsNode.has("stationCode") ? fromDetailsNode.get("stationCode").asText() : "N/A";
                String fromStationName = fromDetailsNode.has("stationName") ? fromDetailsNode.get("stationName").asText() : "N/A";
                System.out.println("From Station Code: " + fromStationCode);
                System.out.println("From Station Name: " + fromStationName);
            } else {
                System.out.println("FromDetails not available.");
            }

            // Safely get "ToDetails"
            JsonNode toDetailsNode = dataNode.get("ToDetails");
            if (toDetailsNode != null) {
                toStationCode = toDetailsNode.has("stationCode") ? toDetailsNode.get("stationCode").asText() : "N/A";
                String toStationName = toDetailsNode.has("stationName") ? toDetailsNode.get("stationName").asText() : "N/A";

                System.out.println("To Station Code: " + toStationCode);
                System.out.println("To Station Name: " + toStationName);
            } else {
                System.out.println("ToDetails not available.");
            }

            DateofJourney = dataNode.has("Doj") ? dataNode.get("Doj").asText() : "N/A";
            BookingDate = dataNode.has("BookingDate") ? dataNode.get("BookingDate").asText() : "N/A";
        }
        else{
            // If response is not OK, read and print the error response
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(connect.getErrorStream()));
            StringBuilder errorResponse = new StringBuilder();
            String errorLine;

            while ((errorLine = errorReader.readLine()) != null) {
                errorResponse.append(errorLine);
            }
            errorReader.close();

            // Print error message
            System.out.println("Failed to retrieve data. Response code: " + responseCode);
            System.out.println("Error Response: " + errorResponse.toString());
        }
        System.out.println("From Station Code: " + fromStationCode);
        System.out.println("To Station Code: " + toStationCode);
        System.out.println("Date of Journey: " + DateofJourney);
        System.out.println("Booking Date: " + BookingDate);

        Long millisDOJ = GetMillis(DateofJourney);
        System.out.println("The date of journey in millis: " + millisDOJ);

        Long millisBookingDate = GetMillis(BookingDate);
        System.out.println("The booking date in millis: " + millisBookingDate);

        req.setAttribute("fromCode", fromStationCode);
        req.setAttribute("toCode", toStationCode);
        req.setAttribute("DOJ", millisDOJ);
        req.setAttribute("BD", millisBookingDate);
        req.setAttribute("pnr", pnrNumber);

        RequestDispatcher dispatcher = req.getRequestDispatcher("trainsta");
        dispatcher.forward(req, res);   

    }
    private static HttpURLConnection getHttpURLConnection(String pnrNumber) throws IOException {
        // Set the API URL

        URL url = new URL("https://IRCTC.proxy-production.allthingsdev.co/api/v3/getPNRStatus" + "?pnrNumber=" + pnrNumber);

        // Create a connection object
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method to GET
        connection.setRequestMethod("GET");

        // Set the required request headers
        connection.setRequestProperty("X-RapidAPI-Host", "irctc1.p.rapidapi.com");
        connection.setRequestProperty("X-RapidAPI-Key", "fb8dbe5110mshcf13c98485917cfp100148jsnc69d7b39758b");
        connection.setRequestProperty("x-apihub-key", "CgDYrJ9pcHSFI7uvRWkLQpTJkRXYkh995fix4xtRItZvRTfS3Z");
        connection.setRequestProperty("x-apihub-host", "IRCTC.allthingsdev.co");
        connection.setRequestProperty("x-apihub-endpoint", "941600b8-85da-484b-ae57-b33b7035182b");

        // Return the connection object
        return connection;
    }
    private static Long GetMillis(String DateofJourney) {
        try {
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse(DateofJourney);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}

