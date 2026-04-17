<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hrconsultancy.model.Job" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin - Manage Jobs</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css?v=1">
</head>
<body>

<jsp:include page="/views/common/header.jsp" />

<div class="container" style="margin-top: 30px;">
    <h2>Manage Jobs</h2>
    <p>Admin can view all posted jobs here.</p>

    <div style="margin: 15px 0;">
        <a href="${pageContext.request.contextPath}/admin/jobs/add">Add New Job</a>
    </div>

    <table border="1" cellpadding="10" cellspacing="0" width="100%">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Company</th>
            <th>Location</th>
            <th>Salary</th>
            <th>Experience</th>
            <th>Description</th>
            <th>Created At</th>
            <th>Actions</th>
        </tr>

        <%
            List<Job> jobs = (List<Job>) request.getAttribute("jobs");
            if (jobs != null && !jobs.isEmpty()) {
                for (Job job : jobs) {
        %>
        <tr>
            <td><%= job.getId() %></td>
            <td><%= job.getTitle() %></td>
            <td><%= job.getCompanyName() %></td>
            <td><%= job.getLocation() %></td>
            <td><%= job.getSalary() %></td>
            <td><%= job.getExperienceRequired() %></td>
            <td><%= job.getDescription() %></td>
            <td><%= job.getCreatedAt() %></td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/jobs/edit?id=<%= job.getId() %>">Edit</a> |
                <a href="${pageContext.request.contextPath}/admin/jobs/delete?id=<%= job.getId() %>"
                   onclick="return confirm('Are you sure you want to delete this job?');">Delete</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="9" style="text-align:center;">No jobs found.</td>
        </tr>
        <%
            }
        %>
    </table>
</div>

<jsp:include page="/views/common/footer.jsp" />

</body>
</html>