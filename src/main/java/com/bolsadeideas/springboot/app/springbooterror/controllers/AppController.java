package com.bolsadeideas.springboot.app.springbooterror.controllers;

import com.bolsadeideas.springboot.app.springbooterror.errors.UserNotFound;
import com.bolsadeideas.springboot.app.springbooterror.models.domain.Usuario;
import com.bolsadeideas.springboot.app.springbooterror.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppController {

    @Autowired
    private UsuarioService usuarioService;

    @SuppressWarnings("unused")
    @GetMapping("/index")
    public String index() {
        // int x = 100 / 0;
        Integer numero = Integer.parseInt("10xAf");
        numero *= 10;
        return "index";
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Integer id, Model model) {
        // Usuario usuario = usuarioService.obtenerPorId(id);

        // if (usuario == null) {
        //     throw new UserNotFound(id.toString());
        // }

        Usuario usuario = usuarioService.obtenerPorIdOpt(id).orElseThrow(() -> new UserNotFound(id.toString()));

        model.addAttribute("user", usuario);
        model.addAttribute("titulo", "Detalle del usuario".concat(usuario.getNombre()));

        return "ver";
    }
}
