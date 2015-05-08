<%-- 
    Document   : login
    Created on : 07-may-2015, 22:58:12
    Author     : RUBEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Admin</title>
      
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/admin.css" rel="stylesheet" type="text/css"/>
        
        <script src="js/ValidarUser.js" type="text/javascript"></script>
        
    </head>
    <body>
        <div class="container login">
           <!-- Acceso Panel de Gestión -->
            <div class="contentlogin">
                <form name="fvalida" action="Login" method="post">
                    <div class="form-group">
                        <label class="loginText" for="exampleInputEmail1">User</label>
                        <input type="text" name="usuario" class="form-control" id="user_admin" placeholder="Usuario">
                    </div>
                    <div class="form-group">
                      <label class="loginText" for="exampleInputPassword1">Password</label>
                      <input type="password" name="pass" class="form-control" id="user_admin" placeholder="Password">
                    </div>
                    <button type="submit" class="btn btn-default" onclick="valida_envia()">Enviar</button>
                </form>
            </div>
        </div>
    </body>
</html>
