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

import com.marcaautos.dao.MarcaDao;
import com.marcaautos.dominio.Marca;
import com.marcaautos.servicio.ImpMarca;

@RestController
@RequestMapping(path = "WebService")
@CrossOrigin("*")
public class WsMarca {
	
	// inyecion de dependencias
			@Autowired
			ImpMarca imp;
			// URL : url del servidor + el path de mi clase + el path de mi metodo

			@Autowired
			MarcaDao dao;

			// http://localhost:9001/WebService/Api/listaDao
			@GetMapping(path = "listaDao")
			public List<Marca> listaDao() {
				
				return (List<Marca>) dao.findAll();
			}

			// http://localhost:9001/WebService/Api/lista
			@GetMapping(path = "lista")
			public List<Marca> lista() {
				List<Marca> listaMarca = new ArrayList<Marca>();
				listaMarca = imp.listar();
				return listaMarca;
			}

			// http://localhost:9001/WebService/Api/guardar
			// metodo guardar
			@PostMapping(path = "guardar")
			public void guardar(@RequestBody Marca marca) {
				imp.guardar(marca);
				// @RequestBody -> convetir un objeto en JSON
			}

			// http://localhost:9001/WebService/Api/editar
			// metodo EDITAR
			@PostMapping(path = "editar")
			public void editar(@RequestBody Marca marca) {
				imp.editar(marca);
				// @RequestBody -> convetir un objeto en JSON
			}

			// http://localhost:9001/WebService/eliminar
			// metodo Eliminar
			@PostMapping(path = "eliminar")
			public void eliminar(@RequestBody Marca marca) {
				imp.eliminar(marca);
				// @RequestBody -> convetir un objeto en JSON
			}

			// http://localhost:9001/WebService/Api/buscar
			// metodo Eliminar
			@PostMapping(path = "buscar")
			public Marca buscar(@RequestBody Marca marca) {

				marca = imp.buscar(marca);

				return marca;
			}

}
