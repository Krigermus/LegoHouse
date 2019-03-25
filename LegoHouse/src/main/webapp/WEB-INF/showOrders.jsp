<%-- 
    Document   : showOrders
    Created on : 24-03-2019, 14:49:49
    Author     : Martin Frederiksen
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Model.Models.Order"%>
<%@include file = "../header.jsp" %>

<%
    List<Order> orders = orders = (List<Order>) session.getAttribute("orders");
    User user = (User) session.getAttribute("user");
%>


<div class="orderBox">
    <table class="table">
        <thead class="thead-light">
            <tr>
                <th scope="col">OrderId</th>
                <th scope="col">Length</th>
                <th scope="col">Width</th>
                <th scope="col">Height</th>
                <th scope="col">Connected</th>
                <th scope="col">Door</th>
                <th scope="col">Window</th>
                <th scope="col">Shipped</th>
                <th scope="col">Parts</th>
            </tr>
        </thead>
        <tbody>
            <% for (Order o : orders) {%>
            <tr>
                <td><%= o.getOrderId()%></td>
                <td><%= o.getLength()%></td>
                <td><%= o.getWidth()%></td>
                <td><%= o.getHeight()%></td>
                <td><%= o.isConnected()%></td>
                <td><%= o.isDoor()%></td>
                <td><%= o.isWindow()%></td>
                <% if (u.getRole().toString().equals("EMPLOYEE") && !o.isShipped()) {%>
                <td>
                    <form id="shipForm" method="POST">
                        <input type="hidden" name="orderId" value="<%=o.getOrderId()%>">
                        <button type="submit" class="btn btn-primary" formaction="FrontController?command=shipOrder">ship</button>
                    </form>
                </td>
                <% } else if(o.isShipped()){%>
                <td><%=o.getShippingDate()%></td>
                <% } else {%>
                <td><%=o.isShipped()%></td>
                <% } %>
                <td>
                    <form id="balanceForm" method="POST">
                        <input type="hidden" name="orderId" value="<%=o.getOrderId()%>">
                        <button type="submit" class="btn btn-primary" formaction="FrontController?command=partList">parts</button>
                    </form>
                </td>
            </tr>
            <% }%>
        </tbody>
    </table>
</div>
<%@include file = "../footer.jsp" %>
