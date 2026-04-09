<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hrconsultancy.model.Job" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Job Openings</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css?v=1">
</head>
<body>

    <jsp:include page="/views/common/header.jsp" />

    <section class="jobs-section">
        <div class="container">
            <h2>Available Job Openings</h2>
            <p>Explore current opportunities and apply as a candidate.</p>

            <% String applied = request.getParameter("applied"); %>
            <% if ("1".equals(applied)) { %>
                <p style="color: green;">Job application submitted successfully.</p>
            <% } %>

            <% String error = request.getParameter("error"); %>
            <% if ("1".equals(error)) { %>
                <p style="color: red;">Failed to apply for job.</p>
            <% } %>

            <%
                List<Job> jobs = (List<Job>) request.getAttribute("jobs");
                if (jobs != null && !jobs.isEmpty()) {
                    for (Job job : jobs) {
            %>
                <div class="job-card" style="border:1px solid #ccc; padding:15px; margin-bottom:15px;">
                    <h3><%= job.getTitle() %></h3>
                    <p><strong>Company:</strong> <%= job.getCompanyName() %></p>
                    <p><strong>Location:</strong> <%= job.getLocation() %></p>
                    <p><strong>Salary:</strong> <%= job.getSalary() %></p>
                    <p><strong>Experience:</strong> <%= job.getExperienceRequired() %></p>
                    <p><strong>Description:</strong> <%= job.getDescription() %></p>

                    <form action="${pageContext.request.contextPath}/apply-job" method="post" style="margin-top:10px;">
                        <input type="hidden" name="jobId" value="<%= job.getId() %>">

                        <label>Candidate ID:</label>
                        <input type="number" name="candidateId" required>

                        <button type="submit">Apply Now</button>
                    </form>
                </div>
            <%
                    }
                } else {
            %>
                <p>No job openings available at the moment.</p>
            <%
                }
            %>
        </div>
    </section>

    <jsp:include page="/views/common/footer.jsp" />

</body>
</html>