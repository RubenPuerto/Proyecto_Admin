function ColumnEliminarItem() {
    $.post('EliminarItem', {
    
    }, function(responseText) {
    $('#tabla').html(responseText);
    });
}

function EliminarItem($valor) {
  apprise('Desea Eliminar Este Item?', {'verify':true}, function(r) {
    if(r) {
   $.post('Eliminar', {
    id : $valor
    }, function(responseText) {
    $('#tabla').html(responseText);
    });
    } 
  });
}


function ColumnEliminarCurso() {
    $.post('ColumnEliminarCurso', {
    
    }, function(responseText) {
    $('#tabla').html(responseText);
    });
}

function EliminarCurso($valor) {
  apprise('Desea Eliminar Este Item?', {'verify':true}, function(r) {
    if(r) {
   $.post('EliminarCurso', {
    id : $valor
    }, function(responseText) {
    $('#tabla').html(responseText);
    });
    } 
  });
}



function ColumnEliminarBanner() {
    $.post('ColumnEliminarBanner', {
    
    }, function(responseText) {
    $('#tabla').html(responseText);
    });
}

function EliminarBanner($valor) {
  apprise('Desea Eliminar Este Item?', {'verify':true}, function(r) {
    if(r) {
   $.post('EliminarBanner', {
    id : $valor
    }, function(responseText) {
    $('#tabla').html(responseText);
    });
    } 
  });
}

function ColumnModificar($valor) {
    $.post('ColumnaModificar', {
    Valor : $valor
    }, function(responseText) {
    $('#tabla').html(responseText);
    });
}

function GuardarRegistro($valor) {
    $.post('Eliminar', {
    id : $valor
    }, function(responseText) {
    $('#tabla').html(responseText);
    });
}

function LeerIdCurso($valor) {
    $.post('CapturarCursos', {
    id : $valor
    }, function(responseText) {
    $('.Content_Select_Cursos').html(responseText);
    });
    
}

function miFuncion() {
     apprise("Se Guardo")
    
}

       