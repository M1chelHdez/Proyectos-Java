package com.mx.employees.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.employees.dao.HoursWDao;
import com.mx.employees.entidad.EmployeeWorked;
import com.mx.employees.respuesta.ResponseEmployee;

@Service
public class ImpWorked {
	@Autowired
	HoursWDao hourDao;
	@Autowired
	ImpEmployee impE;

	public List<EmployeeWorked> listar() {
		return hourDao.findAll();
	}

	public ResponseEmployee guadar(EmployeeWorked employeeW) {
		ResponseEmployee r = new ResponseEmployee();
		r.setSuccess(true);

		if (hourDao.existsById(employeeW.getId())) {
			r.setMessage("Ya existe un id registrado");
			r.setSuccess(false);
		}
		if (!impE.searchE(employeeW.getEmployee().getId())) {
			r.setMessage("No existe ese empleado con ese id");
			r.setSuccess(false);
		}
		
		if (r.isSuccess()) {
			hourDao.save(employeeW);
			r.setMessage("Registrado");
		}

		return r;
	}
}
