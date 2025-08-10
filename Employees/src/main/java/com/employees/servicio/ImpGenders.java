package com.employees.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employees.dao.GendersDao;
import com.employees.dominio.Genders;

@Service
public class ImpGenders implements MetodosGenders{

	@Autowired
	GendersDao gendersDao;

	@Override
	public void guardar(Genders genders) {
		gendersDao.save(genders);
		
	}

	@Override
	public void editar(Genders genders) {
		gendersDao.save(genders);
		
	}

	@Override
	public void eliminar(Genders genders) {
		gendersDao.delete(genders);
		
	}

	@Override
	public Genders buscar(Genders genders) {
		return gendersDao.findById(genders.getId()).orElseThrow();
	}

	@Override
	public List listar() {
		return (List) gendersDao.findAll();
	}
}
