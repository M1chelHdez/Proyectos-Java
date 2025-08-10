package com.marcaautos.servicio;

import java.util.List;

import com.marcaautos.dominio.Marca;

public interface MetodosMarca {

	public void guardar(Marca marca);

	public void editar(Marca marca);

	public void eliminar(Marca marca);

	public Marca buscar(Marca marca);

	public List listar();
}
