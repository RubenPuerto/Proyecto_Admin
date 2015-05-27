

//$(document).ready(function() {
//    // Interceptamos el evento submit
//    $('#form').submit(function() {
//    // Enviamos el formulario usando AJAX
//    var IdItem=$("#Titulo").val();
//    var mail	= $("#IdVideo").val();
//    var IdCurso = $.get("IdCurso");
//    var Nombre = $("#Celular").val();
//    var Celular = $("#Nombre").val();
//    
//    
//    $.ajax({
//        type: 'POST',
//        url: "ActionServletGuardar",
//        data: {IdItem:IdItem,mail:mail,IdCurso:IdCurso,Nombre:Nombre,Celular:Celular},
//        // Mostramos un mensaje con la respuesta de servlet
//        success: function (data) {
//                document.getElementById('mail').value = '';
//                document.getElementById('Celular').value = '';
//                document.getElementById('Nombre').value = '';
//                apprise("Se Guardo")
//        }
//        })        
//        return false;
//    
//    
//    }); 
//    
//});