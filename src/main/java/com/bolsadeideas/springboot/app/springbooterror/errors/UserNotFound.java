package com.bolsadeideas.springboot.app.springbooterror.errors;

public class UserNotFound extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserNotFound(String id) {
        super("El usuario con el id: ".concat(id).concat(" no existe"));
    }
    
}