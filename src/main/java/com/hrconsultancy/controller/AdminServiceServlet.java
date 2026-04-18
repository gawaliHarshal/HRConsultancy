package com.hrconsultancy.controller;

import java.io.IOException;
import java.util.List;

import com.hrconsultancy.dao.ServiceDAO;
import com.hrconsultancy.model.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/admin/services")
public class AdminServiceServlet extends HttpServlet {

    private ServiceDAO serviceDAO;

    @Override
    public void init() {
        serviceDAO = new ServiceDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Service> services = serviceDAO.getAllServices();
        request.setAttribute("services", services);

        request.getRequestDispatcher("/views/admin/services.jsp").forward(request, response);
    }
}