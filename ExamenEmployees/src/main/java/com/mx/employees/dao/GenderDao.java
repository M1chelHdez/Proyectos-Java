package com.mx.employees.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.employees.entidad.Genders;

@Repository
public interface GenderDao extends JpaRepository<Genders, Integer> {

}
