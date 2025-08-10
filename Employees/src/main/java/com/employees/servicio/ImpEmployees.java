package com.employees.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employees.dao.EmployeesDao;
import com.employees.dominio.Employees;

@Service
public class ImpEmployees implements MetodosEmployees {

	@Autowired
	EmployeesDao employeesDao;
	
	@Autowired
	ImpGenders impG;
	
	@Autowired
	ImpJobs impJ;

	@Override
	public void guardar(Employees employees) {
		
		List<Employees> lista = new ArrayList<Employees>();
		lista = (List<Employees>) employeesDao.findAll();
		if (lista.isEmpty()) {
			employeesDao.save(employees);
		} else {
			for (Employees e : lista) {
				if (e.getName().equals(e.getName())) {
					if (e.getLast_name().equals(e.getLast_name())) {
					} else {
						System.out.println("Ya existe una empleado con ese nombre");
						return;
					}
				}
			}
			
			employeesDao.save(employees);
		}

	}

	@Override
	public void editar(Employees employees) {
		employeesDao.save(employees);

	}

	@Override
	public void eliminar(Employees employees) {
		employeesDao.delete(employees);
	}

	@Override
	public Employees buscar(Employees employees) {
		employees = employeesDao.findById(employees.getId()).orElseThrow();
		return employees;
	}

	@Override
	public List<Employees> listar() {
		return (List<Employees>) employeesDao.findAll();
	}

	@Override
	public Employees buscarNombre(Employees employees) {
		Employees e = new Employees();
		if (employees.getName() != null) {
			e = employeesDao.findByNombre(employees.getName());
		}
		return e;
	}
	
	@Override
	public Employees buscarId(int id) {
		return employeesDao.findById(id).orElseThrow(() -> new RuntimeException("No existe empleado"));
	}

	public Employees buscarNombre(String acta) {
		return employeesDao.findByNombre(acta);
	}

}
