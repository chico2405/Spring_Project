package com.example.biblioteca.services;

import com.example.biblioteca.entidades.Emprestimo;
import com.example.biblioteca.entidades.Exemplares;
import com.example.biblioteca.entidades.Livro;
import com.example.biblioteca.entidades.User;
import com.example.biblioteca.exeptions.EmprestimoAtrasado;
import com.example.biblioteca.exeptions.Livro_Repetido_Exception;
import com.example.biblioteca.exeptions.NotFound;
import com.example.biblioteca.repositorios.Emp_rep;
import com.example.biblioteca.repositorios.Exemp_rep;
import com.example.biblioteca.repositorios.Livro_rep;
import com.example.biblioteca.repositorios.User_rep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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

    public void Fazer_Emp (Long idExemplar, Long idUser){
        Exemplares exemplar  = repoExemplar.findById(idExemplar).orElseThrow(() -> new NotFound("Livro Não Encontrado"));
        Livro livro = exemplar.get_livro();
        User usuario = repoUser.findById(idUser).orElseThrow(() -> new NotFound("Usuário Não Encontrado"));
        if (repoEmp.existsByUsuario_IdAndDevolvidoFalseAndDataDevBefore(idUser, LocalDate.now())){
            throw new EmprestimoAtrasado("Usuário tem empréstimo atrasado");
        }
        if (repoEmp.existsByUsuarioIdAndExemplarLivroIdAndDevolvidoFalse(idUser, livro)){
            throw new Livro_Repetido_Exception("Usuário já tem um empréstimo desse livro");
        }
        exemplar.setEmprestado(true);
        repoExemplar.save(exemplar);
        Emprestimo emp = new Emprestimo();
        emp.setExemplar(exemplar);
        emp.setUsuario(usuario);
        emp.setData_emprestimo(LocalDate.now());
        emp.setData_dev(LocalDate.now().plusDays(7));
        if (!repoExemplar.existsByLivro_Id_AndEmprestadoIsFalse(livro.getId())){
            livro.setDisponivel(false);
            repoLivro.save(livro);
        }
        repoEmp.save(emp);

    }



}
