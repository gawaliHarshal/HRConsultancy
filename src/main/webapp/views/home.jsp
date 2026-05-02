<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css?v=2">

<!-- HERO -->
<section class="hero" id="home">
    <div class="container">
        <h1>
            Find the right talent, <span>faster</span>
        </h1>
        <p>
            We connect companies with skilled professionals across industries,
            making hiring simple, fast, and reliable.
        </p>

        <a href="#services" class="btn">Explore Services</a>
    </div>
</section>

<!-- ABOUT -->
<section id="about" class="section">
    <div class="container">
        <h2>About Us</h2>
        <p>
            We help businesses hire the right people and help candidates find
            the right career opportunities through reliable recruitment and HR support.
        </p>
    </div>
</section>

<!-- SERVICES -->
<section id="services" class="section light-section">
    <div class="container">
        <h2>Our Services</h2>

        <div class="service-grid">
            <%
                java.util.List<com.hrconsultancy.model.Service> serviceList =
                    (java.util.List<com.hrconsultancy.model.Service>) request.getAttribute("serviceList");

                if (serviceList != null) {
                    for (com.hrconsultancy.model.Service service : serviceList) {
            %>
                <div class="service-card">
                    <h3><%= service.getTitle() %></h3>
                    <p><%= service.getDescription() %></p>
                </div>
            <%
                    }
                }
            %>
        </div>
    </div>
</section>

<!-- JOBS PREVIEW -->
<section id="jobs" class="section">
    <div class="container">
        <h2>Latest Jobs</h2>
        <p>Explore opportunities curated for you.</p>

        <div style="margin-top:20px;">
            <a href="${pageContext.request.contextPath}/jobs" class="btn">
                View All Jobs
            </a>
        </div>
    </div>
</section>

<!-- CONTACT -->
<section id="contact" class="section light-section">
    <div class="container">
        <h2>Contact Us</h2>

        <%
            String success = request.getParameter("success");
            String error = request.getParameter("error");
            if ("1".equals(success)) {
        %>
            <p class="alert-success">Message sent successfully.</p>
        <%
            } else if ("1".equals(error)) {
        %>
            <p class="alert-error">Something went wrong. Please try again.</p>
        <%
            }
        %>

        <form action="${pageContext.request.contextPath}/contact" method="post" class="contact-form">
            <input type="text" name="name" placeholder="Enter your name" required>
            <input type="email" name="email" placeholder="Enter your email" required>
            <textarea name="message" rows="5" placeholder="Enter your message" required></textarea>

            <button type="submit">Send Message</button>
        </form>
    </div>
</section>

<%@ include file="/views/common/footer.jsp" %>