package com.example.biblioteca.repositorios;

import com.example.biblioteca.entidades.Emprestimo;
import com.example.biblioteca.entidades.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
@Repository
public interface Emp_rep extends JpaRepository<Emprestimo, Long> {
    public boolean existsByUsuario_IdAndDevolvidoFalseAndDataDevBefore(Long usuarioId, LocalDate hoje);
    public Emprestimo findByExemplar_IdAndUsuario_IdAndDevolvidoFalse(Long exemplarId, Long usuarioId);
    public boolean existsByUsuarioIdAndExemplarLivroIdAndDevolvidoFalse(Long usuarioId, Livro livro);

}