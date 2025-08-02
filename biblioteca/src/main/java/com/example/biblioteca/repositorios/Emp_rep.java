package com.example.biblioteca.repositorios;

import com.example.biblioteca.entidades.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Emp_rep extends JpaRepository<Emprestimo, Long> {
}