package com.mx.CrudEmpleados.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.CrudEmpleados.dao.UsuariosDao;
import com.mx.CrudEmpleados.dominio.Usuarios;

@Service
public class ImpUsuarios implements MetodosUsuarios{

	@Autowired
	UsuariosDao dao;
	
	@Override
	public Usuarios guardar(Usuarios usuarios) {
		return dao.save(usuarios);
	}

}
