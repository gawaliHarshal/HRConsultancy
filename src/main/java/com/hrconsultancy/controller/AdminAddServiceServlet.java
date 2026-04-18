package com.hrconsultancy.controller;

import java.io.IOException;

import com.hrconsultancy.dao.ServiceDAO;
import com.hrconsultancy.model.Service;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/admin/services/add")
public class AdminAddServiceServlet extends HttpServlet {

    private ServiceDAO dao;

    @Override
    public void init() {
        dao = new ServiceDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, jakarta.servlet.ServletException {

        request.getRequestDispatcher("/views/admin/add-service.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String title = request.getParameter("title");
        String description = request.getParameter("description");

        Service service = new Service();
        service.setTitle(title);
        service.setDescription(description);

        boolean status = dao.addService(service);

        if (status) {
            response.sendRedirect(request.getContextPath() + "/admin/services?success=1");
        } else {
            response.sendRedirect(request.getContextPath() + "/admin/services/add?error=1");
        }
    }
}