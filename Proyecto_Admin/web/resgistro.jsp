<%-- 
    Document   : resgistro
    Created on : May 14, 2015, 2:58:30 PM
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
        <form action="InsertImg" method="post">
            <div class="form-group"  >
                <label for="exampleInputFile">File input</label>
                <input type="text" id="nombre" name="nombre">
                <input type="file" id="exampleInputFile" name="file">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </body>
</html>
