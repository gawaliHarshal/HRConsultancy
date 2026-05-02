<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.hrconsultancy.model.Candidate" %>
<%@ page import="com.hrconsultancy.model.Admin" %>

<%
    Candidate loggedInCandidate = (Candidate) session.getAttribute("candidate");
    Admin loggedInAdmin = (Admin) session.getAttribute("admin");
%>

<header class="site-header">
    <div class="container">

        <div class="logo">
            <a href="${pageContext.request.contextPath}/home">
                HR Consultancy
            </a>
        </div>

        <nav class="navbar">

            <a href="${pageContext.request.contextPath}/home">Home</a>
            <a href="${pageContext.request.contextPath}/jobs">Jobs</a>

            <%-- 🔥 ADMIN VIEW --%>
            <% if (loggedInAdmin != null) { %>

                <a href="${pageContext.request.contextPath}/admin/dashboard">Dashboard</a>
                <a href="${pageContext.request.contextPath}/admin/jobs">Jobs</a>
                <a href="${pageContext.request.contextPath}/admin/services">Services</a>

                <span>Admin: <%= loggedInAdmin.getUsername() %></span>

                <a href="${pageContext.request.contextPath}/admin/logout">
                    Logout
                </a>

            <%-- 👤 CANDIDATE VIEW --%>
            <% } else if (loggedInCandidate != null) { %>

                <a href="${pageContext.request.contextPath}/candidate/applications">
                    My Applications
                </a>

                <span>Hi, <%= loggedInCandidate.getFullName() %></span>

                <a href="${pageContext.request.contextPath}/candidate/logout">
                    Logout
                </a>

            <%-- 🚫 NOT LOGGED IN --%>
            <% } else { %>

                <a href="${pageContext.request.contextPath}/candidate/register">
                    Register
                </a>

                <a href="${pageContext.request.contextPath}/candidate/login">
                    Login
                </a>

            <% } %>

        </nav>
    </div>
</header>