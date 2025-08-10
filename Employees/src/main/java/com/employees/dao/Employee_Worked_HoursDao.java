package com.employees.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employees.dominio.Employee_Worked_Hours;

@Repository
public interface Employee_Worked_HoursDao extends CrudRepository<Employee_Worked_Hours, Integer>{

}
