<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Service</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css?v=1">
</head>
<body>

<jsp:include page="/views/common/header.jsp" />

<div class="container" style="margin-top:30px;">
    <h2>Add Service</h2>

    <% if ("1".equals(request.getParameter("error"))) { %>
        <p style="color:red;">Failed to add service.</p>
    <% } %>

    <form action="${pageContext.request.contextPath}/admin/services/add" method="post">

        <input type="text" name="title" placeholder="Service Title" required><br><br>

        <textarea name="description" placeholder="Service Description" required></textarea><br><br>

        <button type="submit">Add Service</button>
    </form>
</div>

<jsp:include page="/views/common/footer.jsp" />

</body>
</html>