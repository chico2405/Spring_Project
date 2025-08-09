package com.example.biblioteca.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class Deletar_Livro_Emprestado extends RuntimeException {
        public Deletar_Livro_Emprestado(String message) {
            super(message);
        }
    }

