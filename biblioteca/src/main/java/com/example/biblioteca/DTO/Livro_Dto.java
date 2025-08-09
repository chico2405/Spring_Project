package com.example.biblioteca.DTO;

import com.example.biblioteca.entidades.Livro;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Livro_Dto {
    @Id
    private Long id;

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

    public Livro_Dto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.Ano_Publi = livro.getAno_Publi();
        this.autor = livro.getAutor();
    }
}
