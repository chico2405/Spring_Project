package com.example.biblioteca.services;

import com.example.biblioteca.entidades.Emprestimo;
import com.example.biblioteca.entidades.Exemplares;
import com.example.biblioteca.entidades.Livro;
import com.example.biblioteca.entidades.User;
import com.example.biblioteca.exeptions.NotFound;
import com.example.biblioteca.repositorios.Emp_rep;
import com.example.biblioteca.repositorios.Exemp_rep;
import com.example.biblioteca.repositorios.Livro_rep;
import com.example.biblioteca.repositorios.User_rep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Dev_Service {

    @Autowired
    private Emp_rep repoEmp;

    @Autowired
    private Exemp_rep repoExemplar;

    @Autowired
    private User_rep repoUser;

    @Autowired
    private Livro_rep repoLivro;

    public void Devolver_Livro (Long exemplarID, Long userID){
        User usuario = repoUser.findById(userID).orElseThrow(() -> new NotFound("Usuário Não Encontrado"));
        Exemplares exemplar = repoExemplar.findById(exemplarID).orElseThrow(() -> new NotFound("Exemplar não existente"));
        Livro livro = exemplar.get_livro();
        exemplar.setEmprestado(false);
        repoExemplar.save(exemplar);
        if (!livro.isDisponivel()){
            livro.setDisponivel(true);
            repoLivro.save(livro);
        }
        Emprestimo emprestimo = repoEmp.findByExemplar_IdAndUsuario_IdAndDevolvidoFalse(exemplarID, userID);
        emprestimo.setDevolvido(true);
        repoEmp.save(emprestimo);


    }

}
