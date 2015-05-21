<%-- 
    Document   : AddBanner
    Created on : 18-may-2015, 15:49:22
    Author     : Ruben Puerto
--%>

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
        <form method="post" action="AddBanner" enctype="multipart/form-data">
            <div class="form-group">
                <label for="Nombre">Nombre</label>
                <input type="Text" class="form-control" name="NombreBanner" placeholder="">
            </div>
            <div class="form-group">
                <label for="LabelUrl">Url</label>
                <input type="url" class="form-control" name="UrlBanner" placeholder="">
            </div>
            <div class="form-group">
                <label for="exampleInputFile">Imagen Banner</label>
                <input type="file" name="Photo">
            </div>
            <button type="submit" class="btn btn-default">Guardar</button>
        </form>
    </body>
</html>
