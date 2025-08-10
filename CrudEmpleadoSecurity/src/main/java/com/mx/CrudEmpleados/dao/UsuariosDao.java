package com.mx.CrudEmpleados.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.CrudEmpleados.dominio.Usuarios;

@Repository
public interface UsuariosDao extends JpaRepository<Usuarios, Integer>{

//	Usuarios findByUsuarios(String usuario);
	Usuarios findByNombre(String nombre);
	
}
