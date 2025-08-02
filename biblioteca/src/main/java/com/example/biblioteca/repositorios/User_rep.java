package com.example.biblioteca.repositorios;

import com.example.biblioteca.entidades.Livro;
import com.example.biblioteca.entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_rep extends JpaRepository<User, Long> {
}