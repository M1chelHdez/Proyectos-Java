package com.employees.servicio;

import java.util.List;

import com.employees.dominio.Jobs;

public interface MetodosJobs {

	public void guardar(Jobs jobs);

	public void editar(Jobs jobs);

	public void eliminar(Jobs jobs);

	public Jobs buscar(Jobs jobs);

	public List listar();
}
