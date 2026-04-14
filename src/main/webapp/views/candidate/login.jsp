<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Candidate Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css?v=1">
</head>
<body>

<jsp:include page="/views/common/header.jsp" />

<div class="container" style="margin-top: 40px; max-width: 500px;">

    <h2 style="margin-bottom: 20px;">Candidate Login</h2>

    <!-- Messages -->
    <% if ("1".equals(request.getParameter("registered"))) { %>
    <p style="color:green;">Registration successful. Please login.</p>
<% } %>

    <% if ("invalid".equals(request.getParameter("error"))) { %>
        <p style="color:red;">Invalid email or password.</p>
    <% } %>

    <% if ("empty".equals(request.getParameter("error"))) { %>
        <p style="color:red;">Email and password are required.</p>
    <% } %>

    <% if ("1".equals(request.getParameter("logout"))) { %>
        <p style="color:green;">Logged out successfully.</p>
    <% } %>

    <% if ("loginRequired".equals(request.getParameter("message"))) { %>
        <p style="color:red;">Please login first to apply for a job.</p>
    <% } %>

    <!-- Login Form -->
    <form action="${pageContext.request.contextPath}/candidate/login" method="post">

        <div style="margin-bottom: 15px;">
            <label>Email:</label><br>
            <input type="email" name="email" required style="width:100%; padding:8px;">
        </div>

        <div style="margin-bottom: 20px;">
            <label>Password:</label><br>
            <input type="password" name="password" required style="width:100%; padding:8px;">
        </div>

        <button type="submit" style="padding:10px 20px; cursor:pointer;">
            Login
        </button>
    </form>

</div>

<jsp:include page="/views/common/footer.jsp" />

</body>
</html>