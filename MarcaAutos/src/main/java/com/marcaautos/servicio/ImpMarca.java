package com.marcaautos.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcaautos.dao.MarcaDao;
import com.marcaautos.dominio.Marca;

@Service
public class ImpMarca implements MetodosMarca{
	@Autowired
	MarcaDao dao;

	@Override
	public void guardar(Marca marca) {
		// TODO Auto-generated method stub
		dao.save(marca);
	}

	@Override
	public void editar(Marca marca) {
		// TODO Auto-generated method stub
		dao.save(marca);
	}

	@Override
	public void eliminar(Marca marca) {
		// TODO Auto-generated method stub
		dao.delete(marca);
	}

	@Override
	public Marca buscar(Marca marca) {
		return dao.findById(marca.getId()).orElseThrow();
	}

	@Override
	public List listar() {
		return (List) dao.findAll();
	}
	
	
}
