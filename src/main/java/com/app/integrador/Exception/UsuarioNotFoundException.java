package com.app.integrador.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code =  HttpStatus.NOT_FOUND, reason = "usuario not found")
public class UsuarioNotFoundExcepcion extends RuntimeException{
}
