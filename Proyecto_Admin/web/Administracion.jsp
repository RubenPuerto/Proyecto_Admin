<%-- 
    Document   : Administracion
    Created on : May 8, 2015, 2:38:50 PM
    Author     : rubenp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            String user = (String)session.getAttribute("varUsuario");
            out.println(user);
        %>
    </body>
</html>
