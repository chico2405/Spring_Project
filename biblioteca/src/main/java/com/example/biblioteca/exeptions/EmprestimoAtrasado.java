package com.example.biblioteca.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Usuário possui empréstimos com devolução atrasada.")
public class EmprestimoAtrasado extends RuntimeException {
        public EmprestimoAtrasado(String message) {
            super(message);
        }
    }


