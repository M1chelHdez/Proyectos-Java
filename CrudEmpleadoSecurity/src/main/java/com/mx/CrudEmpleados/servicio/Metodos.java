package com.mx.CrudEmpleados.servicio;

import java.util.List;

import com.mx.CrudEmpleados.dominio.Empleado;

public interface Metodos {

	public Empleado guardar(Empleado empleado);

	public Empleado editar(Empleado empleado);

	public void eliminar(int id);

	public Empleado buscarId(int id);

	public Empleado buscarNombre(Empleado empleado);

	public List<Empleado> listar();
}
