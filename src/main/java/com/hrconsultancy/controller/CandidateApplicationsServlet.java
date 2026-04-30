package com.hrconsultancy.controller;

import java.io.IOException;
import java.util.List;

import com.hrconsultancy.dao.JobApplicationDAO;
import com.hrconsultancy.model.Candidate;
import com.hrconsultancy.model.JobApplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/candidate/applications")
public class CandidateApplicationsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private JobApplicationDAO jobApplicationDAO;

    @Override
    public void init() {
        jobApplicationDAO = new JobApplicationDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        Candidate candidate = (session != null) ? (Candidate) session.getAttribute("candidate") : null;

        if (candidate == null) {
            response.sendRedirect(request.getContextPath() + "/candidate/login?message=loginRequired");
            return;
        }

        List<JobApplication> applications =
                jobApplicationDAO.getApplicationsByCandidateId(candidate.getId());

        request.setAttribute("applications", applications);

        request.getRequestDispatcher("/views/candidate/applications.jsp").forward(request, response);
    }
}