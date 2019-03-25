<%-- 
    Document   : partList
    Created on : 24-03-2019, 21:04:55
    Author     : Martin Frederiksen
--%>

<%@page import="java.util.Map"%>
<%@page import="Model.Models.Order"%>
<%@include file = "../header.jsp" %>
<%
    Map<String, Integer> bricks = (Map<String, Integer>) session.getAttribute("bricks");
    Order order = (Order) session.getAttribute("order");
%>


<div class="orderBox">
    <h1>Parts for order <%= order.getOrderId()%> </h1> 
    <table class="table">
        <thead class="thead-light">
            <tr>
                <th scope="col">Type</th>
                <th scope="col">Side1</th>
                <th scope="col">Side2</th>
                <th scope="col">Side3</th>
                <th scope="col">Side4</th>
                <th scope="col">Total</th>
                <th scope="col">Total x Height</th>
                <th scope="col">Connected</th>
                <th scope="col">Door</th>
                <th scope="col">Window</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <th scope="col">4x2</th>
                <th scope="col"><%= bricks.get("4x2A")%></th>
                <th scope="col"><%= bricks.get("4x2B")%></th>
                <th scope="col"><%= bricks.get("4x2C")%></th>
                <th scope="col"><%= bricks.get("4x2D")%></th>
                <th scope="col"><%= bricks.get("4x2Total")%></th>
                <th scope="col"><%= bricks.get("4x2Height")%></th>
                <th scope="col"><%= order.isConnected()%></th>
                <th scope="col"><%= order.isDoor()%></th>
                <th scope="col"><%= order.isWindow()%></th>
            </tr>
            <tr>
                <th scope="col">2x2</th>
                <th scope="col"><%= bricks.get("2x2A")%></th>
                <th scope="col"><%= bricks.get("2x2B")%></th>
                <th scope="col"><%= bricks.get("2x2C")%></th>
                <th scope="col"><%= bricks.get("2x2D")%></th>
                <th scope="col"><%= bricks.get("2x2Total")%></th>
                <th scope="col"><%= bricks.get("2x2Height")%></th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            <tr>
                <th scope="col">1x2</th>
                <th scope="col"><%= bricks.get("1x2A")%></th>
                <th scope="col"><%= bricks.get("1x2B")%></th>
                <th scope="col"><%= bricks.get("1x2C")%></th>
                <th scope="col"><%= bricks.get("1x2D")%></th>
                <th scope="col"><%= bricks.get("1x2Total")%></th>
                <th scope="col"><%= bricks.get("1x2Height")%></th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
        </tbody>
    </table>
</div>

<%@include file = "../footer.jsp" %>
