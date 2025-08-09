package com.example.biblioteca.repositorios;

import com.example.biblioteca.entidades.Exemplares;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Exemp_rep extends JpaRepository<Exemplares, Long> {
    public boolean existsByLivro_Id_AndEmprestadoIsFalse(Long livroID);
    public boolean existsByLivro_Id_AndEmprestadoIsTrue(Long livroID);
    public Integer countByLivro_Id_AndEmprestadoIsFalse(Long livroId);
    public void deleteByLivro_Id_AndEmprestadoIsFalse(Long livroId);
}