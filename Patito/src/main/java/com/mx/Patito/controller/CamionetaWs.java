package com.mx.Patito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Patito.Respuesta.Respuesta;
import com.mx.Patito.entidad.Camioneta;
import com.mx.Patito.service.ImpCamioneta;

@RestController
@RequestMapping("camioneta")
@CrossOrigin
public class CamionetaWs {
	@Autowired
	ImpCamioneta imp;
	
	// http://localhost:9001/camioneta/listar
	@GetMapping("listar")
	public List<Camioneta> mostrar(){
		return imp.mostrar();
	}
	
	// http://localhost:9001/camioneta/guardar
	@PostMapping("guardar")
	public ResponseEntity<Respuesta> guardar(@RequestBody Camioneta cami) {
		Respuesta r = imp.guardar(cami);
		
		if (r.isAction()) {
			//return new ResponseEntity<Respuesta>(r,HttpStatus.OK);
			return new ResponseEntity<Respuesta>(r,HttpStatus.OK);
		}else{
			return new ResponseEntity<Respuesta>(r,HttpStatus.BAD_REQUEST);
		}
	}
	// http://localhost:9001/camioneta/eliminar 
	@PostMapping("eliminar")
	public void eliminar(@RequestBody Camioneta cami) {
		imp.eliminar(cami);
	}
	// http://localhost:9001/camioneta/buscarId 
	@PostMapping("buscarId")
	public Camioneta buscarId(@RequestBody Camioneta cami) {
		return imp.buscarId(cami);
	}
	// http://localhost:9001/camioneta/editar 
	@PostMapping("editar")
	public void editar(@RequestBody Camioneta cami) {
		imp.editar(cami);
	}
}
