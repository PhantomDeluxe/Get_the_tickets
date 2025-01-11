package com.example.get_the_tickets.GetIn;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;


public class Login extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        RequestDispatcher rd = request.getRequestDispatcher("MainPage.jsp");
        rd.forward(request, response);


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

       RequestDispatcher rd = request.getRequestDispatcher("MainPage.jsp");
        rd.forward(request, response);

    }
}