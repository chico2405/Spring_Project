package com.example.biblioteca.DTO;

import com.example.biblioteca.entidades.Livro;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;


@Getter
public class Criar_Exemplar_DTO {
    @NotNull
    private Long livroId;
}
