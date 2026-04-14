package com.hrconsultancy.controller;

import java.io.IOException;

import com.hrconsultancy.dao.JobApplicationDAO;
import com.hrconsultancy.model.Candidate;
import com.hrconsultancy.model.JobApplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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

        HttpSession session = request.getSession(false);
        Candidate candidate = (session != null) ? (Candidate) session.getAttribute("candidate") : null;

        if (candidate == null) {
            response.sendRedirect(request.getContextPath() + "/candidate/login?message=loginRequired");
            return;
        }

        try {
            int candidateId = candidate.getId();
            int jobId = Integer.parseInt(request.getParameter("jobId"));

            boolean alreadyApplied = jobApplicationDAO.hasCandidateApplied(candidateId, jobId);

            if (alreadyApplied) {
                response.sendRedirect(request.getContextPath() + "/jobs?alreadyApplied=1");
                return;
            }

            JobApplication application = new JobApplication(candidateId, jobId);

            boolean status = jobApplicationDAO.applyForJob(application);

            if (status) {
                response.sendRedirect(request.getContextPath() + "/jobs?applied=1");
            } else {
                response.sendRedirect(request.getContextPath() + "/jobs?error=1");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/jobs?error=1");
        }
    }
}