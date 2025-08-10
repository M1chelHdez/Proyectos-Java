package com.mx.employees.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.employees.dao.JobDao;
import com.mx.employees.entidad.Employees;
import com.mx.employees.entidad.Jobs;
import com.mx.employees.respuesta.Response;
import com.mx.employees.respuesta.ResponseEmployee;

@Service
public class ImpJobs {
	@Autowired
	JobDao jobsDao;
	
	public boolean buscar(int id) {
		return jobsDao.existsById(id);
	}
	
	public List<Jobs> listar() {
		return jobsDao.findAll();
	}
	
	public Response guardar(Jobs job) {
		Response r = new Response();
		r.setSuccess(true);
		
		for (Jobs j : jobsDao.findAll()) {
			if (j.getId() == job.getId() ) {
				r.setSuccess(false);
				r.setMessage("Ya existe un trabajo con ese id");
				break;
			}
			if (j.getName().equals(job.getName())) {
				r.setSuccess(false);
				r.setMessage("Ya existe un trabajo con ese nombre");
				break;
			}
		}
		
		if (r.isSuccess()) {
			jobsDao.save(job);
			r.setMessage("Registrado");
			r.setId(job.getId());
		}
		
		return r;
	}
	
	public ResponseEmployee buscarE(Jobs job) {
		Jobs jobs = jobsDao.findById(job.getId()).orElse(null);
		ResponseEmployee r = new ResponseEmployee();
		
		r.setSuccess(true);
		
		if (jobs == null) {
			r.setMessage("No existe un puesto con ese id");
			r.setSuccess(false);
		}else {
			List<Employees> listE = jobs.getListE();
			
			if (listE.isEmpty()) {
				r.setMessage("Este puesto no tiene empleados asignados");
				r.setSuccess(false);
			}else {
				//c) Filtar los empleados obtenidos en b) con el puesto recibido en a) ocupando
				//expresiones lambda con filtro
				List<Employees> filterList = listE.stream()
						.filter(employee -> employee.getJob().getId() == job.getId())
						.collect(Collectors.toList());
				
				//d) De los empleados obtenidos en c) ordenarlos por appellido materno.
				Collections.sort(filterList);
				
				//e) De los empleados obtenidos en d) agruparlos con expresion lambda por
				//apellido materno 
				Map<String, List<Employees>> listLast = filterList.stream()
						.collect(Collectors.groupingBy(e -> e.getLast_name()));
				
				r.setEmployees(listLast);
				r.setMessage("Econtrados");
			}
		}
		
		return r;
	}
	
}
