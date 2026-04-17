<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.hrconsultancy.model.Job" %>

<%
    Job job = (Job) request.getAttribute("job");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Job</title>
</head>
<body>

<jsp:include page="/views/common/header.jsp" />

<h2>Edit Job</h2>

<form action="${pageContext.request.contextPath}/admin/jobs/edit" method="post">

    <input type="hidden" name="id" value="<%= job.getId() %>">

    <input type="text" name="title" value="<%= job.getTitle() %>" required><br><br>
    <input type="text" name="companyName" value="<%= job.getCompanyName() %>" required><br><br>
    <input type="text" name="location" value="<%= job.getLocation() %>" required><br><br>
    <input type="text" name="salary" value="<%= job.getSalary() %>" required><br><br>
    <input type="text" name="experienceRequired" value="<%= job.getExperienceRequired() %>" required><br><br>

    <textarea name="description"><%= job.getDescription() %></textarea><br><br>

    <button type="submit">Update Job</button>
</form>

</body>
</html>