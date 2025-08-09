package com.example.biblioteca.config;

import com.example.biblioteca.DTO.Criar_Livro_DTO;
import com.example.biblioteca.DTO.User_Update_DTO;
import com.example.biblioteca.entidades.Livro;
import com.example.biblioteca.entidades.User;
import com.example.biblioteca.repositorios.Livro_rep;
import com.example.biblioteca.repositorios.User_rep;
import com.example.biblioteca.services.Livro_Services;
import com.example.biblioteca.services.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private User_rep userRepository;

    @Autowired
    private Livro_rep livroRepository;


    @Autowired
    private Livro_Services livro_Services;

    @Autowired
    private User_Service  userService;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            System.out.println("Criando usuários de exemplo via serviço...");


            User_Update_DTO adminDto = new User_Update_DTO();
            adminDto.setNome("Admin User");
            adminDto.setEmail("admin@email.com");
            adminDto.setPassword("password");
            adminDto.setRoles(List.of("ADMIN", "USER"));
            userService.Criar_User(adminDto);

            User_Update_DTO userDto = new User_Update_DTO();
            userDto.setNome("Common User");
            userDto.setEmail("user@email.com");
            userDto.setPassword("password");
            userDto.setRoles(List.of("USER"));
            userService.Criar_User(userDto);

            System.out.println("Usuários de exemplo criados.");
        }

        if (livroRepository.count() == 0) {
                Criar_Livro_DTO livro1 = new Criar_Livro_DTO();
                livro1.setTitulo("O Senhor dos Anéis");
                livro1.setAutor("J.R.R. Tolkien");
                livro1.setAno_Publi(1954);
                livro1.setQuantidadeExemplares(3);
                livro_Services.add_Livro(livro1);

                Criar_Livro_DTO livro2 = new Criar_Livro_DTO();
                livro2.setTitulo("1984");
                livro2.setAutor("George Orwell");
                livro2.setAno_Publi(1949);
                livro2.setQuantidadeExemplares(2);
                livro_Services.add_Livro(livro2);

                System.out.println("Livros de exemplo criados.");
            }
        else {
            System.out.println("O banco de dados já contém dados. Nenhuma ação foi tomada.");
        }
    }
}
