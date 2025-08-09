package com.example.biblioteca.repositorios;

import com.example.biblioteca.entidades.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Livro_rep extends JpaRepository<Livro, Long> {
    public Livro findByTitulo(String titulo);
}
