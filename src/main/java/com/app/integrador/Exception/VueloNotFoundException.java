package com.app.integrador.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code =  HttpStatus.NOT_FOUND, reason = "vuelo not found")
public class VueloNotFoundExcepcion extends RuntimeException {
}
