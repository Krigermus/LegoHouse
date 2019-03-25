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
            <label>Length in dots</label>
            <input type="number" class="form-control" name="length" value="0" min="5">
        </div>
        <div class="form-group">
            <label>Width in dots</label>
            <input type="number" class="form-control" name="width" value="0" min="5">
        </div>
        <div class="form-group">
            <label>Height in dots</label>
            <input type="number" class="form-control" name="height" value="0" min="3">

            <table class="checkBoxes">
                <tr>
                    <td>
                        <div class="form-check">
                            <input type="checkbox" class="form-check-input" id="connectedPattern" name="connected" value="true">
                            <label class="form-check-label" for="connectedPattern">connected</label>
                        </div>
                    </td>
                    <td>
                        <div class="form-check">
                            <input type="checkbox" class="form-check-input" id="door" name="door" value="true">
                            <label class="form-check-label" for="door"> Door </label>
                        </div>
                    </td>
                    <td>
                        <div class="form-check">
                            <input type="checkbox" class="form-check-input" id="window" name="window" value="true">
                            <label class="form-check-label" for="window">Window</label>
                        </div>
                    </td>
                </tr>
            </table>
            <button type="submit" class="btn btn-primary" formaction="FrontController?command=createOrder">Place order</button>
    </form>
</div>
<% String error = (String) request.getAttribute("message");
    if (error != null) {
        out.println("<H2>Error!!</h2>" + error);
    }
%>
<%@include file = "../footer.jsp" %>

