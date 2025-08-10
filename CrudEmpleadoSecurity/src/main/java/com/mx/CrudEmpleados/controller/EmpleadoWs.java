package com.mx.CrudEmpleados.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CrudEmpleados.dominio.Empleado;
import com.mx.CrudEmpleados.dominio.Respuesta;
import com.mx.CrudEmpleados.servicio.Implementacion;

@RestController
@RequestMapping(path="EmpleadoWs")
@CrossOrigin
public class EmpleadoWs {

	@Autowired
	Implementacion imp;
	
	//http://localhost:9001/EmpleadoWs/listar
	@GetMapping(path="listar")
	public ResponseEntity<List<Empleado>> listar(){
		return ResponseEntity.status(HttpStatus.OK).body(imp.listar());
	}
	
	//http://localhost:9001/EmpleadoWs/guardar
	@PostMapping(path="guardar")
	public ResponseEntity <String> guardar(@RequestBody Empleado empleado){
		String mensaje;
		
		if (imp.buscarNombre(empleado.getNombre()) != null) {
			mensaje = "El empleado " + empleado.getNombre() + " ya forma parte del equipo de trabajo";
		} else {
			Date fechaHoy = new Date();
			
			int diferenciaEdad = fechaHoy.getYear() - empleado.getFecha_nacimiento().getYear();
			empleado.setEdad(diferenciaEdad);
			if (empleado.getEdad() >= 30 && empleado.getEdad() <= 40) {
				imp.guardar(empleado);
				mensaje = "Bienvenido porque aún es chicuelo";
			} else {
				mensaje = "No es Bienvenido porque rebasa la edad";
			}
		}
		return new ResponseEntity<String> (mensaje, HttpStatus.CREATED);
	}
	
	
	@PostMapping(path = "editar")
	public ResponseEntity<String> editar(@RequestBody Empleado empleado){
		String mensaje;
		
		return new ResponseEntity<String> ("Se actualizo " + empleado.getNombre(), HttpStatus.OK);
	}
	
	
	@PostMapping(path = "editarValidacion")
	public ResponseEntity<String> editarValidacion(@RequestBody Empleado empleado){
		String mensaje;

			Date fechaHoy = new Date();
			
			int diferencia = fechaHoy.getYear() - empleado.getFecha_nacimiento().getYear();
			empleado.setEdad(diferencia);
			if (empleado.getEdad() >= 30 && empleado.getEdad() <=40) {
				imp.editar(empleado);
				
				mensaje = "Se editó empleado";
			} else {
				mensaje = "No se editó empleado";
				}
		
		return new ResponseEntity<String>(mensaje, HttpStatus.CREATED);
		}
	
	@PostMapping(path = "buscar")
	public ResponseEntity<Respuesta> buscar(@RequestBody Empleado empleado){
		Respuesta mensaje = new Respuesta();
		List<Empleado> lista = new ArrayList<>();
		
		if (imp.buscarId(empleado.getId()) != null) {
			lista.add(imp.buscarId(empleado.getId()));
			mensaje.setMensaje("Se encontró empleado");
			mensaje.setEmpleado(lista);
		} else {
			mensaje.setMensaje("No se encontró empleado");
		}
		
		
		return new ResponseEntity<Respuesta>(mensaje, HttpStatus.OK);
	}
	
	
	@PostMapping(path = "eliminar")
	public ResponseEntity<String> eliminar(@RequestBody Empleado empleado){
		
		imp.delete(empleado);
		
		return new ResponseEntity<String> ("Se eliminó ", HttpStatus.OK);
	}
		
}
