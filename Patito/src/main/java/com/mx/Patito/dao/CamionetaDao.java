package com.mx.Patito.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.Patito.entidad.Camioneta;
@Repository
public interface CamionetaDao extends JpaRepository<Camioneta, String> {
	boolean existsByMarca(String marca);
	boolean existsByModelo(String modelo);
	
	@Query(nativeQuery = true, value = "SELECT * FROM TRUCK WHERE STOCK > 1")
    List<Camioneta> findByALLCamioneta();
	
}
