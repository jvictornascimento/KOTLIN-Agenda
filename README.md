<h1 align="center">Agenda API Rest</h1>

![Badge Concluído](https://img.shields.io/static/v1?label=Status&message=Concluido&color=brightgreen&style=for-the-badge)
![Badge Kotlin](https://img.shields.io/static/v1?label=Kotlin&message=1.9.25&color=purple&style=for-the-badge&logo=Kotlin)
![Badge Spring](https://img.shields.io/static/v1?label=SpringBoot&message=v3.4.3&color=brightgreen&style=for-the-badge&logo=SpringBoot)
![Badge Gradle](https://img.shields.io/static/v1?label=Gradle&message=v8.12&color=02303A&style=for-the-badge&logo=Gradle)


## Resumo do projeto

Este projeto é uma API RESTful para gerenciamento de pessoas, construída com Spring Boot e Kotlin. Ela permite realizar operações de CRUD (Criar, Ler, Atualizar, Excluir) para dados de pessoas. A API também está documentada com Swagger para facilitar a visualização das rotas e testes interativos.

## Instruções de Execução
### 1. Clonar o repositório
```bash
    git clone https://github.com/jvictornascimento/KOTLIN-Agenda.git
    cd KOTLIN-Agenda
```
### 2. Instalar as dependências
   Execute o seguinte comando para baixar as dependências do projeto:
````bash
 ./gradlew build
````
### 3. Executar a aplicação
   Para rodar a aplicação em modo de desenvolvimento, use o comando:
````bash
 ./gradlew bootRun
````
A API estará disponível em http://localhost:8082.

## Swagger
A API está documentada com o Swagger e pode ser acessada através da interface interativa. Ao executar a aplicação, você pode visualizar e testar todas as rotas da API acessando:
````bash
http://localhost:8082/swagger-ui.html
````

## Endpoints da API
A API fornece os seguintes endpoints:

### 1. Listar todas as pessoas
- Método: `GET`
- URL: `/person`
  
`Parâmetros de consulta:`

- `page` (default: 0) - Página para consulta (paginada).
- `size` (default: 10) - Número de itens por página.

#### Exemplo de resposta
  ```json
{
    "content": [
        {
          "id": 1,
          "name": "João",
          "age": 25,
          "email": "joao@example.com",
          "addresses": [{"street": "Rua 1", "city": "São Paulo"}],
          "contacts": [{"type": "phone", "value": "123456789"}]
        }
      ],
      "totalPages": 1,
      "totalElements": 1,
      "size": 10,
      "number": 0
}
  ```
### 2. Buscar pessoa por ID
- Método: `GET`
- URL: `/person/{id}`

#### Exemplo de resposta
  ```json
{
      "id": 1,
      "name": "João",
      "age": 25,
      "email": "joao@example.com",
      "addresses": [{"street": "Rua 1", "city": "São Paulo"}],
      "contacts": [{"type": "phone", "value": "123456789"}]
}
  ```
### 3. Criar uma nova pessoa
- Método: `POST`
- URL: `/person`

#### Corpo da requisição:
  ```json
{
    "name": "João",
    "age": 25,
    "email": "joao@example.com",
    "addresses": [{"street": "Rua 1", "city": "São Paulo"}],
    "contacts": [{"type": "phone", "value": "123456789"}]
}
  ```
#### Exemplo de resposta

  ```json
   {
      "id": 1,
      "name": "João",
      "age": 25,
      "email": "joao@example.com",
      "addresses": [{"street": "Rua 1", "city": "São Paulo"}],
      "contacts": [{"type": "phone", "value": "123456789"}]
}
  ```
### 4. Atualizar uma pessoa
- Método: `PUT`
- URL: `/person/{id}`

#### Corpo da requisição:
  ```json
   {
      "name": "João Silva",
      "age": 26,
      "email": "joao.silva@example.com",
      "addresses": [{"street": "Rua 2", "city": "São Paulo"}],
      "contacts": [{"type": "phone", "value": "987654321"}]
}
  ```
#### Exemplo de resposta
  ```json
   {
      "id": 1,
      "name": "João Silva",
      "age": 26,
      "email": "joao.silva@example.com",
      "addresses": [{"street": "Rua 2", "city": "São Paulo"}],
      "contacts": [{"type": "phone", "value": "987654321"}]
}
  ```
### 5. Excluir uma pessoa
- Método: `DELETE`
- URL: `/person/{id}`

#### Exemplo de resposta

  ```json
{
    "status": "No Content"
}
  ```

## Estrutura do Projeto
O projeto segue a arquitetura padrão de camadas de uma aplicação Spring Boot:

- Controller: Recebe e processa as requisições HTTP.
- Service: Contém a lógica de negócios.
- Repository: Interface que realiza operações no banco de dados usando Spring Data JPA.
- DTOs: Objetos de Transferência de Dados utilizados para representar as entidades no formato adequado para a API.

## Testes
O projeto inclui testes automatizados utilizando JUnit 5 e Mockito. Os testes podem ser executados com o comando:
```bash
  ./gradlew test
```

## Tecnologias
- `Kotlin 1.9`
- `Java 17`
- `Gradle`
- `Spring Boot, Spring MVC, Spring Data JPA, Spring Validation, Spring Web, Spring Open Feign, Spring Web Flux `
- `H2 Data Base`
- `Jackson`
- `Junit5`
- `Mockito`
- `Lombok`
- `Swagger`
- `Intellij`
