<%-- 
    Document   : header
    Created on : 24-03-2019, 13:22:25
    Author     : Martin Frederiksen
--%>

<%@page import="Model.Models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    HttpSession headerSession = request.getSession();
    User u = (User) headerSession.getAttribute("user");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
        <title>LegoHouse</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">

            

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <%if (u == null) {%>
                    <a class="navbar-brand" href="index.jsp"></a>
                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp"><i class="fas fa-sign-in-alt"></i> Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="register.jsp"><i class="fas fa-user"></i> Register</a>
                    </li>
                    <%} else if (u.getRole().toString().equals("CUSTOMER")) {%>
                    <a class="navbar-brand" href="FrontController?command=showOrders"></a>
                    <li class="nav-item">
                        <a class="nav-link" href="FrontController?command=createOrder">Create Order</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="FrontController?command=showOrders">Show Orders </a>
                    </li>
                    <%} else if (u.getRole().toString().equals("EMPLOYEE")) {%>
                    <a class="navbar-brand" href="FrontController?command=showOrders"></a>
                    <li class="nav-item">
                        <a class="nav-link" href="FrontController?command=showOrders">Show Orders </a>
                    </li>
                    <%}%>
                    <li class="nav-item">
                        <a class="nav-link" href="FrontController?command=logout"><i class="fas fa-sign-out-alt"></i> Logout</a>
                    </li>
                </ul>
            </div>
        </nav>