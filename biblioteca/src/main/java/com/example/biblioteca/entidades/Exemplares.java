package com.example.biblioteca.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Exemplares {
    @Id
    @GeneratedValue
    private Long id_exemplar;

    @ManyToOne
    private Livro livro;

    private boolean emprestado = false;

    public boolean isEmprestado() {
        return emprestado;
    }

    public Livro get_livro() {
        return livro;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }
}