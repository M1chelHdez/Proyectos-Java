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
import com.mx.Patito.dto.Asignar;
import com.mx.Patito.dto.Detalles;
import com.mx.Patito.dto.PediList;
import com.mx.Patito.entidad.Pedido;
import com.mx.Patito.service.ImpPedido;

@RestController
@RequestMapping("pedido")
@CrossOrigin("*")
public class PedidoWs {
	@Autowired
	ImpPedido imp;

	// http://localhost:9001/pedido/listar
	@GetMapping("listar")
	public List<PediList> listar() {
		return imp.mostrar();
	}

	// http://localhost:9001/pedido/guardar
	@PostMapping("guardar")
	public ResponseEntity<Respuesta> guardar(@RequestBody Pedido pedido) {
		Respuesta r = imp.guardar(pedido);

		if (r.isAction()) {
			return new ResponseEntity<Respuesta>(r, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Respuesta>(r, HttpStatus.BAD_REQUEST);
		}
	}

//  http://localhost:9001/pedido/editar
	@PostMapping("editar")
	public ResponseEntity<Respuesta> editar(@RequestBody Pedido pedido) {
		Respuesta r = imp.editar(pedido);

		if (r.isAction()) {
			return new ResponseEntity<Respuesta>(r, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Respuesta>(r, HttpStatus.BAD_REQUEST);
		}
	}

//  http://localhost:9001/pedido/realizar
	@PostMapping("realizar")
	public ResponseEntity<Respuesta> hacerPedido(@RequestBody Asignar asignar) {
		Respuesta r = imp.hacerPedido(asignar);

		if (r.isAction()) {
			return new ResponseEntity<Respuesta>(r, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Respuesta>(r, HttpStatus.BAD_REQUEST);
		}
	}

//  http://localhost:9001/pedido/detallesP
	@GetMapping("detallesP")
	public List<Detalles> listaDetalles() {
		return imp.listarDetalles();
	}

//  http://localhost:9001/pedido/detallesid
	@PostMapping("detallesid")
	public Detalles listaDetallesid(@RequestBody Pedido pedido) {
		return imp.detalleId(pedido);
	}

//  http://localhost:9001/pedido/eliminar
	@PostMapping("eliminar")
	public void eliminarPedido(@RequestBody Pedido pedido) {
		imp.eliminarRe(pedido);
	}
}
