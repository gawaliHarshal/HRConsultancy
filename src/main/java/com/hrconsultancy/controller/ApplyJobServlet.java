package com.hrconsultancy.controller;

import java.io.IOException;

import com.hrconsultancy.dao.JobApplicationDAO;
import com.hrconsultancy.model.JobApplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/apply-job")
public class ApplyJobServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private JobApplicationDAO jobApplicationDAO;

    @Override
    public void init() throws ServletException {
        jobApplicationDAO = new JobApplicationDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int candidateId = Integer.parseInt(request.getParameter("candidateId"));
        int jobId = Integer.parseInt(request.getParameter("jobId"));

        JobApplication application = new JobApplication(candidateId, jobId);

        boolean status = jobApplicationDAO.applyForJob(application);

        if (status) {
            response.sendRedirect(request.getContextPath() + "/jobs?applied=1");
        } else {
            response.sendRedirect(request.getContextPath() + "/jobs?error=1");
        }
    }
}