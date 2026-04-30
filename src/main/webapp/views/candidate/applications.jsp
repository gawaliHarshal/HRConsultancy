<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hrconsultancy.model.JobApplication" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Applications</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css?v=1">
</head>
<body>

<jsp:include page="/views/common/header.jsp" />

<div class="container" style="margin-top:30px;">
    <h2>My Applications</h2>

    <%
        List<JobApplication> applications =
            (List<JobApplication>) request.getAttribute("applications");

        if (applications != null && !applications.isEmpty()) {
    %>

    <table border="1" cellpadding="10" cellspacing="0" width="100%">
        <tr>
            <th>ID</th>
            <th>Job Title</th>
            <th>Status</th>
            <th>Applied At</th>
        </tr>

        <%
            for (JobApplication app : applications) {
        %>
        <tr>
            <td><%= app.getId() %></td>
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
        <p>You have not applied for any jobs yet.</p>
    <%
        }
    %>
</div>

<jsp:include page="/views/common/footer.jsp" />

</body>
</html>