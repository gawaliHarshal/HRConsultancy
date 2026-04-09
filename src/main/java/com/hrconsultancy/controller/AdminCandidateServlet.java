package com.hrconsultancy.controller;

import java.io.IOException;
import java.util.List;

import com.hrconsultancy.dao.CandidateDAO;
import com.hrconsultancy.model.Candidate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/candidates")
public class AdminCandidateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CandidateDAO candidateDAO;

    @Override
    public void init() throws ServletException {
        candidateDAO = new CandidateDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Candidate> candidates = candidateDAO.getAllCandidates();
        request.setAttribute("candidates", candidates);

        request.getRequestDispatcher("/views/admin/candidates.jsp").forward(request, response);
    }
}