package com.mx.Patito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Patito.entidad.Auditoria;
import com.mx.Patito.service.ImpAuditoria;

@RestController
@RequestMapping("auditoria")
@CrossOrigin("*")
public class AuditoWs {
	@Autowired
	ImpAuditoria imp;
	
	// http://localhost:9001/auditoria/listar
	@GetMapping("listar")
	public List<Auditoria> listar() {
		return imp.mostrar();
	}
	
	/* comsumir un web seervice --> http 
	 * 
	 * 
	 * */
	
}
