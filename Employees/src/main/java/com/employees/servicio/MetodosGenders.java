package com.employees.servicio;

import java.util.List;

import com.employees.dominio.Genders;

public interface MetodosGenders {

	public void guardar(Genders genders);

	public void editar(Genders genders);

	public void eliminar(Genders genders);

	public Genders buscar(Genders genders);

	public List listar();
}
