package com.example.biblioteca.DTO;

import com.example.biblioteca.entidades.Exemplares;
import com.example.biblioteca.entidades.Livro;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

public class Exemplar_DTO {
    @Id
    @NotNull
    private Long id;


    @NotNull
    private Long livroId;

    public Exemplar_DTO(Exemplares exemplar) {
        this.id = exemplar.getId();
        this.livroId = exemplar.getLivro().getId();
    }
}
