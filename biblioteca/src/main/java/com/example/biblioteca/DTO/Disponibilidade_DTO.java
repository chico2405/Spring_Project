package com.example.biblioteca.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Disponibilidade_DTO {
    @NotNull
    @Min(0)
    private Integer exemplares_disponiveis;

    @NotNull
    @NotBlank
    private String mensagem;

    public Disponibilidade_DTO(String mensagem, Integer exemplares) {
        this.mensagem = mensagem;
        this.exemplares_disponiveis = exemplares;
    }
}
