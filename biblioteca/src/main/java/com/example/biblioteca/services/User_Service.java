package com.example.biblioteca.services;

import com.example.biblioteca.DTO.User_Update_DTO;
import com.example.biblioteca.DTO.User_DTO;
import com.example.biblioteca.entidades.Role;
import com.example.biblioteca.entidades.User;
import com.example.biblioteca.exeptions.NotFound;
import com.example.biblioteca.repositorios.User_rep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class User_Service {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private User_rep userRepository;

    public List<User_DTO> listarTodos() {
        List<User> usuarios = userRepository.findAll();
        return usuarios.stream()
                .map(User_DTO::new)
                .collect(Collectors.toList());
    }

    public User_DTO findByEmail(String email) {

        User usuario = userRepository.findByEmail(email);
        if (usuario == null){
            throw new NotFound("Usuario com email" +  email + "não encontrado");
        }
        return new User_DTO(usuario);
    }

    public User_DTO Criar_User(User_Update_DTO dados) {
        User novoUser = new User();
        novoUser.setNome(dados.getNome());
        novoUser.setEmail(dados.getEmail());
        Set<Role> roles = dados.getRoles().stream()
                .map(Role::valueOf)
                .collect(Collectors.toSet());
        novoUser.setRoles(roles);
        novoUser.setPassword(passwordEncoder.encode(dados.getPassword()));
        userRepository.save(novoUser);
        return new User_DTO(novoUser);
    }

    public void Delete_User (Long id) {
        userRepository.deleteById(id);
    }

    public void update(long id, User_Update_DTO dto) {
        User usuario = userRepository.findById(id)
                .orElseThrow(() -> new NotFound("Operação de atualização falhou. Não existe usuário com id = " + id));

        if (dto.getNome() != null && !dto.getNome().isBlank()) {
            usuario.setNome(dto.getNome());
        }

        if (dto.getEmail() != null && !dto.getEmail().isBlank()) {
            usuario.setEmail(dto.getEmail());
        }

        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        }


        userRepository.save(usuario);

    }
}

