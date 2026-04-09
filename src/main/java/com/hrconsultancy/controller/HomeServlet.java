package com.hrconsultancy.controller;

import java.io.IOException;
import java.util.List;

import com.hrconsultancy.dao.ServiceDAO;
import com.hrconsultancy.model.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServiceDAO serviceDAO = new ServiceDAO();
        List<Service> serviceList = serviceDAO.getAllServices();

        request.setAttribute("serviceList", serviceList);
        request.getRequestDispatcher("/views/home.jsp").forward(request, response);
    }
}