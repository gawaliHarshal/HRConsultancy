package com.hrconsultancy.controller;

import java.io.IOException;
import java.util.List;

import com.hrconsultancy.dao.ContactDAO;
import com.hrconsultancy.model.ContactMessage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/admin/messages")
public class AdminContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ContactDAO contactDAO;

    @Override
    public void init() throws ServletException {
        contactDAO = new ContactDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 HttpSession session = request.getSession(false);

    	    if (session == null || session.getAttribute("admin") == null) {
    	        response.sendRedirect(request.getContextPath() + "/admin/login");
    	        return;
    	    }

        List<ContactMessage> messages = contactDAO.getAllMessages();
        request.setAttribute("messages", messages);

        request.getRequestDispatcher("/views/admin/messages.jsp").forward(request, response);
    }
}