<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css?v=1">
</head>
<body>

<jsp:include page="/views/common/header.jsp" />

<div class="container" style="margin-top:30px;">

    <h2>Admin Dashboard</h2>
    <p>Manage recruitment system data from here.</p>

    <div style="margin:20px 0;">
        <div style="display:inline-block; margin-right:20px; padding:15px; border:1px solid #ccc;">
            <h3>Total Candidates</h3>
            <p><%= request.getAttribute("candidateCount") %></p>
        </div>

        <div style="display:inline-block; margin-right:20px; padding:15px; border:1px solid #ccc;">
            <h3>Total Messages</h3>
            <p><%= request.getAttribute("messageCount") %></p>
        </div>

        <div style="display:inline-block; margin-right:20px; padding:15px; border:1px solid #ccc;">
            <h3>Total Jobs</h3>
            <p><%= request.getAttribute("jobCount") %></p>
        </div>

        <div style="display:inline-block; padding:15px; border:1px solid #ccc;">
            <h3>Total Applications</h3>
            <p><%= request.getAttribute("applicationCount") %></p>
        </div>
    </div>

    <div style="margin-top:20px;">

        <a href="${pageContext.request.contextPath}/admin/candidates" style="display:inline-block; margin-right:15px; margin-bottom:10px; padding:10px 15px; background:#1e3a8a; color:white; text-decoration:none;">
            View Candidates
        </a>

        <a href="${pageContext.request.contextPath}/admin/messages" style="display:inline-block; margin-right:15px; margin-bottom:10px; padding:10px 15px; background:#1e3a8a; color:white; text-decoration:none;">
            View Contact Messages
        </a>

        <a href="${pageContext.request.contextPath}/admin/jobs" style="display:inline-block; margin-right:15px; margin-bottom:10px; padding:10px 15px; background:#1e3a8a; color:white; text-decoration:none;">
            View Jobs
        </a>

        <a href="${pageContext.request.contextPath}/admin/services" style="display:inline-block; margin-right:15px; margin-bottom:10px; padding:10px 15px; background:#1e3a8a; color:white; text-decoration:none;">
            View Services
        </a>

        <a href="${pageContext.request.contextPath}/admin/applications" style="display:inline-block; margin-right:15px; margin-bottom:10px; padding:10px 15px; background:#1e3a8a; color:white; text-decoration:none;">
            View Applications
        </a>

        <a href="${pageContext.request.contextPath}/admin/logout" style="display:inline-block; margin-right:15px; margin-bottom:10px; padding:10px 15px; background:#dc2626; color:white; text-decoration:none;">
            Logout
        </a>

    </div>

</div>

<jsp:include page="/views/common/footer.jsp" />

</body>
</html>