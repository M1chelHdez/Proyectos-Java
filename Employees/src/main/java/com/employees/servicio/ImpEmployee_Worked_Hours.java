package com.employees.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employees.dao.Employee_Worked_HoursDao;
import com.employees.dominio.Employee_Worked_Hours;

@Service
public class ImpEmployee_Worked_Hours implements MetodosEmployee_Worked_Hours{

	@Autowired
	Employee_Worked_HoursDao employee_worked_hoursDao;
	
	@Override
	public void guardar(Employee_Worked_Hours employee_worked_hours) {
		employee_worked_hoursDao.save(employee_worked_hours);
		
	}

	@Override
	public void editar(Employee_Worked_Hours employee_worked_hours) {
		employee_worked_hoursDao.save(employee_worked_hours);
		
	}

	@Override
	public void eliminar(Employee_Worked_Hours employee_worked_hours) {
		employee_worked_hoursDao.delete(employee_worked_hours);
		
	}

	@Override
	public Employee_Worked_Hours buscar(Employee_Worked_Hours employee_worked_hours) {
		return employee_worked_hoursDao.findById(employee_worked_hours.getId()).orElseThrow();
	}

	@Override
	public List listar() {
		return (List) employee_worked_hoursDao.findAll();
	}

	
	
}	
