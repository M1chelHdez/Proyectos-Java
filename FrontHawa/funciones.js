 $(document).ready(function() // cuando el DOM este listo -> quiero que realices una funcion -> 
 {
 	//alert("Hola desde java script!!!!!!");
tablaAutos();
 });

// funcion --> para consumir la lista de autos 

/* Cliente - Servidor 
  Cliente -> peticion -> $.ajax({ es la metodologia que se utiliza para la comunicacion con el cliente y el servidor
  })

*/

function tablaAutos(){
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
			//console.log("Recibiendo la respuesta del servidor "+JSON.stringify(respuesta));

			var lista = '';
			respuesta.forEach(autos =>{
				console.log("Recibiendo con forEach -> "+JSON.stringify(autos));

				// pasarlos a la lista --> muchos objeto 
				lista += '<tr>'+
				             '<td class="text-center">'+autos.hawa+'</td>'+
				             '<td class="text-center">'+autos.marca+'</td>'+
				             '<td class="text-center">'+autos.modelo+'</td>'+
				             '<td class="text-center">'+autos.anio+'</td>'+
				             '<td class="text-center">'+autos.precio+'</td>'+
				             '<td class="text-center">'+autos.stock+'</td>'+
				             '<td class="text-center">'+autos.descuento+'</td>'+

				             '<td class="text-center"><a class="btn btn-warning" id="abrirEditar" data="'+autos.hawa+'"><i class="fa fa-refresh" aria-hidden="true"></i> Editar</a></td>'+
				             '<td class="text-center"><a class="btn btn-danger btn-danger" idEliminar="'+autos.hawa+'" data="'+autos.hawa+'"><i class="fa fa-trash" aria-hidden="true"></i> Eliminar</a></td>'+
				         '</tr>';


		 });

			$('#tabla').html(lista);


	  }
  });

}

// funciones --> abrir el modal 
$('#btnAbrirGuardar').click(function(){
	$('#modalAgregar').modal('show');
});

// programar el bton guardar 
$('#btnGuardar').click(function(){
	var marca =$('#marca').val();
	var modelo =$('#modelo').val();
	var anio =$('#anio').val();
	var precio =$('#precio').val();
	var stock =$('#stock').val();
	var descuento =$('#descuento').val();
  /*
  console.log("marca->"+marca);
  console.log("modelo->"+modelo);
  console.log("anio->"+anio);
  console.log("precio->"+precio);
  console.log("stock->"+stock);
  console.log("descuento->"+descuento);*/

  var json = {
        marca:$('#marca').val(),
	      modelo:$('#modelo').val(),
	      anio:parseInt($('#anio').val()),
	      precio:parseFloat($('#precio').val()),
	      stock:parseInt($('#stock').val()),
	     descuento:parseInt($('#descuento').val()),

  };
  // convertir el objeto -> camioneta en formato JSON --> se lo vamos a mandar al servidor desdeuna web service -> Rest
  console.log("Enviando el objeto al servidor "+JSON.stringify(json));

  // utilizando una metodologia de cominicacion -> ajax --> para enviarlo al servidor 

   $.ajax({
   	// metodo a utilizar para consumir una web service
		method: 'post',
		// url --> del recurso a consumir
		url:'http://localhost:9001/camioneta/guardar',
		// tipo de dato a enviar 
		data:JSON.stringify(json),
		// web service de tipo rest --> aplicacion/JSON 
		contentType:'application/json; charset= utf-8',
		// el tipo de datos a consumir es JSON 
		dataType:'JSON',

		// enviar al servidor 
		success:function(respuesta){
     console.log("Enviando una camioneta al servidor "+respuesta);     
			if(respuesta.action == true){	
			console.log("resultado.action  ->"+JSON.stringify(respuesta.action));		
				Swal.fire({
					icon: 'success',
					title:'Se guardo la camioneta con exito!',
					showConfirmButton: false,
					timer: 2000
				});
				setTimeout('location.reload()',1500);
			}
		},
		error:function(resultado){		
				Swal.fire({
					icon: 'error',
					title:'!Error al guardar la camioneta!',
					showConfirmButton: true,
					confirmButtonText: 'Cerrar',				
				});								
	   	}
   });
});


