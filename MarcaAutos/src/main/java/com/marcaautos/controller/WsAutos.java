package com.marcaautos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcaautos.dao.AutosDao;
import com.marcaautos.dominio.Autos;
import com.marcaautos.servicio.ImpAutos;

@RestController
@RequestMapping(path = "WebService/Api")
@CrossOrigin("*")
public class WsAutos {

	// inyecion de dependencias
		@Autowired
		ImpAutos imp;
		// URL : url del servidor + el path de mi clase + el path de mi metodo

		@Autowired
		AutosDao dao;

		// http://localhost:9001/WebService/Api/listaDao
		@GetMapping(path = "listaDao")
		public List<Autos> listaDao() {
			
			return (List<Autos>) dao.findAll();
		}

		// http://localhost:9001/WebService/Api/lista
		@GetMapping(path = "lista")
		public List<Autos> lista() {
			List<Autos> listaAutos = new ArrayList<Autos>();
			listaAutos = imp.listar();
			return listaAutos;
		}

		// http://localhost:9001/WebService/Api/guardar
		// metodo guardar
		@PostMapping(path = "guardar")
		public void guardar(@RequestBody Autos autos) {
			imp.guardar(autos);
			// @RequestBody -> convetir un objeto en JSON
		}

		// http://localhost:9001/WebService/Api/editar
		// metodo EDITAR
		@PostMapping(path = "editar")
		public void editar(@RequestBody Autos autos) {
			imp.editar(autos);
			// @RequestBody -> convetir un objeto en JSON
		}

		// http://localhost:9001/WebService/eliminar
		// metodo Eliminar
		@PostMapping(path = "eliminar")
		public void eliminar(@RequestBody Autos autos) {
			imp.eliminar(autos);
			// @RequestBody -> convetir un objeto en JSON
		}

		// http://localhost:9001/WebService/Api/buscar
		// metodo Eliminar
		@PostMapping(path = "buscar")
		public Autos buscar(@RequestBody Autos autos) {

			autos = imp.buscar(autos);

			return autos;
		}

}
