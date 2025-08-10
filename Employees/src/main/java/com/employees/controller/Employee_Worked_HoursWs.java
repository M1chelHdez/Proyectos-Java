package com.employees.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employees.dao.Employee_Worked_HoursDao;
import com.employees.dominio.Employee_Worked_Hours;
import com.employees.servicio.ImpEmployee_Worked_Hours;

@RestController
@RequestMapping(path = "Employee_Worked_HoursWs")
@CrossOrigin
public class Employee_Worked_HoursWs {

	@Autowired
	ImpEmployee_Worked_Hours imp;
	
	@Autowired
	Employee_Worked_HoursDao dao;
	
	// http://localhost:9001/Employee_Worked_HoursWs/listaDao
	@GetMapping(path = "listaDao")
	public List<Employee_Worked_Hours> listaDao() {
		
		return (List<Employee_Worked_Hours>) dao.findAll();
	}

	// http://localhost:9001/Employee_Worked_HoursWs/lista
	@GetMapping(path = "lista")
	public List<Employee_Worked_Hours> lista() {
		List<Employee_Worked_Hours> listaEWH = new ArrayList<Employee_Worked_Hours>();
		listaEWH = imp.listar();
		return listaEWH;
	}

	// http://localhost:9001/Employee_Worked_HoursWs/guardar
	// metodo guardar
	@PostMapping(path = "guardar")
	public void guardar(@RequestBody Employee_Worked_Hours ewh) {
		imp.guardar(ewh);
		// @RequestBody -> convetir un objeto en JSON
	}

	// http://localhost:9001/Employee_Worked_HoursWs/editar
	// metodo EDITAR
	@PostMapping(path = "editar")
	public void editar(@RequestBody Employee_Worked_Hours ewh) {
		imp.editar(ewh);
		// @RequestBody -> convetir un objeto en JSON
	}

	// http://localhost:9001/Employee_Worked_HoursWs/eliminar
	// metodo Eliminar
	@PostMapping(path = "eliminar")
	public void eliminar(@RequestBody Employee_Worked_Hours ewh) {
		imp.eliminar(ewh);
		// @RequestBody -> convetir un objeto en JSON
	}

	// http://localhost:9001/Employee_Worked_HoursWs/buscar
	// metodo Eliminar
	@PostMapping(path = "buscar")
	public Employee_Worked_Hours buscar(@RequestBody Employee_Worked_Hours ewh) {

		ewh = imp.buscar(ewh);

		return ewh;
	}
	
	
}
