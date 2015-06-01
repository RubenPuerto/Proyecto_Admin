<%-- 
    Document   : ReCursosNuevos
    Created on : Jun 1, 2015, 10:34:29 AM
    Author     : alexanderls
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.proyecto.conexion.Conexion"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
     <form name="form1" method="post" action="REPORTENEWPEOPLE.jsp">
         <h1>Seleccion una Categoria<h1>
       <div class="content_Select">
            <div class="content_Select_Programas">
                <select name="txtidcliente2" id="Cursos" class="form-control" onchange="LeerIdCurso(value);">
                    <option >Seleccione Categoria</option>
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
    </form>
    </body>
</html>
