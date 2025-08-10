package com.mx.Patito.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Patito.entidad.Auditoria;
@Repository
public interface AuditoriaDao extends JpaRepository<Auditoria ,Integer>{

}
