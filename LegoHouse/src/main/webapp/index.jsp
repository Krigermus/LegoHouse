<%-- 
    Document   : index
    Created on : 23-03-2019, 23:44:09
    Author     : Martin Frederiksen
--%>

<%@include file = "header.jsp" %>
<div class="greyBox">
    <form id="loginForm" name="login" method="POST">
        <h1>Login</h1>
        <div class="form-group">
            <label>Username</label>
            <input type="text" class="form-control" name="email" placeholder="Email..." maxlength="25">
        </div>
        <div class="form-group">
            <label>Password</label>
            <input type="password" class="form-control" name="password" placeholder="Password..."maxlength="25">
        </div><br />
        <button type="submit" class="btn btn-primary" formaction="FrontController?command=login">Login</button>
    </form>
</div>
<% String error = (String) request.getAttribute("message");
    if (error != null) {
        out.println("<H2>Error!!</h2>");
        out.println(error);
    }
%>
<%@include file = "footer.jsp" %>
