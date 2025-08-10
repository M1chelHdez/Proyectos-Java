package com.mx.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.employees.entidad.Employees;
import com.mx.employees.respuesta.Response;
import com.mx.employees.service.ImpEmployee;

@RestController
@RequestMapping("api/employees")
@CrossOrigin("*")
public class EmployeeWs {
	@Autowired
	ImpEmployee imp;
	
	@GetMapping("listar")
	public List<Employees> listar() {
		return imp.listar();
	}
	
	@PostMapping("guardar")
	public Response guaradar(@RequestBody Employees employee) {
		return imp.guardar(employee);
	}
}
