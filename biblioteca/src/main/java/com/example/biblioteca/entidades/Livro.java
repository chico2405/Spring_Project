package com.example.biblioteca.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Livro {
    @Id @GeneratedValue
    private Long id;
    private String titulo;
    private String autor;
    private Integer Ano_Publi;
    private boolean disponivel = true;

    public boolean isDisponivel() {
        return disponivel;
    }
}
