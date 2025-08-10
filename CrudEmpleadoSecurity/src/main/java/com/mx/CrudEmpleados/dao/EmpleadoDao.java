package com.mx.CrudEmpleados.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.CrudEmpleados.dominio.Empleado;

@Repository
public interface EmpleadoDao extends JpaRepository<Empleado, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT * FROM EMPLEADOS_ENCOM E WHERE E.NOMBRE=:NOMBRE")
	Empleado findByNombre(@Param("NOMBRE") String nombre);
}