<%-- 
    Document   : GenerarReporte
    Created on : 30-may-2015, 22:22:38
    Author     : RUBEN
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="com.proyecto.conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP Page</title>
        <!--Estilos-->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/GenerarReporte.css" rel="stylesheet" type="text/css"/>
        
        <!--JavaScript-->
        <script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/ConfigTabla.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="content_Select">
            <div class="content_Select_Programas">
                <select name="Cursos" id="Cursos" class="form-control" onchange="LeerIdCurso(value);">
                    <option >Seleccione</option>
                        <%
                            Conexion c=new Conexion();
                            int value=0;
                            ResultSet rs2=c.getCursos();
                            while (rs2.next()){
                            value=rs2.getInt("IdCurso");
                            out.println("<option value="+value+" >"+rs2.getString("TituloCurso")+"</option>");
                            }
                        %>
                </select>
            </div>
            <div class="Content_Select_Cursos">
                
            </div>
        </div>
    </body>
</html>
