package com.example.biblioteca.services;

import com.example.biblioteca.entidades.Emprestimo;
import com.example.biblioteca.entidades.Exemplares;
import com.example.biblioteca.entidades.Livro;
import com.example.biblioteca.entidades.User;
import com.example.biblioteca.repositorios.Emp_rep;
import com.example.biblioteca.repositorios.Exemp_rep;
import com.example.biblioteca.repositorios.Livro_rep;
import com.example.biblioteca.repositorios.User_rep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class Emp_Service {
    @Autowired
    private Emp_rep repoEmp;
    @Autowired
    private Exemp_rep repoExemplar;
    @Autowired
    private User_rep repoUser;

    @Autowired
    private Livro_rep repoLivro;

    public void Fazer_Emp (Long idLivro, Long idUser){
        Livro livro  = repoLivro.findById(idLivro).orElseThrow(() -> new RuntimeException("Livro Não Encontrado"));
        if (!livro.isDisponivel()){
            throw new RuntimeException("Sem exemplares");
        }
        User usuario = repoUser.findById(idUser).orElseThrow(() -> new RuntimeException("Usuário Não Encontrado"));
        Exemplares exemplar = repoExemplar.findFirstByLivroIdAndEmprestadoFalse(idLivro);
        exemplar.setEmprestado(true);
        repoExemplar.save(exemplar);
        Emprestimo emp = new Emprestimo();
        emp.setExemplar(exemplar);
        emp.setUsuario(usuario);
        emp.setData_emprestimo(LocalDate.now());
        emp.setData_dev(LocalDate.now().plusDays(7));
        if (!repoExemplar.exists_ByLivroId_AndEmprestadoIsFalse(idLivro)){
            livro.setDisponivel(false);
            repoLivro.save(livro);
        }
        repoEmp.save(emp);

    }

}
