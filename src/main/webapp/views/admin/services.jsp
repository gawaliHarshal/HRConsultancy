<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hrconsultancy.model.Service" %>

<!DOCTYPE html>
<html>
<head>
    <title>Admin - Services</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css?v=1">
</head>
<body>

<jsp:include page="/views/common/header.jsp" />

<div class="container" style="margin-top:30px;">
    <h2>Manage Services</h2>

    <a href="${pageContext.request.contextPath}/admin/services/add">Add New Service</a>

    <table border="1" cellpadding="10" cellspacing="0" width="100%" style="margin-top:15px;">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Description</th>
            <th>Actions</th>
        </tr>

        <%
            List<Service> services = (List<Service>) request.getAttribute("services");

            if (services != null && !services.isEmpty()) {
                for (Service s : services) {
        %>
        <tr>
            <td><%= s.getId() %></td>
            <td><%= s.getTitle() %></td>
            <td><%= s.getDescription() %></td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/services/edit?id=<%= s.getId() %>">Edit</a> |
                <a href="${pageContext.request.contextPath}/admin/services/delete?id=<%= s.getId() %>"
                   onclick="return confirm('Delete this service?');">Delete</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="4" style="text-align:center;">No services found.</td>
        </tr>
        <%
            }
        %>
    </table>
</div>

<jsp:include page="/views/common/footer.jsp" />

</body>
</html>