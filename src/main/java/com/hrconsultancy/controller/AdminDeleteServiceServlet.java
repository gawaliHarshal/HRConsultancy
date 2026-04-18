package com.hrconsultancy.controller;

import java.io.IOException;

import com.hrconsultancy.dao.ServiceDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/admin/services/delete")
public class AdminDeleteServiceServlet extends HttpServlet {

    private ServiceDAO dao;

    @Override
    public void init() {
        dao = new ServiceDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        dao.deleteService(id);

        response.sendRedirect(request.getContextPath() + "/admin/services?deleted=1");
    }
}