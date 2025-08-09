package com.example.biblioteca.services;

import com.example.biblioteca.DTO.Criar_Livro_DTO;
import com.example.biblioteca.DTO.Disponibilidade_DTO;
import com.example.biblioteca.DTO.Livro_Dto;
import com.example.biblioteca.entidades.Exemplares;
import com.example.biblioteca.entidades.Livro;
import com.example.biblioteca.exeptions.Deletar_Livro_Emprestado;
import com.example.biblioteca.exeptions.NotFound;
import com.example.biblioteca.repositorios.Exemp_rep;
import com.example.biblioteca.repositorios.Livro_rep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Livro_Services {
    @Autowired
    private Livro_rep livro_rep;

    @Autowired
    private Exemp_rep exemp_rep;

    public List<Livro_Dto> listarTodos() {
        List<Livro> livros = livro_rep.findAll();
        return livros.stream()
                .map(Livro_Dto::new)
                .collect(Collectors.toList());
    }

    public Livro_Dto add_Livro(Criar_Livro_DTO dados) {
        Livro novoLivro = new Livro();
        novoLivro.setAno_Publi(dados.getAno_Publi());
        novoLivro.setTitulo(dados.getTitulo());
        novoLivro.setAutor(dados.getAutor());
        Livro livroSalvo = livro_rep.save(novoLivro);

        List<Exemplares> novosExemplares = new ArrayList<>();
        for (int i = 0; i < dados.getQuantidadeExemplares(); i++) {
            Exemplares novoExemplar = new Exemplares();
            novoExemplar.setLivro(livroSalvo);
            novosExemplares.add(novoExemplar);
        }
        exemp_rep.saveAll(novosExemplares);
        return new Livro_Dto(livroSalvo);
    }

    public Disponibilidade_DTO Checar_Livro_Disponivel(Long id_livro){
        Livro livro = livro_rep.findById(id_livro)
                .orElseThrow(() -> new NotFound("Livro com ID " + id_livro + " não encontrado."));

        String mensagem;
        Integer exemplares = exemp_rep.countByLivro_Id_AndEmprestadoIsFalse(id_livro);
        if (exemplares > 0) {
            mensagem = "Livro Disponível. Exemplares:  " + exemplares;
        }
        else {
            mensagem = "Livro Indisponível";
        }
        return new Disponibilidade_DTO( mensagem, exemplares);

    }

    public Livro_Dto Delete_Livro_Disponivel(Long id_livro){
        Livro livro = livro_rep.findById(id_livro)
                .orElseThrow(() -> new NotFound("Livro com ID " + id_livro + " não encontrado."));
        if (livro.isDisponivel()){
            throw new Deletar_Livro_Emprestado("Livro com exemplares não devolvidos");
        }
        exemp_rep.deleteByLivro_Id_AndEmprestadoIsFalse(id_livro);
        livro_rep.delete(livro);
        return new Livro_Dto(livro);

    }
}
