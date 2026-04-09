package com.hrconsultancy.controller;

import java.io.IOException;

import com.hrconsultancy.dao.CandidateDAO;
import com.hrconsultancy.dao.ContactDAO;
import com.hrconsultancy.dao.JobDAO;
import com.hrconsultancy.dao.JobApplicationDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/dashboard")
public class AdminDashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CandidateDAO candidateDAO;
    private ContactDAO contactDAO;
    private JobDAO jobDAO;
    private JobApplicationDAO jobApplicationDAO;

    @Override
    public void init() throws ServletException {
        candidateDAO = new CandidateDAO();
        contactDAO = new ContactDAO();
        jobDAO = new JobDAO();
        jobApplicationDAO = new JobApplicationDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int candidateCount = candidateDAO.getCandidateCount();
        int messageCount = contactDAO.getMessageCount();
        int jobCount = jobDAO.getJobCount();
        int applicationCount = jobApplicationDAO.getApplicationCount();

        request.setAttribute("candidateCount", candidateCount);
        request.setAttribute("messageCount", messageCount);
        request.setAttribute("jobCount", jobCount);
        request.setAttribute("applicationCount", applicationCount);

        request.getRequestDispatcher("/views/admin/dashboard.jsp").forward(request, response);
    }
}