<%-- 
    Document   : logout
    Created on : May 11, 2015, 4:16:26 PM
    Author     : rubenp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
response.setContentType("Content-Type");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
response.setHeader("Cache-Control", "no-store");

request.getSession().removeAttribute("logueado");

session.invalidate();


response.sendRedirect("login.jsp");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
