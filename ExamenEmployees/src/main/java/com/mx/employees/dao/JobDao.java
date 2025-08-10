package com.mx.employees.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.employees.entidad.Jobs;

@Repository
public interface JobDao extends JpaRepository<Jobs, Integer> {

}
