package com.employees.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employees.dominio.Employees;


@Repository
public interface EmployeesDao extends CrudRepository<Employees, Integer>{

	@Query(nativeQuery = true, value = "SELECT * FROM EMPLOYEES E WHERE E.NAME=:NAME")
	Employees findByNombre(@Param("NAME") String name);
}
