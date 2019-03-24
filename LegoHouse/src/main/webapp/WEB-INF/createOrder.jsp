<%-- 
    Document   : createOrder
    Created on : 24-03-2019, 14:33:17
    Author     : Martin Frederiksen
--%>
<%@include file = "../header.jsp" %>
<div class="greyBox">
    <form id="createOrderForm" name="createOrder" method="POST">
        <h1>Place order</h1>
        <div class="form-group">
            <label>Length</label>
            <input type="number" class="form-control" name="length" placeholder="0">
        </div>
        <div class="form-group">
            <label>Width</label>
            <input type="number" class="form-control" name="width" placeholder="0">
        </div>
        <div class="form-group">
            <label>Height</label>
            <input type="number" class="form-control" name="height" placeholder="0">
        </div>
        <button type="submit" class="btn btn-primary" formaction="FrontController?command=createOrder">Place order</button>
    </form>
</div>
<% String error = (String) request.getAttribute("message");
    if (error != null) {
        out.println("<H2>Error!!</h2>" + error);
    }
%>
<%@include file = "../footer.jsp" %>

