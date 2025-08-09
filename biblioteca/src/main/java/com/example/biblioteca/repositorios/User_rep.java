package com.example.biblioteca.repositorios;

import com.example.biblioteca.entidades.Livro;
import com.example.biblioteca.entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface User_rep extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}