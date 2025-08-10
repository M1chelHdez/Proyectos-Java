package com.employees.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employees.dao.JobsDao;
import com.employees.dominio.Jobs;

@Service
public class ImpJobs implements MetodosJobs{
	
	@Autowired
	JobsDao jobsDao;

	@Override
	public void guardar(Jobs jobs) {
		jobsDao.save(jobs);
		
	}

	@Override
	public void editar(Jobs jobs) {
		jobsDao.save(jobs);
		
	}

	@Override
	public void eliminar(Jobs jobs) {
		jobsDao.delete(jobs);
		
	}

	@Override
	public Jobs buscar(Jobs jobs) {
		return jobsDao.findById(jobs.getId()).orElseThrow();
	}

	@Override
	public List listar() {
		return (List) jobsDao.findAll();
	}

	
}
