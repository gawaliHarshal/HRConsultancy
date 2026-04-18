package com.hrconsultancy.controller;

import java.io.IOException;

import com.hrconsultancy.dao.JobApplicationDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/admin/applications/update-status")
public class AdminUpdateApplicationStatusServlet extends HttpServlet {

    private JobApplicationDAO dao;

    @Override
    public void init() {
        dao = new JobApplicationDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("status");

        dao.updateApplicationStatus(id, status);

        response.sendRedirect(request.getContextPath() + "/admin/applications?updated=1");
    }
}