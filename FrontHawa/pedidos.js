$(document).ready(function() {
   tablaPedidos();
});

// listar pedidos
function tablaPedidos(){
   $.ajax({
      method: 'get',
      url:'http://localhost:9001/pedido/listar',
      contentType: 'application/json; charset=UTF-8',
      dataType:'json',

      success:function(response){
         console.log('Recibiendo respuesta'+JSON.stringify(response));

         var pedidos = '';
         response.forEach(objetos=>{
            console.log('ForEach'+JSON.stringify(objetos));

             pedidos += '<tr>'+
            '<td>'+objetos.codigo+'</td>'+
            '<td>'+objetos.marca+'</td>'+
            '<td>'+objetos.estatus+'</td>'+
            '<td>'+objetos.cantidad+'</td>'+
            '<td>'+objetos.fecha_creacion+'</td>'+
            '<td><a class="btn btn-outline-primary" id="btnAbrirPedido" data="'+objetos.codigo+'" idAuto="'+objetos.listcamioneta+'"></a>Pedido</td>'+
            '<td><a class="btn btn-outline-info"></a></td>'+
            '<td><a class="btn btn-outline-warning"></a>Editar</td>'+
            '<td><a class="btn btn-outline-success"></a>Eliminar</td>'+
            '<tr>';
         })
         $('#tablaPedidos').html(pedidos);
      }
   });
}

// guardar pedido

$('#abrirPedido').click(function(){
   $('#modalAgregarPedido').modal('show');
});

$('#btnGuardarPedido').click(function(){
     
     var nombre=$('#nombrec').val();
     /*
     console.log("nombrec->"+nombre);

     var json ={
      nombre:$('#nombrec').val(),
     };
     {
         atributo:valor --> JSON -> es la forma de como java script maneja sus objetos 
      }
     */

     var json ={
      nombrec:nombre

     }
     
     console.log("json->"+JSON.stringify(json));
     $.ajax({
      // metodo 
      method:'post',
      // url 
      url:'http://localhost:9001/pedido/guardar',
      data:JSON.stringify(json),
      // contenido 
      contentType:'application/json; charset-utf-8',
      // tipo de dato 
      dataType:'json',

      success:function(response){
         Swal.fire(
           'Guardado!',
           'Pedido Registrado con exito!',
           'success'
         )
         setTimeout('location.reload()',1500);
      },
      error:function(response){  
          //alert(response.responseJSON.message);
         Swal.fire(
           'Error!',
           // biene del servidor
           response.responseJSON.message,
           'error'
         )
      }

     });
 });


// agregrar pedido 
$('#tablaPedidos').on('click','#btnAbrirPedido',function(){

   $('#modalPedido').modal('show');
   var codigo = $(this).attr('data');
   $('#codigo').val(codigo);


         $.ajax({
            // metodo a utilizar para consumir una web service
      method: 'get',
      // url --> del recurso a consumir
      url:'http://localhost:9001/camioneta/listar',
      // web service de tipo rest --> aplicacion/JSON 
      contentType:'application/json; charset= utf-8',
      // el tipo de datos a consumir es JSON 
      dataType:'JSON',

      success : function(respuesta){
           var select = $('#auto');
         respuesta.forEach(autos =>{
            console.log("Recibiendo autos -> "+JSON.stringify(respuesta));    
            var hawa =  autos.hawa;
              $('#auto1').val(autos.hawa);
            // selectStatus 
            var elementos = $('<option>').val(hawa).text(JSON.stringify("Modelo: "+ autos.modelo+"Marca: "+ autos.marca+"Precio: "+ autos.precio));
            select.append(elementos);   


         });         
          
       }
      });  

});