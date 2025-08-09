package com.example.biblioteca.DTO;

import com.example.biblioteca.entidades.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User_DTO {
    @NotNull
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String email;

    public User_DTO(User user) {
        this.id = user.getId();
        this.nome = user.getNome();
        this.email = user.getEmail();
    }
}
