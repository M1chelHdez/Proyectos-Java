package com.marcaautos.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcaautos.dao.AutosDao;
import com.marcaautos.dominio.Autos;

@Service
public class ImpAutos implements MetodosAutos{
	@Autowired
	AutosDao dao;
	
	@Override
	public void guardar(Autos autos) {
		dao.save(autos);
		
	}

	@Override
	public void editar(Autos autos) {
		dao.save(autos);
		
	}

	@Override
	public void eliminar(Autos autos) {
		dao.delete(autos);
		
	}

	@Override
	public Autos buscar(Autos autos) {
		return dao.findById(autos.getId()).orElseThrow();
	}

	@Override
	public List listar() {
		return (List) dao.findAll();
	}
}
