<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.hrconsultancy.model.Service" %>

<%
    Service service = (Service) request.getAttribute("service");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Service</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css?v=1">
</head>
<body>

<jsp:include page="/views/common/header.jsp" />

<div class="container" style="margin-top:30px;">
    <h2>Edit Service</h2>

    <form action="${pageContext.request.contextPath}/admin/services/edit" method="post">

        <input type="hidden" name="id" value="<%= service.getId() %>">

        <input type="text" name="title" value="<%= service.getTitle() %>" required><br><br>

        <textarea name="description" required><%= service.getDescription() %></textarea><br><br>

        <button type="submit">Update Service</button>
    </form>
</div>

<jsp:include page="/views/common/footer.jsp" />

</body>
</html>