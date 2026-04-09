<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hrconsultancy.model.Candidate" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registered Candidates</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css?v=1">
</head>
<body>

    <h2>Registered Candidates</h2>

    <%
        List<Candidate> candidates = (List<Candidate>) request.getAttribute("candidates");
        if (candidates != null && !candidates.isEmpty()) {
    %>

    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Qualification</th>
            <th>Experience</th>
            <th>Skills</th>
            <th>Created At</th>
        </tr>

        <%
            for (Candidate candidate : candidates) {
        %>
        <tr>
            <td><%= candidate.getId() %></td>
            <td><%= candidate.getFullName() %></td>
            <td><%= candidate.getEmail() %></td>
            <td><%= candidate.getPhone() %></td>
            <td><%= candidate.getQualification() %></td>
            <td><%= candidate.getExperienceYears() %></td>
            <td><%= candidate.getSkills() %></td>
            <td><%= candidate.getCreatedAt() %></td>
        </tr>
        <%
            }
        %>
    </table>

    <%
        } else {
    %>
        <p>No candidates found.</p>
    <%
        }
    %>

</body>
</html>