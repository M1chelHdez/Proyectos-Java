package com.mx.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.employees.entidad.EmployeeWorked;
import com.mx.employees.respuesta.ResponseEmployee;
import com.mx.employees.service.ImpWorked;

@RestController
@RequestMapping("api/hours")
@CrossOrigin("*")
public class WorkedHWs {
	@Autowired
	ImpWorked imp;
	
	@GetMapping("listar")
	public List<EmployeeWorked> listar() {
		return imp.listar();
	}
	
	@PostMapping("guardar")
	public ResponseEmployee guardar(@RequestBody EmployeeWorked employeeW) {
		return imp.guadar(employeeW);
	}
}