// eliminar --> eliminar directo --> dentro de la tabla.on
$('#tabla').on('click','.btn-danger',function(){

	var hawaEliminar = $(this).attr('data');
	console.log("hawaEliminar->"+hawaEliminar);

	var json = {
		hawa:hawaEliminar
		};
		/*
		JSON --> es forma de como java script maneja sus objetos 
		{
	   atributo:valor 
	   "hawa":'22222'
		}
		*/
		console.log("hawaEliminar->"+JSON.stringify(json));
		Swal.fire({
				  title: '¿Desea eliminar?',
				  text: "Confime la accion",
				  type: 'btn-warning',
				  showCancelButton: true,
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  cancelButtonText: 'Cancelar',
				  confirmButtonText: 'Eliminar'
				}).then(function(respuesta){
					if(respuesta.isConfirmed){
						$.ajax({
								// metodo a utilizar para consumir una web service
								method: 'post',
								// url --> del recurso a consumir
								url:'http://localhost:9001/camioneta/eliminar',
								// tipo de dato a enviar 
								data:JSON.stringify(json),
								// web service de tipo rest --> aplicacion/JSON 
								contentType:'application/json; charset= utf-8',							

								success:function(respuesta){
									      Swal.fire({
														icon: 'success',
														title:'Se elimino la camioneta con exito!',
														showConfirmButton: false,
														timer: 2000
													});
				                setTimeout('location.reload()',1500);
								},
							  	error:function(){		
										Swal.fire({
											icon: 'error',
											title:'!No es posible eliminar, Status: ¡PENDIENTE!',
											showConfirmButton: true,
											confirmButtonText: 'Cerrar',				
										});								
							   	}
						});
					}
		});
});

// editar para editar --> primero hay que buscar el objeto a editar 

$('#tabla').on('click','#abrirEditar',function(){
var hawaEditar = $(this).attr('data');
console.log("hawa editar->"+hawaEditar);
//$('#modalEditar').modal('show'); --> es solo par aver que funcione mi modal 

// preparando el objeto en formato JSON 
var json = {
	hawa:hawaEditar
};
console.log("hawa editar->"+JSON.stringify(json));

        $.ajax({
   	    // metodo a utilizar para consumir una web service
				method: 'post',
				// url --> del recurso a consumir
				url:'http://localhost:9001/camioneta/buscarId',
				// tipo de dato a enviar 
				data:JSON.stringify(json),
				// web service de tipo rest --> aplicacion/JSON 
				contentType:'application/json; charset= utf-8',	
				dataType:'JSON',

				success:function(respuesta){
					console.log("Reciendo el objeto a editar->"+JSON.stringify(respuesta));
					$('#modalEditar').modal('show'); 
					$('#hawaU').val(respuesta.hawa);
					$('#marcaU').val(respuesta.marca);
					$('#modeloU').val(respuesta.modelo);
					$('#anioU').val(respuesta.anio);
					$('#precioU').val(respuesta.precio);
					$('#stockU').val(respuesta.stock);
					$('#descuentoU').val(respuesta.descuento);


				}


     });

});

// programar el btn Editar 
$('#btnEditar').click(function(){

	var json = {
		    hawa:$('#hawaU').val(),
        marca:$('#marcaU').val(),
	      modelo:$('#modeloU').val(),
	      anio:parseInt($('#anioU').val()),
	      precio:parseFloat($('#precioU').val()),
	      stock:parseInt($('#stockU').val()),
	     descuento:parseInt($('#descuentoU').val()),

  };
  console.log("Reciendo el objeto a editar->"+JSON.stringify(json));

  $.ajax({
  	    // metodo a utilizar para consumir una web service
				method: 'post',
				// url --> del recurso a consumir
				url:'http://localhost:9001/camioneta/editar',
				// tipo de dato a enviar 
				data:JSON.stringify(json),
				// web service de tipo rest --> aplicacion/JSON 
				contentType:'application/json; charset= utf-8',				

       success:function(respuesta){
     	console.log("respuesta.editar ->"+JSON.stringify(respuesta.hawa));   	

     		Swal.fire({
					icon: 'success',
					title:'Se guardo la camioneta con exito!',
					showConfirmButton: false,
					timer: 2000
				});
				setTimeout('location.reload()',1500);
     		  
     },
      error:function(){		
				Swal.fire({
					icon: 'error',
					title:'!No es posible eliminar, Status: ¡PENDIENTE!',
					showConfirmButton: true,
					confirmButtonText: 'Cerrar',				
				});								
	    }   
    });
});
