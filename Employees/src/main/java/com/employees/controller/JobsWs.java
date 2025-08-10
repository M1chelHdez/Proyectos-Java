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

import com.employees.dao.JobsDao;
import com.employees.dominio.Jobs;
import com.employees.servicio.ImpJobs;

@RestController
@RequestMapping(path = "JobsWs")
@CrossOrigin
public class JobsWs {

	@Autowired
	ImpJobs imp;
	
	@Autowired
	JobsDao dao;
	
	// http://localhost:9001/JobsWs/listaDao
			@GetMapping(path = "listaDao")
			public List<Jobs> listaDao() {
				
				return (List<Jobs>) dao.findAll();
			}

			// http://localhost:9001/JobsWs/lista
			@GetMapping(path = "lista")
			public List<Jobs> lista() {
				List<Jobs> listaJobs = new ArrayList<Jobs>();
				listaJobs = imp.listar();
				return listaJobs;
			}

			// http://localhost:9001/JobsWs/guardar
			// metodo guardar
			@PostMapping(path = "guardar")
			public void guardar(@RequestBody Jobs jobs) {
				imp.guardar(jobs);
				// @RequestBody -> convetir un objeto en JSON
			}

			// http://localhost:9001/JobsWs/editar
			// metodo EDITAR
			@PostMapping(path = "editar")
			public void editar(@RequestBody Jobs jobs) {
				imp.editar(jobs);
				// @RequestBody -> convetir un objeto en JSON
			}

			// http://localhost:9001/JobsWs/eliminar
			// metodo Eliminar
			@PostMapping(path = "eliminar")
			public void eliminar(@RequestBody Jobs jobs) {
				imp.eliminar(jobs);
				// @RequestBody -> convetir un objeto en JSON
			}

			// http://localhost:9001/JobsWs/buscar
			// metodo Eliminar
			@PostMapping(path = "buscar")
			public Jobs buscar(@RequestBody Jobs jobs) {

				jobs = imp.buscar(jobs);

				return jobs;
			}
}
