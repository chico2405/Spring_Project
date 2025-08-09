package com.example.biblioteca.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User_Update_DTO {
    @NotBlank(message = "O nome não pode estar em branco.")
    private String nome;

    @NotBlank(message = "O email não pode estar em branco.")
    @Email(message = "Formato de email inválido.")
    private String email;

    @NotBlank(message = "A senha não pode estar em branco.")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres.")
    private String password;

    @NotEmpty(message = "O usuário deve ter pelo menos uma role (ex: USER, ADMIN).")
    private List<String> roles;
}
