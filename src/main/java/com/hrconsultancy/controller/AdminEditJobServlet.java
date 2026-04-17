package com.hrconsultancy.controller;

import java.io.IOException;

import com.hrconsultancy.dao.JobDAO;
import com.hrconsultancy.model.Job;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/admin/jobs/edit")
public class AdminEditJobServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private JobDAO jobDAO;

    @Override
    public void init() throws ServletException {
        jobDAO = new JobDAO();
    }

    // load form
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Job job = jobDAO.getJobById(id);

        request.setAttribute("job", job);
        request.getRequestDispatcher("/views/admin/edit-job.jsp").forward(request, response);
    }

    // update
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Job job = new Job();
        job.setId(id);
        job.setTitle(request.getParameter("title"));
        job.setCompanyName(request.getParameter("companyName"));
        job.setLocation(request.getParameter("location"));
        job.setSalary(request.getParameter("salary"));
        job.setExperienceRequired(request.getParameter("experienceRequired"));
        job.setDescription(request.getParameter("description"));

        jobDAO.updateJob(job);

        response.sendRedirect(request.getContextPath() + "/admin/jobs?updated=1");
    }
}