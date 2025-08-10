package com.employees.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employees.dominio.Genders;

@Repository
public interface GendersDao extends CrudRepository<Genders, Integer>{

}
