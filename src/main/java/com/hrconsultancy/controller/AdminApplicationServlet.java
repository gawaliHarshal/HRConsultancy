package com.hrconsultancy.controller;

import java.io.IOException;
import java.util.List;

import com.hrconsultancy.dao.JobApplicationDAO;
import com.hrconsultancy.model.JobApplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/admin/applications")
public class AdminApplicationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private JobApplicationDAO jobApplicationDAO;

    @Override
    public void init() throws ServletException {
        jobApplicationDAO = new JobApplicationDAO();
    }

    @Override
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 HttpSession session = request.getSession(false);

    	    if (session == null || session.getAttribute("admin") == null) {
    	        response.sendRedirect(request.getContextPath() + "/admin/login");
    	        return;
    	    }

        List<JobApplication> applications = jobApplicationDAO.getAllApplications();
        request.setAttribute("applications", applications);

        request.getRequestDispatcher("/views/admin/applications.jsp").forward(request, response);
    }
}