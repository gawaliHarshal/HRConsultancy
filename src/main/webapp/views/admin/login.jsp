<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css?v=1">
   
</head>
<body>

<div class="container" style="margin-top:40px; max-width:500px;">
    <h2>Admin Login</h2>

    <% if ("1".equals(request.getParameter("error"))) { %>
        <p style="color:red;">Invalid admin username or password.</p>
    <% } %>

    <form action="${pageContext.request.contextPath}/admin/login" method="post">
        <input type="text" name="username" placeholder="Username" required><br><br>
        <input type="password" name="password" placeholder="Password" required><br><br>

        <button type="submit">Login</button>
    </form>
</div>

</body>
</html>