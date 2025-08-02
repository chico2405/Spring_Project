package com.example.biblioteca.repositorios;

import com.example.biblioteca.entidades.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Livro_rep extends JpaRepository<Livro, Long> {
}
