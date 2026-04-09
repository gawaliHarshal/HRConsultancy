<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Candidate Registration</title>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css"> 
  
</head>
<body>

    <jsp:include page="/views/common/header.jsp" />

    <section class="form-section">
        <div class="container">
            <h2>Candidate Registration</h2>
            <p>Fill in your details to apply for opportunities.</p>

            <% String success = request.getParameter("success"); %>
            <% if ("1".equals(success)) { %>
                <p style="color: green;">Registration submitted successfully.</p>
            <% } %>

            <% String error = request.getParameter("error"); %>
            <% if ("1".equals(error)) { %>
                <p style="color: red;">Something went wrong. Please try again.</p>
            <% } %>

            <form action="${pageContext.request.contextPath}/candidate/register" method="post">
                <div>
                    <label>Full Name</label>
                    <input type="text" name="fullName" required>
                </div>

                <div>
                    <label>Email</label>
                    <input type="email" name="email" required>
                </div>

                <div>
                    <label>Phone</label>
                    <input type="text" name="phone" required>
                </div>

                <div>
                    <label>Qualification</label>
                    <input type="text" name="qualification" required>
                </div>

                <div>
                    <label>Experience (Years)</label>
                    <input type="number" name="experienceYears" min="0" value="0" required>
                </div>

                <div>
                    <label>Skills</label>
                    <textarea name="skills" rows="4"></textarea>
                </div>

                <div>
                    <button type="submit">Register</button>
                </div>
            </form>
        </div>
    </section>

    <jsp:include page="/views/common/footer.jsp" />

</body>
</html>