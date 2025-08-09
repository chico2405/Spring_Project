package com.example.biblioteca.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Devolucao_DTO {
    @NotNull
    @Min(1)
    @NotBlank
    private Long id_User;

    @NotNull
    @Min(1)
    @NotBlank
    private Long id_exemplar;

    }
