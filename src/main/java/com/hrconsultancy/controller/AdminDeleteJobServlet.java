package com.hrconsultancy.controller;

import java.io.IOException;

import com.hrconsultancy.dao.JobDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/admin/jobs/delete")
public class AdminDeleteJobServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private JobDAO jobDAO;

    @Override
    public void init() throws ServletException {
        jobDAO = new JobDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        jobDAO.deleteJob(id);

        response.sendRedirect(request.getContextPath() + "/admin/jobs?deleted=1");
    }
}