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

import java.util.Optional;

@Service
public class Emp_Service {
    @Autowired
    private Emp_rep repoEmp;
    @Autowired
    private Exemp_rep repoExemplar;
    @Autowired
    private User_rep repoUser;

    public void Fazer_Emp (Long idExemplar, Long idUser){
        Exemplares exemplar = repoExemplar.findById(idExemplar).orElseThrow(() -> new RuntimeException("Livro Não Encontrado"));
        if (exemplar.isEmprestado()){
            throw new RuntimeException("Livro já Emprestado");
        }
        User usuario = repoUser.findById(idUser).orElseThrow(() -> new RuntimeException("Usuário Não Encontrado"));

        exemplar.setEmprestado(true);
        repoExemplar.save(exemplar);
        Emprestimo emp = new Emprestimo();
        emp.setExemplar(exemplar);
        emp.setUsuario(usuario);
        emp.setData_emprestimo(Local);
    }

}
