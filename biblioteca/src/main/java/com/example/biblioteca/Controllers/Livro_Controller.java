package com.example.biblioteca.Controllers;

import com.example.biblioteca.DTO.Criar_Livro_DTO;
import com.example.biblioteca.DTO.Disponibilidade_DTO;
import com.example.biblioteca.DTO.Livro_Dto;
import com.example.biblioteca.services.Livro_Services;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class Livro_Controller {

    @Autowired
    Livro_Services livroService;

    @GetMapping
    public ResponseEntity<List<Livro_Dto>> listarTodos() {

        List<Livro_Dto> titulos = livroService.listarTodos();

        return ResponseEntity.ok(titulos);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> AdicionarLivro(@Valid @RequestBody Criar_Livro_DTO dto){
        livroService.add_Livro(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/disponibilidade")
    public ResponseEntity<Disponibilidade_DTO> checarLivro(@PathVariable Long id){
        Disponibilidade_DTO dto = livroService.Checar_Livro_Disponivel(id);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Livro_Dto> removerLivro(@PathVariable Long id){
        Livro_Dto deletado_dto = livroService.Delete_Livro_Disponivel(id);
        return ResponseEntity.ok(deletado_dto);
    }


}