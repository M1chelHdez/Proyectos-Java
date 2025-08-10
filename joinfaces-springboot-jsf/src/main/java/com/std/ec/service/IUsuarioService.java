package com.std.ec.service;

import com.std.ec.model.entity.Usuario;

import java.util.List;

public interface IUsuarioService {

    public Usuario guardar(Usuario usuario);
    public Usuario buscarPorId(Integer id);
    public List<Usuario> listar();
    void eliminar(Usuario usuario);
}
