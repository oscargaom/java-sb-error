package com.bolsadeideas.springboot.app.springbooterror.services;

import java.util.List;
import java.util.Optional;

import com.bolsadeideas.springboot.app.springbooterror.models.domain.Usuario;

public interface UsuarioService {
    
    public List<Usuario> listar();

    public Usuario obtenerPorId(Integer id);

    public Optional<Usuario> obtenerPorIdOpt(Integer id);
}