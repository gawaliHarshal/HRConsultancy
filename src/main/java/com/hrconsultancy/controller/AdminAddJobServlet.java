package com.hrconsultancy.controller;

import java.io.IOException;

import com.hrconsultancy.dao.JobDAO;
import com.hrconsultancy.model.Job;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/jobs/add")
public class AdminAddJobServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private JobDAO jobDAO;

    @Override
    public void init() throws ServletException {
        jobDAO = new JobDAO();
    }

    // Show form
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/views/admin/add-job.jsp").forward(request, response);
    }

    // Handle form submit
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        String companyName = request.getParameter("companyName");
        String location = request.getParameter("location");
        String salary = request.getParameter("salary");
        String experienceRequired = request.getParameter("experienceRequired");
        String description = request.getParameter("description");

        Job job = new Job();
        job.setTitle(title);
        job.setCompanyName(companyName);
        job.setLocation(location);
        job.setSalary(salary);
        job.setExperienceRequired(experienceRequired);
        job.setDescription(description);

        boolean status = jobDAO.addJob(job);

        if (status) {
            response.sendRedirect(request.getContextPath() + "/admin/jobs?success=1");
        } else {
            response.sendRedirect(request.getContextPath() + "/admin/jobs/add?error=1");
        }
    }
}