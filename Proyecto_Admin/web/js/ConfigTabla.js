//$(function(){
////clic en el boton para agregar columnas
//$('#btnAgregarColumna').on('click',function(){
//var $objTabla=$('#tabla'),
////contamos la cantidad de columnas que tiene la tabla
//iTotalColumnasExistentes=$('#tabla thead tr th').length;
////aumentamos en uno el valor que contiene la variable
//iTotalColumnasExistentes++;
////agregamos una columna con el titulo (en thead)
//$('<th>').html('Eliminar').appendTo($objTabla.find('thead tr'));
////adjuntamos los td's de la columna al body de la tabla
//$('<td>').html('<input type="button"  value="Eliminar" id="EliminarBoton">').appendTo($objTabla.find('tbody tr'));
//});
//});
function ColumnEliminarItem() {
    $.post('EliminarItem', {
    
    }, function(responseText) {
    $('#tabla').html(responseText);
    });
}
function EliminarItem($valor) {
    $.post('Eliminar', {
    id : $valor
    }, function(responseText) {
    $('#tabla').html(responseText);
    });
}
       