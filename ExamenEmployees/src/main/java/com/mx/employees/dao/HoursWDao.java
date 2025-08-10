package com.mx.employees.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.employees.entidad.EmployeeWorked;

@Repository
public interface HoursWDao extends JpaRepository<EmployeeWorked, Integer> {

}
