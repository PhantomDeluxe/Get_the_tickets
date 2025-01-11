
package com.example.get_the_tickets.RailXplor;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

public class DailyUpdate extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        System.out.println(" " + " "+ "DailyUpdate" + " ");
        String fromCode = (String) req.getAttribute("fromCode");
        String toCode = (String) req.getAttribute("toCode");
        String pnrNumber = req.getParameter("pnr");
        Long DateOfJourney = (Long) req.getAttribute("DOJ");
        Long bookingDate = (Long) req.getAttribute("BD");
        HttpURLConnection connect = getHttpURLConnection(fromCode, toCode);

        long compare_date_millis = 1735991943699L;
        System.out.println(compare_date_millis);

        while (compare_date_millis < DateOfJourney) {
            //System.out.println(" " + " "+ "Train Date Millis" + " ");

            long currentTimeMillis = System.currentTimeMillis();

            // Create a Calendar instance and set it to the current time
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(currentTimeMillis);

            // Reset time components to zero (midnight)
            // Calendar.set(Calendar.HOUR_OF_DAY, 0);
//            Calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            // Get the time in milliseconds with only the date part
            long dateOnlyMillis = calendar.getTimeInMillis();

            // Print the result
            while (compare_date_millis == dateOnlyMillis) {
                System.out.println(" " +"Hi I am Output" + " ");
            }
            compare_date_millis = compare_date_millis + 60000;
        }

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        System.out.println(" " + " "+ "DailyUpdate" + " ");
        String fromCode = (String) req.getAttribute("fromCode");
        String toCode = (String) req.getAttribute("toCode");
        String pnrNumber = req.getParameter("pnr");
        Long DateOfJourney = (Long) req.getAttribute("DOJ");
        Long bookingDate = (Long) req.getAttribute("BD");
        HttpURLConnection connect = getHttpURLConnection(fromCode, toCode);

        long compare_date_millis = 1735991943699L;
        System.out.println(compare_date_millis);

        while (compare_date_millis < DateOfJourney) {
            //System.out.println(" " + " "+ "Train Date Millis" + " ");

            long currentTimeMillis = System.currentTimeMillis();

            // Create a Calendar instance and set it to the current time
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(currentTimeMillis);

            // Reset time components to zero (midnight)
//            calendar.set(Calendar.HOUR_OF_DAY, 0);
//            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            // Get the time in milliseconds with only the date part
            long dateOnlyMillis = calendar.getTimeInMillis();

            // Print the result

            while (compare_date_millis == dateOnlyMillis) {
                System.out.println(" " +"Hi I am Output" + " ");
            }

            compare_date_millis = compare_date_millis + 60000;
        }

    }
    private static HttpURLConnection getHttpURLConnection(String fromStation, String toStation) throws IOException {

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


