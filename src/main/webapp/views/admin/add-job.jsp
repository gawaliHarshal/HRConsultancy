<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Job</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css?v=1">
</head>
<body>

<jsp:include page="/views/common/header.jsp" />

<div class="container" style="margin-top: 30px;">
    <h2>Add New Job</h2>

    <% if ("1".equals(request.getParameter("error"))) { %>
        <p style="color:red;">Failed to add job.</p>
    <% } %>

    <form action="${pageContext.request.contextPath}/admin/jobs/add" method="post">

        <input type="text" name="title" placeholder="Job Title" required><br><br>
        <input type="text" name="companyName" placeholder="Company Name" required><br><br>
        <input type="text" name="location" placeholder="Location" required><br><br>
        <input type="text" name="salary" placeholder="Salary" required><br><br>
        <input type="text" name="experienceRequired" placeholder="Experience (e.g. 0.5 years)" required><br><br>

        <textarea name="description" placeholder="Job Description" required></textarea><br><br>

        <button type="submit">Add Job</button>
    </form>
</div>

<jsp:include page="/views/common/footer.jsp" />

</body>
</html>