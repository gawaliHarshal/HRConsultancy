<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hrconsultancy.model.JobApplication" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Job Applications</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css?v=1">
</head>
<body>

    <h2>Job Applications</h2>

    <%
        List<JobApplication> applications = (List<JobApplication>) request.getAttribute("applications");
        if (applications != null && !applications.isEmpty()) {
    %>

    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>Candidate Name</th>
            <th>Job Title</th>
            <th>Status</th>
            <th>Applied At</th>
        </tr>

        <%
            for (JobApplication app : applications) {
        %>
        <tr>
            <td><%= app.getId() %></td>
            <td><%= app.getCandidateName() %></td>
            <td><%= app.getJobTitle() %></td>
            <td><%= app.getApplicationStatus() %></td>
            <td><%= app.getAppliedAt() %></td>
        </tr>
        <%
            }
        %>
    </table>

    <%
        } else {
    %>
        <p>No job applications found.</p>
    <%
        }
    %>

</body>
</html>