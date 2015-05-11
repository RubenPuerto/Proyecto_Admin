function valida_envia(){
        
   	if (document.fvalida.usuario.value.length==0)
        {
            alert("usuario no puede quedar en blanco")
            document.fvalida.usuario.focus()
            document.fvalida.usuario.value = ""
            
	}
        if (document.fvalida.pass.value.length==0)
        {
            alert("contraseña no puede quedar en blanco")
            document.fvalida.pass.focus()
            document.fvalida.pass.value = ""
            
	}
//el formulario se envia si todo esta correcto
	document.fvalida.submit();
}


