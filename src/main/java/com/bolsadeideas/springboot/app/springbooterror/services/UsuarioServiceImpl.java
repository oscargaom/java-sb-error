package com.bolsadeideas.springboot.app.springbooterror.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bolsadeideas.springboot.app.springbooterror.models.domain.Usuario;

import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioServiceImpl() {
        usuarios.add(new Usuario(1, "Daniel", "García"));
        usuarios.add(new Usuario(2, "David", "González"));
        usuarios.add(new Usuario(3, "Gabriel", "Rodríguez"));
        usuarios.add(new Usuario(4, "Julia", "Pérez"));
        usuarios.add(new Usuario(5, "Camila", "Gómez"));
        usuarios.add(new Usuario(6, "Alexandra", "Martin"));
        usuarios.add(new Usuario(7, "Maya", "Jiménez"));
    }

    @Override
    public List<Usuario> listar() {
        return usuarios;
    }

    @Override
    public Usuario obtenerPorId(Integer id) {
        return usuarios.stream().filter(p -> p.getId().equals(id)).findAny().orElse(null);
    }

    @Override
    public Optional<Usuario> obtenerPorIdOpt(Integer id) {
        Usuario usuario = obtenerPorId(id);

        return Optional.ofNullable(usuario);
    }
}