package com.example.biblioteca.DTO;

import com.example.biblioteca.entidades.Exemplares;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class Exemplar_DTO {

    @Id
    @NotNull
    private Long id;

    private final String livroTitulo;

    @NotNull
    private Long livroId;

    private String status;

    public Exemplar_DTO(Exemplares exemplar) {
        this.id = exemplar.getId();
        this.livroId = exemplar.getLivro().getId();
        this.livroTitulo = exemplar.get_livro().getTitulo();
        if (exemplar.isEmprestado()){
            this.status = "Emprestado";
        }
        else{
            this.status = "Disponível";
        }
    }
}
