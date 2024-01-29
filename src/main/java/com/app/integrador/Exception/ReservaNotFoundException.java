package com.app.integrador.Excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code =  HttpStatus.NOT_FOUND, reason = "reserva not found")
public class ReservaNotFoundException extends RuntimeException{
}
