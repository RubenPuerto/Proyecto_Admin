<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload to Database Demo</title>
<script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>

</head>
<body>
    <center>
        <h1>File Upload to Database Demo</h1>
        <form id="my-form" method="post" action="UpImg" enctype="multipart/form-data">
                <input type="text" name="firstName" id="firstName" size="50"/>
                <br>
                Imagen Banner
                <input type="file" name="photo" id="photo" size="50"/>
                <br>
                <input type="submit" value="Save" id="btn_enviar">
        </form>
    </center>
</body>
</html>
