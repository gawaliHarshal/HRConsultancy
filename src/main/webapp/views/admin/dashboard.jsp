<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css?v=1">
</head>
<body>

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
        <a href="${pageContext.request.contextPath}/admin/candidates" style="display:inline-block; margin-right:15px; padding:10px 15px; background:#1e3a8a; color:white; text-decoration:none;">
            View Candidates
        </a>

        <a href="${pageContext.request.contextPath}/admin/messages" style="display:inline-block; margin-right:15px; padding:10px 15px; background:#1e3a8a; color:white; text-decoration:none;">
            View Contact Messages
        </a>

        <a href="${pageContext.request.contextPath}/jobs" style="display:inline-block;  margin-right:15px; padding:10px 15px; background:#1e3a8a; color:white; text-decoration:none;">
            View Jobs
        </a>
        
         <a href="${pageContext.request.contextPath}/admin/applications" style="display:inline-block; padding:10px 15px; background:#1e3a8a; color:white; text-decoration:none;">
            View Applications
        </a>
        
    </div>

</body>
</html>