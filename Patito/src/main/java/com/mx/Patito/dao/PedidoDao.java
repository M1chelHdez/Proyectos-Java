package com.mx.Patito.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Patito.entidad.Pedido;
@Repository
public interface PedidoDao extends JpaRepository<Pedido, String>{
	boolean existsByNombrec(String nombrec);
}
