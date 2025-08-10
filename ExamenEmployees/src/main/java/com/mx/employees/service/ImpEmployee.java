package com.mx.employees.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.employees.dao.EmployeDao;
import com.mx.employees.entidad.Employees;
import com.mx.employees.respuesta.Response;

@Service
public class ImpEmployee {
	@Autowired
	EmployeDao empDao;
	@Autowired
	ImpGenders impG;
	@Autowired
	ImpJobs impJ;
	
	public List<Employees> listar(){
		return empDao.findAll();
	}
	
	public boolean searchE(int id) {
		return empDao.existsById(id);
	}
	
	public Response guardar(Employees employee) {
		boolean existGender = impG.buscar(employee.getGender().getId());
		boolean existJob = impJ.buscar(employee.getJob().getId());
		
		Response r = new Response();
		r.setSuccess(true);
		
		for (Employees e : empDao.findAll()) {
			if (e.getName().equals(employee.getName())) {
				if (e.getLast_name().equals(employee.getLast_name())) {
					r.setSuccess(false);
					r.setMessage("El nombre y apellido ya estan registrados");
					break;
				}
			}
		}
		
		if (!isMayor(employee.getBirthdate())) {
			r.setSuccess(false);
			r.setMessage("Debes ser mayor de edad");
		}
		
		if (!existGender) {
			r.setSuccess(false);
			r.setMessage("No existe un genero con ese id");
		}
		
		if (!existJob) {
			r.setSuccess(false);
			r.setMessage("No existe un trabajo con ese id");
		}
		
		if (r.isSuccess()) {
			employee.setId(random());
			
			if (empDao.existsById(employee.getId())) {
				employee.setId(random());
			}
			empDao.save(employee);
			r.setMessage("Registrado");
			r.setId(employee.getId());;
		}
		
		return r;
	}
	
	public int random() {
		Random random = new Random();
		int randomNumber = random.nextInt(20) + 1;
		
		return randomNumber;
		
	}
	
	public boolean isMayor(Date birthDate) {
		boolean older = true;
		LocalDate dateNow = LocalDate.now();
		
		LocalDate birthLocal = birthDate.toLocalDate();
		
		Period periodo = Period.between(birthLocal, dateNow);
		int yearsOld = periodo.getYears();
		
		if (yearsOld <= 17) {
			older = false;
		}
		
		return older;
	}
}
