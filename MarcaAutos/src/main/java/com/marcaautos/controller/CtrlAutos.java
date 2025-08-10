package com.marcaautos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marcaautos.dao.AutosDao;
import com.marcaautos.dominio.Autos;
import com.marcaautos.servicio.ImpAutos;

@Controller
@RequestMapping(path = "CtrlAutos")
public class CtrlAutos {
	
	@Autowired
	ImpAutos imp;
	
	@Autowired
	AutosDao dao;

	// http://localhost:9001/CtrlAutos/listar

	@GetMapping(path = "listar")
	public String listar(Model model) {

		var lista = imp.listar();
		model.addAttribute("lista", lista);
		return "indexA";
	}

	// guardar --> primero abri el formulario

	// http://localhost:9001/CtrlAutos/abrirGuardar
	@GetMapping(path = "abrirGuardar")
	public String abrirGuardar(Autos autos) {
		return "guardarA";
	}

	// guardar el objeto
	// http://localhost:9001/CtrlAutos/guardar
	@PostMapping(path = "guardar")
	public String guardar(Autos autos) {
		imp.guardar(autos);
		System.out.println("object-->" + autos);
		return "redirect:listar";
	}

	// editar para editar primero hay que buscar

	// http://localhost:9001/CtrlAutos/abrirEditar
	@GetMapping(path = "/abrirEditar/{id}")
	public String abrirEditar(Autos autos, Model model) {
		autos = imp.buscar(autos);
		model.addAttribute("autos", autos);
		return "editarA";
	}

	// http://localhost:9001/CtrlAutos/editar
	@PostMapping(path = "editar")
	public String editar(Autos autos) {
		imp.editar(autos);
		System.out.println("object-->" + autos);
		return "redirect:listar";
	}

	// metodo eliminar
	// http://localhost:9001/CtrlAutos/abrirEliminar
	@GetMapping(path = "/abrirEliminar/{id}")
	public String abrirEliminar(Autos autos, Model model) {
		autos = imp.buscar(autos);
		model.addAttribute("autos", autos);
		return "eliminarA";
	}

	// http://localhost:9001/CtrlCompu/eliminar
	@PostMapping(path = "eliminar")
	public String eliminar(Autos autos) {
		imp.eliminar(autos);
		System.out.println("object-->" + autos);
		return "redirect:listar";
	}

	// metodo eliminar
	// http://localhost:9001/CtrlAutos/abrirEliminar
	@RequestMapping(path = "/abrirEliminarId/{id}")
	public String abrirEliminarId(Autos autos, Model model) {
		autos = imp.buscar(autos);
		dao.delete(autos);
		
		var lista = imp.listar();
		model.addAttribute("lista", lista);
		return "indexA";
	}
}
