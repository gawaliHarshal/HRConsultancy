package com.hrconsultancy.controller;

import java.io.IOException;

import com.hrconsultancy.dao.ContactDAO;
import com.hrconsultancy.model.Contact;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        Contact contact = new Contact();
        contact.setName(name);
        contact.setEmail(email);
        contact.setMessage(message);

        ContactDAO contactDAO = new ContactDAO();
        boolean status = contactDAO.saveContact(contact);

        if (status) {
            response.sendRedirect("home?success=1");
        } else {
            response.sendRedirect("home?error=1");
        }
    }
}