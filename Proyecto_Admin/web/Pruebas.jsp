<%-- 
    Document   : Pruebas
    Created on : 13-may-2015, 20:51:48
    Author     : RUBEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="UploadFile" method="post" enctype="multipart/form-data">
            <div class="form-group"  >
                <label for="exampleInputFile">File input</label>
                <input type="file" id="exampleInputFile" name="file">
                <p class="help-block">Example block-level help text here.</p>
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </body>
</html>
