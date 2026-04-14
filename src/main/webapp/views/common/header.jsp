<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.hrconsultancy.model.Candidate" %>

<%
    Candidate loggedInCandidate = (Candidate) session.getAttribute("candidate");
%>

<header class="site-header" style="background:#222; padding:15px 0;">
    <div class="container" style="display:flex; justify-content:space-between; align-items:center; color:white;">
        
        <div class="logo">
            <a href="${pageContext.request.contextPath}/home" style="color:white; text-decoration:none; font-size:22px; font-weight:bold;">
                HR Consultancy
            </a>
        </div>

        <nav class="navbar">
            <a href="${pageContext.request.contextPath}/home" style="color:white; margin-right:15px; text-decoration:none;">Home</a>
            <a href="${pageContext.request.contextPath}/jobs" style="color:white; margin-right:15px; text-decoration:none;">Jobs</a>
            <a href="${pageContext.request.contextPath}/candidate/register" style="color:white; margin-right:15px; text-decoration:none;">Register</a>

            <% if (loggedInCandidate != null) { %>
                <span style="margin-right:15px;">Welcome, <%= loggedInCandidate.getFullName() %></span>
                <a href="${pageContext.request.contextPath}/candidate/logout" style="color:white; text-decoration:none;">Logout</a>
            <% } else { %>
                <a href="${pageContext.request.contextPath}/candidate/login" style="color:white; text-decoration:none;">Login</a>
            <% } %>
        </nav>
    </div>
</header>