package com.example.biblioteca.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Exemplares {
    @Id
    @GeneratedValue
    private Long id_exemplar;
    private Long id_livro;
    private String titulo_livro;
    private String autor;
    private Integer Ano_Publi;
    private boolean emprestado = false;

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }
}