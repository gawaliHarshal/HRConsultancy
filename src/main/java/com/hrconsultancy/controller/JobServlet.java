package com.hrconsultancy.controller;

import java.io.IOException;
import java.util.List;

import com.hrconsultancy.dao.JobDAO;
import com.hrconsultancy.model.Job;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/jobs")
public class JobServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private JobDAO jobDAO;

    @Override
    public void init() throws ServletException {
        jobDAO = new JobDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Job> jobs = jobDAO.getAllJobs();
        request.setAttribute("jobs", jobs);

        request.getRequestDispatcher("/views/jobs.jsp").forward(request, response);
    }
}