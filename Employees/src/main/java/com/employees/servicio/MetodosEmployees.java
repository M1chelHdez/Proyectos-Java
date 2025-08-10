package com.employees.servicio;

import java.util.List;

import com.employees.dominio.Employees;

public interface MetodosEmployees {

	public void guardar(Employees employees);

	public void editar(Employees employees);

	public void eliminar(Employees employees);

	public Employees buscar(Employees employees);
	
	public Employees buscarNombre(Employees employees);
	
	public Employees buscarId(int id);

	public List listar();
}
