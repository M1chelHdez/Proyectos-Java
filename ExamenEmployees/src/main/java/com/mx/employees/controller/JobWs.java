package com.mx.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.employees.entidad.Jobs;
import com.mx.employees.respuesta.Response;
import com.mx.employees.respuesta.ResponseEmployee;
import com.mx.employees.service.ImpJobs;

@RestController
@RequestMapping("api/jobs")
@CrossOrigin("*")
public class JobWs {
	@Autowired
	ImpJobs imp;
	
	@GetMapping("listar")
	public List<Jobs> listar() {
		return imp.listar();
	}
	
	@PostMapping("guardar")
	public Response guardar(@RequestBody Jobs jobs) {
		return imp.guardar(jobs);
	}
	
	@GetMapping("buscarE")
	public ResponseEmployee buscarE(@RequestBody Jobs jobs) {
		return imp.buscarE(jobs);
	}
}
