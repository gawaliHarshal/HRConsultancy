<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css?v=2">
</head>
<body>

<jsp:include page="/views/common/header.jsp" />

<div class="container">

    <section class="section">
        <h2>Admin Dashboard</h2>
        <p>Manage recruitment system efficiently.</p>

        <!-- STATS -->
        <div class="service-grid" style="margin-top:30px;">

            <div class="service-card">
                <h3>Total Candidates</h3>
                <p style="font-size:24px; font-weight:bold;">
                    <%= request.getAttribute("candidateCount") %>
                </p>
            </div>

            <div class="service-card">
                <h3>Total Messages</h3>
                <p style="font-size:24px; font-weight:bold;">
                    <%= request.getAttribute("messageCount") %>
                </p>
            </div>

            <div class="service-card">
                <h3>Total Jobs</h3>
                <p style="font-size:24px; font-weight:bold;">
                    <%= request.getAttribute("jobCount") %>
                </p>
            </div>

            <div class="service-card">
                <h3>Total Applications</h3>
                <p style="font-size:24px; font-weight:bold;">
                    <%= request.getAttribute("applicationCount") %>
                </p>
            </div>

        </div>

        <!-- ACTIONS -->
        <div style="margin-top:40px; text-align:center;">

            <a href="${pageContext.request.contextPath}/admin/candidates" class="btn">
                Candidates
            </a>

            <a href="${pageContext.request.contextPath}/admin/messages" class="btn">
                Messages
            </a>

            <a href="${pageContext.request.contextPath}/admin/jobs" class="btn">
                Jobs
            </a>

            <a href="${pageContext.request.contextPath}/admin/services" class="btn">
                Services
            </a>

            <a href="${pageContext.request.contextPath}/admin/applications" class="btn">
                Applications
            </a>

            <a href="${pageContext.request.contextPath}/admin/logout" class="btn btn-danger">
                Logout
            </a>

        </div>

    </section>

</div>

<jsp:include page="/views/common/footer.jsp" />

</body>
</html>