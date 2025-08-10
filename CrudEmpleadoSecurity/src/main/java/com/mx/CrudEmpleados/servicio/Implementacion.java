package com.mx.CrudEmpleados.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.CrudEmpleados.dao.EmpleadoDao;
import com.mx.CrudEmpleados.dominio.Empleado;

@Service
public class Implementacion  implements Metodos{
	
	@Autowired
	EmpleadoDao dao;

	@Override
	public Empleado guardar(Empleado empleado) {
		return dao.save(empleado);
	}

	@Override
	public Empleado editar(Empleado empleado) {
		return dao.save(empleado);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	public void delete(Empleado empleado) {
		dao.delete(empleado);
	}
	
	@Override
	public Empleado buscarId(int id) {
		return dao.findById(id).orElseThrow(()-> new RuntimeException("No existe empleado"));
	}
	
	
	public Empleado buscarNombre(String nombre) {
		return dao.findByNombre(nombre);
	}

	@Override
	public Empleado buscarNombre(Empleado empleado) {
		Empleado e = new Empleado();
		if (empleado.getNombre() != null) {
			e = dao.findByNombre(empleado.getNombre());
		}
		return e;
	}

	@Override
	public List<Empleado> listar() {
		return dao.findAll();
	}

}
