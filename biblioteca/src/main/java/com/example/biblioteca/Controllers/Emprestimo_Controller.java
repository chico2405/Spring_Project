
package com.example.biblioteca.Controllers;

import com.example.biblioteca.DTO.Emprestimo_Request_DTO;
import com.example.biblioteca.services.Emp_Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emprestimos")
public class Emprestimo_Controller {

    @Autowired
    private Emp_Service emprestimoService;

    @PostMapping
    public ResponseEntity<Void> realizarEmprestimo(@Valid @RequestBody Emprestimo_Request_DTO requestDTO) {


        emprestimoService.Fazer_Emp(requestDTO.getId_exemplar(), requestDTO.getId_User());

        return ResponseEntity.ok().build();
    }

}