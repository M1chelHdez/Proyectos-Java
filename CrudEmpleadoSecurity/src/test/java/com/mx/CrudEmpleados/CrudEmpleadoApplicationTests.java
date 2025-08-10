package com.mx.CrudEmpleados;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mx.CrudEmpleados.dao.EmpleadoDao;
import com.mx.CrudEmpleados.dao.UsuariosDao;
import com.mx.CrudEmpleados.dominio.Usuarios;
import com.mx.CrudEmpleados.servicio.ImpUsuarios;
import com.mx.CrudEmpleados.servicio.Implementacion;

@SpringBootTest
class CrudEmpleadoApplicationTests {

	@Autowired
	EmpleadoDao dao;
	
	@Autowired
	Implementacion imp;
	
	@Autowired
	UsuariosDao user;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	ImpUsuarios usuarios;
	
//	@Test
//	public void guardarUser() {
//		Usuarios us = new Usuarios();
//		us.setId(1);
//		us.setUsuario("Luis");
//		us.setPassword(encoder.encode("12345"));
//		usuarios.guardar(us);
//	}
	
	@Test
	public void guardarUser() {
		Usuarios us = new Usuarios();
		us.setId(1);
		us.setNombre("Ana");
		us.setPassword(encoder.encode("12345"));
		Usuarios enviarUsuario = usuarios.guardar(us);
		
		assertTrue(enviarUsuario.getPassword().equalsIgnoreCase(us.getPassword()));
	}
	
//	@Test
//	void contextLoads() {
//	}

	
	
}
