package com.example.biblioteca.repositorios;

import com.example.biblioteca.entidades.Exemplares;
import com.example.biblioteca.entidades.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Exemp_rep extends JpaRepository<Exemplares, Long> {
    Exemplares findFirstByLivroIdAndEmprestadoFalse(Long livroID);
    boolean exists_ByLivroId_AndEmprestadoIsFalse(Long livroID);
}