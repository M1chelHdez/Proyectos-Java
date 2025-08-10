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

import com.employees.dao.GendersDao;
import com.employees.dominio.Genders;
import com.employees.servicio.ImpGenders;

@RestController
@RequestMapping(path = "GendersWs")
@CrossOrigin
public class GendersWs {
	
	@Autowired
	ImpGenders imp;
	
	@Autowired
	GendersDao dao;

	// http://localhost:9001/GendersWs/listaDao
				@GetMapping(path = "listaDao")
				public List<Genders> listaDao() {
					
					return (List<Genders>) dao.findAll();
				}

				// http://localhost:9001/GendersWs/lista
				@GetMapping(path = "lista")
				public List<Genders> lista() {
					List<Genders> listaGenders = new ArrayList<Genders>();
					listaGenders = imp.listar();
					return listaGenders;
				}

				// http://localhost:9001/GendersWs/guardar
				// metodo guardar
				@PostMapping(path = "guardar")
				public void guardar(@RequestBody Genders genders) {
					imp.guardar(genders);
					// @RequestBody -> convetir un objeto en JSON
				}

				// http://localhost:9001/GendersWs/editar
				// metodo EDITAR
				@PostMapping(path = "editar")
				public void editar(@RequestBody Genders genders) {
					imp.editar(genders);
					// @RequestBody -> convetir un objeto en JSON
				}

				// http://localhost:9001/GendersWs/eliminar
				// metodo Eliminar
				@PostMapping(path = "eliminar")
				public void eliminar(@RequestBody Genders genders) {
					imp.eliminar(genders);
					// @RequestBody -> convetir un objeto en JSON
				}

				// http://localhost:9001/GendersWs/buscar
				// metodo Eliminar
				@PostMapping(path = "buscar")
				public Genders buscar(@RequestBody Genders genders) {

					genders = imp.buscar(genders);

					return genders;
				}
}
