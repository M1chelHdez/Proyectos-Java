package com.marcaautos.servicio;

import java.util.List;

import com.marcaautos.dominio.Autos;

public interface MetodosAutos {
	public void guardar(Autos autos);

	public void editar(Autos autos);

	public void eliminar(Autos autos);

	public Autos buscar(Autos autos);

	public List listar();
}
