package com.example.biblioteca.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Usuário já possui um empréstimo ativo para este mesmo livro.")
public class Livro_Repetido_Exception extends RuntimeException {
    public Livro_Repetido_Exception(String message) {
        super(message);
    }
}
