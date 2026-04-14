package com.hrconsultancy.controller;

import java.io.IOException;

import com.hrconsultancy.dao.CandidateDAO;
import com.hrconsultancy.model.Candidate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/candidate/login")
public class CandidateLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CandidateDAO candidateDAO;

    @Override
    public void init() throws ServletException {
        candidateDAO = new CandidateDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/views/candidate/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email != null) {
            email = email.trim();
        }

        if (password != null) {
            password = password.trim();
        }

        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/candidate/login?error=empty");
            return;
        }

        Candidate candidate = candidateDAO.getCandidateByEmailAndPassword(email, password);

        if (candidate != null) {
            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }

            HttpSession newSession = request.getSession(true);
            newSession.setAttribute("candidate", candidate);

            response.sendRedirect(request.getContextPath() + "/jobs?login=success");
        } else {
            response.sendRedirect(request.getContextPath() + "/candidate/login?error=invalid");
        }
    }
}