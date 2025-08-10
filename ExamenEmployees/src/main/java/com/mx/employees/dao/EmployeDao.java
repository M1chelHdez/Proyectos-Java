package com.mx.employees.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.employees.entidad.Employees;

@Repository
public interface EmployeDao extends JpaRepository<Employees, Integer> {

}
