package com.example.biblioteca.Controllers;
import com.example.biblioteca.DTO.Criar_Exemplar_DTO;
import com.example.biblioteca.DTO.Exemplar_DTO;
import com.example.biblioteca.services.Exemplar_Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exemplares")
public class Exemplar_Controller {
    @Autowired
    Exemplar_Service exemplar_service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Exemplar_DTO> AdicionarExemplar(@Valid @RequestBody Criar_Exemplar_DTO dto){
        Exemplar_DTO dtoex = exemplar_service.add_exemplar(dto);
        return ResponseEntity.ok(dtoex);
    }

    @GetMapping
    public ResponseEntity<List<Exemplar_DTO>> lisarExemplares(){
        List<Exemplar_DTO> dto = exemplar_service.listarTodos();
        return ResponseEntity.ok(dto);
    }
}
