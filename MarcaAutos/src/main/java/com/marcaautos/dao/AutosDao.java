package com.marcaautos.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marcaautos.dominio.Autos;

@Repository
public interface AutosDao extends CrudRepository<Autos, Integer>{

}
