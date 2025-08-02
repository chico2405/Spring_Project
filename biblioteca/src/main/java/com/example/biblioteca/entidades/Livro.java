package com.example.biblioteca.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Livro {
    @Id @GeneratedValue
    private Long id;
    private String titulo;
    private String autor;
    private Integer Ano_Publi;
    private boolean disponivel = true;
    @OneToMany(mappedBy = "livro")
    private List<Exemplares> exemplares;

    public Long getId() {
        return id;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
