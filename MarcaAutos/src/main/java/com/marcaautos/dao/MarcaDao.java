package com.marcaautos.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marcaautos.dominio.Marca;

@Repository
public interface MarcaDao extends CrudRepository<Marca, Integer>{

}
