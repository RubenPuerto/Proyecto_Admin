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
        <title>Agregar Curso</title>
        <!--Estilos-->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        
        <!--JavaScript-->
        <script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <form method="post" action="AddTema" enctype="multipart/form-data">
            <div class="form-group">
                <label for="Nombre">Categoria a la que pertenece</label>
                <select name="Cursos" id="Cursos" class="form-control" <!--onchange="LeerIdTema(value);"-->>
                    <option >Seleccione</option>
                        <%
                            Conexion c=new Conexion();
                            int value=0;
                            ResultSet rs=c.getCursos();
                            while (rs.next()){
                            value=rs.getInt("IdCurso");
                            out.println("<option value="+value+" >"+rs.getString("TituloCurso")+"</option>");
                            }
                        %>
                </select>
            </div>
            <div class="form-group">
                <label for="Nombre">Titulo Curso</label>
                <input type="Text" class="form-control" name="TituloTema" placeholder="" required>
            </div>
            <div class="form-group">
                <label for="Nombre">Descripcion Curso</label>
                <input type="Text" class="form-control" name="DescripcionTema" placeholder="" required>
            </div>
            <div class="form-group">
                <label for="Nombre">Costo Curso</label>
                <input type="Text" class="form-control" name="CostoTema" placeholder="" required>
            </div>
            <div class="form-group">
                <label for="exampleInputFile">Imagen Curso</label>
                <input type="file" name="PhotoTema" required>
            </div>
            <button type="submit" class="btn btn-default">Guardar</button>
        </form>
    </body>
</html>
