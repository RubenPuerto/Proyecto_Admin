<%-- 
    Document   : AddBanner
    Created on : 18-may-2015, 15:49:22
    Author     : Ruben Puerto
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
        
        <!--JavaScript-->
        <script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <%  
            String Id = request.getParameter("IdTema");
            //String Id = "1";
            Conexion c=new Conexion();
            ResultSet rs=c.getItemTemas(Id);
            while(rs.next()){
        %>
          <form method="post" action="UpdateTemas" enctype="multipart/form-data">
            <div class="form-group">
                <label for="Nombre">Id Curso</label>
                <input type="Text" class="form-control" name="IdTema" value="<%out.println(rs.getString("IdTemas"));%>" >
            </div>
            <div class="form-group">
                <label for="Nombre">Categoria a la que pertenece</label>
                <select name="Cursos" id="Cursos" class="form-control" <!--onchange="LeerIdTema(value);"-->>
                    <option >Seleccione</option>
                        <%
                            c=new Conexion();
                            int value=0;
                            ResultSet rs2=c.getCursos();
                            while (rs2.next()){
                            value=rs2.getInt("IdCurso");
                            out.println("<option value="+value+" >"+rs2.getString("TituloCurso")+"</option>");
                            }
                        %>
                </select>
            </div>
            <div class="form-group">
                <label for="Nombre">Titulo Curso</label>
                <input type="Text" class="form-control" name="TituloTema" value="<%out.println(rs.getString("Titulo"));%>" >
            </div>
            <div class="form-group">
                <label for="Nombre">Descripcion Curso</label>
                <input type="Text" class="form-control" name="DescripcionTema" value="<%out.println(rs.getString("Descripcion"));%>" >
            </div>
            <div class="form-group">
                <label for="Nombre">Costo Curso</label>
                <input type="Text" class="form-control" name="CostoTema" value="<%out.println(rs.getString("Costo"));%>">
            </div>
            <div class="form-group">
                <label for="exampleInputFile">Imagen Curso</label>
                <input type="file" name="PhotoTema">
            </div>
            <button type="submit" class="btn btn-default">Guardar</button>
        </form>
        <%
                        }
        %>
    </body>
</html>
