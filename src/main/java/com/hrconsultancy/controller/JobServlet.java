package com.hrconsultancy.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hrconsultancy.dao.JobApplicationDAO;
import com.hrconsultancy.dao.JobDAO;
import com.hrconsultancy.model.Candidate;
import com.hrconsultancy.model.Job;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/jobs")
public class JobServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private JobDAO jobDAO;
    private JobApplicationDAO jobApplicationDAO;

    @Override
    public void init() throws ServletException {
        jobDAO = new JobDAO();
        jobApplicationDAO = new JobApplicationDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Job> jobs = jobDAO.getAllJobs();
        request.setAttribute("jobs", jobs);

        Map<Integer, String> applicationStatusMap = new HashMap<>();

        HttpSession session = request.getSession(false);
        Candidate candidate = (session != null) ? (Candidate) session.getAttribute("candidate") : null;

        if (candidate != null) {
            applicationStatusMap = jobApplicationDAO.getApplicationStatusByCandidate(candidate.getId());
        }

        request.setAttribute("applicationStatusMap", applicationStatusMap);
        request.getRequestDispatcher("/views/jobs.jsp").forward(request, response);
    }
}