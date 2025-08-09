package com.example.biblioteca.exeptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Erro> trataExcecaoGenerica(Exception e) {
        String mensagem = e.getMessage();
        if (e instanceof MethodArgumentTypeMismatchException) {
            mensagem = "Tipo inválido";
        }
        Erro erro = new Erro(mensagem, 400);
        e.printStackTrace();
        return ResponseEntity.badRequest().body(erro);
    }

    @ExceptionHandler
    public ResponseEntity<Erro> trataEmprestimoAtrasado(EmprestimoAtrasado e) {
        Erro erro = new Erro(e.getMessage(), HttpStatus.FORBIDDEN.value());
        e.printStackTrace();
        return new ResponseEntity<>(erro, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler
    public ResponseEntity<Erro> trataDeletarLivroEmprestado(Deletar_Livro_Emprestado e) {
        Erro erro = new Erro(e.getMessage(), HttpStatus.FORBIDDEN.value());
        e.printStackTrace(); //
        return new ResponseEntity<>(erro, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler
    public ResponseEntity<Erro> trataLivroJaEmprestado(Livro_Repetido_Exception e) {
        Erro erro = new Erro(e.getMessage(), HttpStatus.CONFLICT.value()); // Status 409
        e.printStackTrace();
        return new ResponseEntity<>(erro, HttpStatus.CONFLICT);
    }
    
    @ExceptionHandler
    public ResponseEntity<Erro> trataNotFound(NotFound e) {
        Erro erro = new Erro(e.getMessage(), 404);
        e.printStackTrace();
        return ResponseEntity.badRequest().body(erro);
    }
}
