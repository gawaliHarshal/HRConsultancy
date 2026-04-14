package com.hrconsultancy.controller;

import java.io.IOException;

import com.hrconsultancy.dao.CandidateDAO;
import com.hrconsultancy.model.Candidate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/candidate/register")
public class CandidateRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CandidateDAO candidateDAO;

    @Override
    public void init() throws ServletException {
        candidateDAO = new CandidateDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/candidate/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String qualification = request.getParameter("qualification");
        String experienceYears = request.getParameter("experienceYears");
        if (experienceYears != null) {
            experienceYears = experienceYears.trim();
        }
        String skills = request.getParameter("skills");
        String password = request.getParameter("password");

        Candidate candidate = new Candidate(fullName, email, phone, qualification, experienceYears, skills, password);

        boolean status = candidateDAO.saveCandidate(candidate);
        System.out.println("Registering: " + email);

        if (status) {
        	response.sendRedirect(request.getContextPath() + "/candidate/login?registered=1");
            
        } else {
            response.sendRedirect(request.getContextPath() + "/candidate/register?error=1");
        }
    }
}