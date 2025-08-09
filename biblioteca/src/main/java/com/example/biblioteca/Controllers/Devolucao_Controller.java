package com.example.biblioteca.Controllers;

import com.example.biblioteca.DTO.Emprestimo_Request_DTO;
import com.example.biblioteca.services.Dev_Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/devolver")
public class Devolucao_Controller {

    @Autowired
    private Dev_Service devService;

    @PostMapping
    public ResponseEntity<Void> devolverLivro(@Valid @RequestBody Emprestimo_Request_DTO requestDTO) {


        devService.Devolver_Livro(requestDTO.getId_exemplar(), requestDTO.getId_User());

        return ResponseEntity.ok().build();
    }

}