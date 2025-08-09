package com.example.biblioteca.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class Livro_Repetido_Exception extends RuntimeException {
    public Livro_Repetido_Exception(String message) {
        super(message);
    }
}
