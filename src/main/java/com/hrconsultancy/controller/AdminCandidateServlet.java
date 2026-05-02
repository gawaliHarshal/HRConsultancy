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
import jakarta.servlet.http.HttpSession;

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
    	  HttpSession session = request.getSession(false);

    	    if (session == null || session.getAttribute("admin") == null) {
    	        response.sendRedirect(request.getContextPath() + "/admin/login");
    	        return;
    	    }

        List<Candidate> candidates = candidateDAO.getAllCandidates();
        request.setAttribute("candidates", candidates);

        request.getRequestDispatcher("/views/admin/candidates.jsp").forward(request, response);
    }
}