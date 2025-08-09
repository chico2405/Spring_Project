package com.example.biblioteca.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Criar_Livro_DTO {
    @NotNull
    @NotBlank
    private String titulo;

    @NotNull
    @NotBlank
    private String autor;

    @NotNull
    @Min(1800)
    @Max(2200)
    private Integer Ano_Publi;

    @NotNull
    @Min(1)
    private Integer quantidadeExemplares;
}
