package com.hrconsultancy.controller;

import java.io.IOException;

import com.hrconsultancy.dao.ServiceDAO;
import com.hrconsultancy.model.Service;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/admin/services/edit")
public class AdminEditServiceServlet extends HttpServlet {

    private ServiceDAO dao;

    @Override
    public void init() {
        dao = new ServiceDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, jakarta.servlet.ServletException {

        int id = Integer.parseInt(request.getParameter("id"));
        Service service = dao.getServiceById(id);

        request.setAttribute("service", service);
        request.getRequestDispatcher("/views/admin/edit-service.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Service service = new Service();
        service.setId(id);
        service.setTitle(request.getParameter("title"));
        service.setDescription(request.getParameter("description"));

        dao.updateService(service);

        response.sendRedirect(request.getContextPath() + "/admin/services?updated=1");
    }
}