package com.employees.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employees.dominio.Jobs;

@Repository
public interface JobsDao extends CrudRepository<Jobs, Integer>{

}
