package com.employees.controller;

import java.sql.Date;
import java.util.ArrayList;
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

import com.employees.dominio.Employees;
import com.employees.dominio.Respuesta;
import com.employees.servicio.ImpEmployees;

@RestController
@RequestMapping(path = "EmployeesWs")
@CrossOrigin
public class EmployeesWs {

	@Autowired
	ImpEmployees imp;
	
	// http://localhost:9001/EmployeesWs/listar
		@GetMapping(path = "listar")
		public ResponseEntity<List<Employees>> listar() {
			return ResponseEntity.status(HttpStatus.OK).body(imp.listar());
		}

		// http://localhost:9001/EmployeesWs/guardar
		@PostMapping(path="guardar")
			public ResponseEntity <String> guardar(@RequestBody Employees employees){
				String mensaje;
				
				if (imp.buscarNombre(employees.getName()) != null) {
					mensaje = "El empleado " + employees.getName() + " ya forma parte del equipo";
				} else {
					Date fechaHoy = new Date(0);
					
					int diferenciaEdad = fechaHoy.getYear() - employees.getBirthday().getYear();
					employees.getBirthday();
					if (employees.getName() == employees.getName() ) {
					imp.guardar(employees);
						mensaje = "Registrado";
				} else {
					mensaje = "No se puede registrar";
				}
				}
				return new ResponseEntity<String> (mensaje, HttpStatus.CREATED);
	}

		// http://localhost:9001/EmployeesWs/editar
		@PostMapping(path = "editar")
		public ResponseEntity<String> editar(@RequestBody Employees employees) {
			String mensaje;

			return new ResponseEntity<String>("Se actualizo " + employees.getName(), HttpStatus.OK);
		}

		// http://localhost:9001/EmployeesWs/buscar
		@PostMapping(path = "buscar")
		public ResponseEntity<Respuesta> buscar(@RequestBody Employees employees) {
			Respuesta mensaje = new Respuesta();
			List<Employees> lista = new ArrayList<>();

			if (imp.buscarId(employees.getId()) != null) {
				lista.add(imp.buscarId(employees.getId()));
				mensaje.setMensaje("Se encontró empleado");
				mensaje.setEmployees(lista);
			} else {
				mensaje.setMensaje("No se encontró empleado");
			}

			return new ResponseEntity<Respuesta>(mensaje, HttpStatus.OK);
		}

	
		// http://localhost:9001/EmployeesWs/eliminar
		@PostMapping(path = "eliminar")
		public ResponseEntity<String> eliminar(@RequestBody Employees employees) {

			imp.eliminar(employees);

			return new ResponseEntity<String>("Se eliminó ", HttpStatus.OK);
		}
}
