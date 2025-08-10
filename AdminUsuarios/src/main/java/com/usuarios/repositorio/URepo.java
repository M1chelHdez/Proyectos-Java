package com.usuarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usuarios.entidad.Usuario;

@Repository
public interface URepo extends JpaRepository<Usuario, Integer>{

}
