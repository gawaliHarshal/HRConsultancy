<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hrconsultancy.model.ContactMessage" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Contact Messages</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css?v=1">
</head>
<body>

    <h2>Contact Messages</h2>

    <%
        List<ContactMessage> messages = (List<ContactMessage>) request.getAttribute("messages");
        if (messages != null && !messages.isEmpty()) {
    %>

    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Message</th>
            <th>Created At</th>
        </tr>

        <%
            for (ContactMessage msg : messages) {
        %>
        <tr>
            <td><%= msg.getId() %></td>
            <td><%= msg.getName() %></td>
            <td><%= msg.getEmail() %></td>
            <td><%= msg.getMessage() %></td>
            <td><%= msg.getCreatedAt() %></td>
        </tr>
        <%
            }
        %>
    </table>

    <%
        } else {
    %>
        <p>No contact messages found.</p>
    <%
        }
    %>

</body>
</html>