<%-- 
    Document   : register
    Created on : 24-03-2019, 14:56:20
    Author     : Martin Frederiksen
--%>

<%@include file = "header.jsp" %>
<div class="greyBox">
    <form id="registerForm" method="POST">
        <h1>Register</h1>
        <div class="form-group">
            <label>Email</label>
            <input type="email" class="form-control" name="email" placeholder="Email...">
        </div>
        <div class="form-group">
            <label>Password</label>
            <input type="password" class="form-control" name="password1" placeholder="Password...">
        </div>
        <div class="form-group">
            <label>Password</label>
            <input type="password" class="form-control" name="password2" placeholder="Password...">
        </div>
        <button type="submit" class="btn btn-primary" formaction="FrontController?command=register">Register</button>
    </form>
</div>
<% String error = (String) request.getAttribute("message");
    if (error != null) {
        out.println("<H2>Error!!</h2>");
        out.println(error);
    }
%>
<%@include file = "footer.jsp" %>
