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
			<th>Update</th>
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

			<td>
			    <form action="${pageContext.request.contextPath}/admin/applications/update-status" method="post">
			        <input type="hidden" name="id" value="<%= app.getId() %>">
			
			        <select name="status">
			            <option value="Pending" <%= "Pending".equals(app.getApplicationStatus()) ? "selected" : "" %>>Pending</option>
			            <option value="Shortlisted" <%= "Shortlisted".equals(app.getApplicationStatus()) ? "selected" : "" %>>Shortlisted</option>
			            <option value="Rejected" <%= "Rejected".equals(app.getApplicationStatus()) ? "selected" : "" %>>Rejected</option>
			            <option value="Selected" <%= "Selected".equals(app.getApplicationStatus()) ? "selected" : "" %>>Selected</option>
			        </select>
			
			        <button type="submit">Update</button>
			    </form>
			</td>
			
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