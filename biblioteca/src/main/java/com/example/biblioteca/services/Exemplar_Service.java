package com.example.biblioteca.services;

import com.example.biblioteca.DTO.Criar_Exemplar_DTO;
import com.example.biblioteca.DTO.Exemplar_DTO;
import com.example.biblioteca.entidades.Exemplares;
import com.example.biblioteca.entidades.Livro;
import com.example.biblioteca.exeptions.NotFound;
import com.example.biblioteca.repositorios.Exemp_rep;
import com.example.biblioteca.repositorios.Livro_rep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Exemplar_Service {
    @Autowired
    private Exemp_rep exempRepo;

    @Autowired Livro_rep livro_rep;

    public Exemplar_DTO add_exemplar(Criar_Exemplar_DTO dados) {
        Livro livro = livro_rep.findById(dados.getLivroId())
                .orElseThrow(() -> new NotFound("Livro com ID " + dados.getLivroId() + " não encontrado."));
        Exemplares novoExemplar = new Exemplares();
        novoExemplar.setLivro(livro);
        Exemplares exemplarSalvo = exempRepo.save(novoExemplar);
        return new Exemplar_DTO(exemplarSalvo);

    }

    public List<Exemplar_DTO> listarTodos(){
        List<Exemplares> exemp = exempRepo.findAll();
        return exemp.stream()
                .map(Exemplar_DTO::new)
                .collect(Collectors.toList());
    }
}
