package com.example.biblioteca.Controllers;
import com.example.biblioteca.DTO.User_Update_DTO;
import com.example.biblioteca.DTO.User_DTO;
import com.example.biblioteca.services.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class Usuarios_Controller {
    @Autowired
    User_Service userService;

    @GetMapping
    public ResponseEntity<List<User_DTO>> listarTodos() {
        List<User_DTO> usuarios = userService.listarTodos();

        return ResponseEntity.ok(usuarios);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User_DTO> cadastrar(@RequestBody User_Update_DTO userDTO) {
        User_DTO response = userService.Criar_User(userDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        userService.Delete_User(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Long id, @RequestBody User_Update_DTO userDTO) {
        userService.update(id, userDTO);
    }
}
