<%-- 
    Document   : AddBanner
    Created on : 18-may-2015, 15:49:22
    Author     : Ruben Puerto
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="com.proyecto.conexion.Conexion"%>
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
        <!--Estilos-->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        
        <!--JavaScript-->
        <script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <%  
            String Id = request.getParameter("IdCurso");
            //String Id = "1";
            Conexion c=new Conexion();
            ResultSet rs=c.getItemCursos(Id);
            while(rs.next()){
        %>
        <form id="form" method="post" action="UpdateItems" enctype="multipart/form-data">
            <div class="form-group">
                <label for="Nombre">Id Programa</label>
                <input type="Text" readonly="readonly" class="form-control" name="IdPrograma"  value="<%out.println(rs.getInt("IdCurso"));%>" >
            </div>
            <div class="form-group">
                <label for="Nombre">Titulo Programa</label>
                <input type="Text" class="form-control" name="Titulo"  value="<%out.println(rs.getString("TituloCurso"));%>" >
            </div>
            <div class="form-group">
                <label for="exampleInputFile">Imagen Programa Home</label>
                <input type="file" name="PhotoHome">
            </div>
            <div class="form-group">
                <label for="LabelUrl">Id Video</label>
                <input type="text" class="form-control" name="IdVideo" value="<%out.println(rs.getString("IdVideo"));%>">
            </div>
            <div class="form-group">
                <label for="LabelUrl">Descripcion Programa</label>
                <input type="text" class="form-control" name="Descripcion" value="<%out.println(rs.getString("DescripcionCurso"));%>">
            </div>
            <div class="form-group">
                <label for="exampleInputFile">Imagen Programa Detalle Curso</label>
                <input type="file" name="PhotoDetalleCurso">
            </div>
            <button type="submit" class="btn btn-default">Actualizar</button>
        </form>
        <%
                        }
        %>
    </body>
</html>
