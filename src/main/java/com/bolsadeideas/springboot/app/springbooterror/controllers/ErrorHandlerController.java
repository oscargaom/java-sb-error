package com.bolsadeideas.springboot.app.springbooterror.controllers;

import java.util.Date;

import com.bolsadeideas.springboot.app.springbooterror.errors.UserNotFound;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController {
    
    @ExceptionHandler({ArithmeticException.class})
    public String arithmeticError(ArithmeticException ex, Model model){

        model.addAttribute("error", "Error de aritmetica");
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());
        return "error/aritmetica";
    }

    @ExceptionHandler({NumberFormatException.class})
    public String formatError(NumberFormatException ex, Model model){

        model.addAttribute("error", "Error de formato");
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());
        return "error/formato";
    }

    @ExceptionHandler(UserNotFound.class)
    public String usernotFound(UserNotFound userNotFound, Model model){
        model.addAttribute("error", "Usuario no encontrado");
        model.addAttribute("message", userNotFound.getMessage());
        return "error/userNotFound";
    }
}