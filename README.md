# API de Gerenciamento de Biblioteca

Este projeto é uma API RESTful completa para o gerenciamento de uma biblioteca, desenvolvida com Spring Boot. A aplicação permite o controle de livros, usuários, exemplares e o sistema de empréstimos e devoluções, com autenticação e autorização baseadas em papéis (Roles).

## Principais Funcionalidades

- **Gerenciamento de Usuários**: Autenticação e autorização com papéis (ADMIN, USER), permitindo criar, listar, atualizar e deletar usuários com endpoints protegidos.
- **Gerenciamento de Livros e Exemplares**: Cadastro de novos livros e seus respectivos exemplares (cópias), com listagem e verificação de disponibilidade.
- **Sistema de Empréstimos e Devoluções**: Endpoints para realizar empréstimos e devoluções, aplicando regras de negócio como o bloqueio de novos empréstimos para usuários com pendências ou a prevenção de empréstimos duplicados do mesmo livro.
- **Base de Dados**: Utiliza o banco de dados em memória H2, com uma carga de dados iniciais (usuários e livros) para facilitar os testes na primeira execução.

## Endpoints

| Método HTTP | Endpoint                         | Descrição                                                      | Autorização    |
|-------------|----------------------------------|----------------------------------------------------------------|----------------|
| POST        | `/usuarios`                      | Cadastra um novo usuário.                                      | Permitido para todos |
| GET         | `/usuarios`                      | Lista todos os usuários.                                       | ADMIN          |
| DELETE      | `/usuarios/{id}`                 | Deleta um usuário pelo ID.                                     | ADMIN          |
| PUT         | `/usuarios/{id}`                 | Atualiza um usuário pelo ID.                                   | ADMIN          |
| GET         | `/livros`                         | Lista todos os livros.                                         | Permitido para todos |
| POST        | `/livros`                         | Adiciona um novo livro.                                        | ADMIN          |
| GET         | `/livros/{id}/disponibilidade`   | Verifica a disponibilidade de um livro.                        | Permitido para todos |
| DELETE      | `/livros/{id}`                   | Deleta um livro pelo ID.                                       | ADMIN          |
| POST        | `/emprestimos`                   | Realiza um novo empréstimo.                                    | Autenticado    |
| POST        | `/devolver`                      | Realiza a devolução de um livro.                               | Autenticado    |
| POST        | `/exemplares`                    | Adiciona um novo exemplar de um livro.                         | ADMIN          |
| GET         | `/exemplares`                    | Lista todos os exemplares.                                     | Autenticado    |

## Documentação da API (Swagger)

Após iniciar a aplicação, a documentação completa da API, gerada com Swagger, pode ser acessada no seu navegador através do seguinte endereço:

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

A interface do Swagger permite visualizar e testar todos os endpoints de forma interativa.

## Como Executar o Projeto

### Pré-requisitos

- JDK 17 ou superior.
- Apache Maven.

### Passos

1. Clone o repositório:

    ```bash
    git clone https://github.com/chico2405/Spring_Project.git
    ```

2. Navegue até o diretório do projeto:

    ```bash
    cd biblioteca
    ```

3. Execute o projeto usando o Maven Wrapper:

    ```bash
    ./mvnw spring-boot:run
    ```

4. A API estará disponível em [http://localhost:8080](http://localhost:8080).

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.1**
- **Spring Web**
- **Spring Security** (Autenticação HTTP Basic)
- **Spring Data JPA**
- **Banco de Dados H2** (em memória)
- **Lombok**
- **SpringDoc OpenAPI** (Swagger)
- **Maven**
