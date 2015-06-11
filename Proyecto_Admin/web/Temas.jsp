<%-- 
    Document   : Administracion
    Created on : May 8, 2015, 2:38:50 PM
    Author     : rubenp
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="com.proyecto.conexion.Conexion"%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
response.setHeader("Content-Type", "text/html; charset=windows-1252");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "Mon, 01 Jan 2001 00:00:01 GMT");
response.setHeader("Cache-Control", "no-store");

HttpSession actual= request.getSession(true);
String id=actual.getId();
String nombre= (String)actual.getAttribute("logueado");

if (actual.isNew()){
response.sendRedirect("login.jsp");
}
if (actual==null){
    response.sendRedirect("login.jsp");
}else{
    if(actual.getAttribute("logueado")==null){
        response.sendRedirect("login.jsp");
    }

}

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <title>JSP Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/docs.css" rel="stylesheet" type="text/css"/>
        <link href="css/apprise.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/jquery.fancybox.css?v=2.1.5" type="text/css" media="screen" />
        
        <script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="js/ConfigTabla.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/jquery.fancybox.pack.js?v=2.1.5"></script>
        <script src="js/apprise.js" type="text/javascript"></script>
        
        <script type="text/javascript">
	$(document).ready(function() {
		$(".fancybox").fancybox();
	});
        </script>
        
    </head>
    <body>        
        <div class="container">
                <nav class="navbar navbar-default navbar-fixed-top">
                    <div class="container">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="logo" href="Home.jsp" title="Pruebas Pagina Proyecto"><img src="img/mslogo.png" class="img-responsive logos" alt="Responsive image"></a>
                        </div>
                        <div id="navbar" class="navbar-collapse collapse">
                            <ul class="nav navbar-nav navbar-right">
				
                                <li><a href="logout.jsp">Salir</a></li>	
                            </ul>
                            <ul class="nav navbar-nav visible-xs">
				<li class="active"><a href="">Inicio</a></li>
				<li><a href="cursos.jsp">Cursos</a></li>
                                
                            </ul>
                        </div>
                    </div>
                </nav>
        </div>
        <div class="container">
            <div class="col-xs-6 col-md-4">
                
                <ul class="nav nav-pills nav-stacked bs-docs-sidenav affix">
                    <li><a href="Administracion.jsp">Inicio</a></li>
                    <li ><a href="Banner.jsp">Banner</a></li>
                    <li ><a href="Programas.jsp">Programas</a></li>
                    <li class="active"><a href="#">Cursos</a></li>
                    <li><a href="Reportes.jsp">Reporte</a></li>
                </ul>
                
            </div>
            <div class="col-xs-12 col-md-8">
                <div class="content_Datos">
                    <div class="title">
                        <h3>Panel de Administración<br><small>Administracion de Cursos</small></h3>
                    </div>
                    <div class="row contentOptions">
                        <div class="btn-group" role="group">
                            <a class="fancybox fancybox.iframe" href="AddCurso.jsp"><button type="button" class="btn btn-default">Agregar</button></a>
                            <a><button type="button" id="btnAgregarColumna" class="btn btn-default" onclick="ColumnEliminarCurso();">Eliminar</button></a>
                            <a><button type="button" class="btn btn-default" onclick="ColumnModificar('Temas');">Modificar</button></a>
                        </div>
                    </div>
                    <div class="content_tabla">
                        <table class="table table-bordered" id="tabla" style="margin: 0 auto;">
                            <%
                            out.println("<thead>");
                            out.println("<tr>");
                            out.println("<th>Id</th>");
                            out.println("<th>Programa Pertenece</th>");
                            out.println("<th>Costo</th>");
                            out.println("<th>Descripcion</th>");
                            out.println("<th>Titulo</th>");
                            //out.println("<th>Imagen</th>");
                            //out.println("<th>Descripcion</th>");
                            out.println("</tr>");
                            out.println("</thead>");
                            Conexion c=new Conexion();
                            ResultSet rs2=c.getTemas();
                            out.println("<tbody>");
                            while(rs2.next())
                            {   
                                out.println("<tr>");
                                out.println("<td>"+rs2.getInt("IdTemas")+"</td>");
                                out.println("<td>"+rs2.getString("TituloCurso")+"</td>");
                                out.println("<td>"+rs2.getString("Costo") +"</td>");
                                out.println("<td>"+rs2.getString("Descripcion") +"</td>");
                                out.println("<td>"+rs2.getString("Titulo") +"</td>");
                                //out.println("<td> <input type='button' id='submit2' value='Ver Img'></td>");
                                
                                
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                            %>
                        </table>
                    </div>
                </div>
            </div>    
        </div>
        
    </body>
</html>
