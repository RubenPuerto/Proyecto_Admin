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
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <title>Login Admin</title>
        <link href="css/admin.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        
        
        <script src="js/ValidarUser.js" type="text/javascript"></script>
        
    </head>
    <body>
        <div class = "container">
	<div class="wrapper">
		<form name="fvalida" action="LoginValidar" method="post" name="Login_Form" class="form-signin">       
		    <h3 class="form-signin-heading">Bienvenido! Por Favor Registrate</h3>
			  <hr class="colorgraph"><br>
			  
			  <input type="text" class="form-control" name="usuario" placeholder="Username" required="" autofocus="" />
			  <input type="password" class="form-control" name="pass" placeholder="Password" required=""/>     		  
			 
			  <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Login" type="Submit">Login</button>  			
		</form>			
	</div>
</div>
        
        
    </body>
</html>
