package com.marcaautos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marcaautos.dao.MarcaDao;
import com.marcaautos.dominio.Marca;
import com.marcaautos.servicio.ImpMarca;

@Controller
@RequestMapping(path = "CtrlMarca")
public class CtrlMarca {
	/*
	 * web service se consume con un front
	 * 
	 * 
	 * web service cuando se sonsume del lado del servidor solo necesitas
	 * -> @Controller
	 * 
	 * Model --> permite crear vista o view o paginas -> java server page
	 */

	@Autowired
	ImpMarca imp;
	
	@Autowired
	MarcaDao dao;

	// http://localhost:9001/CtrlMarca/listar

	@GetMapping(path = "listar")
	public String listar(Model model) {

		var lista = imp.listar();

		model.addAttribute("lista", lista);

		return "index";
	}

	// guardar --> primero abri el formulario

	// http://localhost:9001/CtrlMarca/abrirGuardar
	@GetMapping(path = "abrirGuardar")
	public String abrirGuardar(Marca marca) {

		return "guardar";
	}

	// guardar el objeto
	// http://localhost:9001/CtrlMarca/guardar
	@PostMapping(path = "guardar")
	public String guardar(Marca marca) {
		imp.guardar(marca);
		System.out.println("object-->" + marca);
		return "redirect:listar";
	}

	// editar para editar primero hay que buscar

	// http://localhost:9000/CtrlCompu/abrirEditar
	@GetMapping(path = "/abrirEditar/{id}")
	public String abrirEditar(Marca marca, Model model) {
		marca = imp.buscar(marca);
		model.addAttribute("marca", marca);
		return "editar";
	}

	// http://localhost:9001/CtrlMarca/editar
	@PostMapping(path = "editar")
	public String editar(Marca marca) {
		imp.editar(marca);
		System.out.println("object-->" + marca);
		return "redirect:listar";
	}

	// metodo eliminar
	// http://localhost:9001/CtrlMarca/abrirEliminar
	@GetMapping(path = "/abrirEliminar/{id}")
	public String abrirEliminar(Marca marca, Model model) {
		marca = imp.buscar(marca);
		model.addAttribute("marca", marca);
		return "eliminar";
	}

	// http://localhost:9001/CtrlMarca/eliminar
	@PostMapping(path = "eliminar")
	public String eliminar(Marca marca) {
		imp.eliminar(marca);
		System.out.println("object-->" + marca);
		return "redirect:listar";
	}

	// metodo eliminar
	// http://localhost:9001/CtrlMarca/abrirEliminar
	@RequestMapping(path = "/abrirEliminarId/{id}")
	public String abrirEliminarId(Marca marca, Model model) {
		marca = imp.buscar(marca);
		dao.delete(marca);
		
		var lista = imp.listar();
		model.addAttribute("lista", lista);
		return "index";
	}
}
