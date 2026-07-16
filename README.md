# Restaurant API

API REST desenvolvida em **Java com Spring Boot** para gerenciamento de um sistema de restaurante.

A aplicação permite controlar clientes, pratos, pedidos, pagamentos e entregas, utilizando uma arquitetura organizada em camadas e seguindo boas práticas de desenvolvimento backend.

O projeto foi desenvolvido com foco em:

* Arquitetura RESTful
* Separação de responsabilidades
* DTO Pattern
* Mapper Pattern
* Validação de dados
* Tratamento global de exceções
* Persistência com JPA/Hibernate
* Containerização do banco de dados utilizando Docker

---

#  Tecnologias utilizadas

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* PostgreSQL
* Maven
* Lombok
* Bean Validation
* Swagger/OpenAPI
* Docker
* Docker Compose

---

#  Arquitetura do projeto

A aplicação segue uma arquitetura baseada em camadas:

```text
Controller
     ↓
Service
     ↓
Repository
     ↓
Database
```

O fluxo de conversão de dados utiliza:

```text
DTO ↔ Mapper ↔ Entity
```

## Responsabilidade das camadas

### Controller

Responsável por:

* Receber requisições HTTP;
* Validar dados recebidos;
* Retornar respostas da API.

---

### Service

Responsável por:

* Regras de negócio;
* Validações da aplicação;
* Orquestração das operações.

---

### Repository

Responsável por:

* Comunicação com o banco de dados;
* Operações CRUD utilizando Spring Data JPA.

---

### DTO

Responsável por:

* Controlar dados recebidos e enviados;
* Evitar exposição direta das entidades.

---

### Mapper

Responsável por:

* Converter Entity para DTO;
* Converter DTO para Entity.

---

#  Estrutura do projeto

```text
src/main/java

├── controller
│
├── service
│
├── repository
│
├── model
│
├── dto
│
├── mapper
│
├── exception
│
├── config
│
└── enums
```

---

#  Funcionalidades

##  Clientes

* Cadastro de clientes;
* Consulta de clientes;
* Atualização de clientes;
* Exclusão de clientes.

---

##  Pratos

* Cadastro de pratos;
* Controle de disponibilidade;
* Consulta de pratos;
* Atualização de informações.

---

##  Pedidos

* Criação de pedidos;
* Associação entre cliente e pratos;
* Controle de status do pedido;
* Cálculo de valores.

---

## Pagamentos

* Registro de pagamentos;
* Associação com pedidos;
* Controle de valores pagos.

---

##  Entregas

* Criação de entregas;
* Associação com pedidos;
* Controle de status da entrega.


---

#  Principais endpoints

## Client

| Método | Endpoint        | Descrição        |
| ------ | --------------- | ---------------- |
| GET    | `/clients`      | Lista clientes   |
| GET    | `/clients/{id}` | Busca cliente    |
| POST   | `/clients`      | Cria cliente     |
| PUT    | `/clients/{id}` | Atualiza cliente |
| DELETE | `/clients/{id}` | Remove cliente   |

---

## Dish

| Método | Endpoint       | Descrição      |
| ------ | -------------- | -------------- |
| GET    | `/dishes`      | Lista pratos   |
| GET    | `/dishes/{id}` | Busca prato    |
| POST   | `/dishes`      | Cria prato     |
| PUT    | `/dishes/{id}` | Atualiza prato |
| DELETE | `/dishes/{id}` | Remove prato   |

---

## Order

| Método | Endpoint              | Descrição       |
| ------ | --------------------- | --------------- |
| GET    | `/orders`             | Lista pedidos   |
| GET    | `/orders/{id}`        | Busca pedido    |
| POST   | `/orders`             | Cria pedido     |
| PUT    | `/orders/{id}/status` | Atualiza status |
| DELETE | `/orders/{id}`        | Remove pedido   |

---

## Payment

| Método | Endpoint         | Descrição        |
| ------ | ---------------- | ---------------- |
| GET    | `/payments`      | Lista pagamentos |
| GET    | `/payments/{id}` | Busca pagamento  |
| POST   | `/payments`      | Cria pagamento   |
| DELETE | `/payments/{id}` | Remove pagamento |

---

## Delivery

| Método | Endpoint           | Descrição      |
| ------ | ------------------ | -------------- |
| GET    | `/deliveries`      | Lista entregas |
| GET    | `/deliveries/{id}` | Busca entrega  |
| POST   | `/deliveries`      | Cria entrega   |
| DELETE | `/deliveries/{id}` | Remove entrega |

---

#  Executando com Docker

O projeto utiliza Docker para executar o banco PostgreSQL em um container.

Arquitetura:

```text
Docker Compose

┌──────────────────────┐
│ Spring Boot API      │
│ localhost:8080       │
└──────────┬───────────┘
           |
           |
┌──────────▼───────────┐
│ PostgreSQL           │
│ localhost:5432       │
└──────────────────────┘
```

---

## Pré-requisitos

* Java 21+
* Maven
* PostgreSQL ou Docker
* Docker Compose

---

## Executando o banco com Docker

Na raiz do projeto:

```bash
docker compose up -d
```

O container PostgreSQL será iniciado automaticamente.

---

## Configuração do banco

Exemplo:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/restaurant_api
    username: postgres
    password: postgres

  jpa:
    hibernate:
      ddl-auto: update
```

Banco utilizado:

```text
Database: restaurant_api
Username: postgres
Password: postgres
Port: 5432
```

---

## Executando a aplicação

Gerar o build:

```bash
mvn clean package
```

Executar:

```bash
mvn spring-boot:run
```

---


#  Swagger/OpenAPI

A documentação da API está disponível através do Swagger.

Após iniciar a aplicação:

```text
http://localhost:8080/swagger-ui/index.html
```

Com ele é possível:

* Visualizar endpoints;
* Testar requisições;
* Conferir modelos de dados.

---

# Tratamento de exceções

A aplicação possui um tratamento global utilizando:

* `@RestControllerAdvice`
* Exceções personalizadas
* Respostas padronizadas

Exemplo:

```json
{
  "timestamp": "2026-07-16T10:30:00",
  "status": 404,
  "error": "Not Found",
  "message": "Client not found.",
  "path": "/clients/1"
}
```

---

# Conceitos aplicados

Durante o desenvolvimento foram utilizados:

* Desenvolvimento de API REST;
* Arquitetura em camadas;
* DTO Pattern;
* Mapper Pattern;
* JPA/Hibernate;
* Relacionamentos entre entidades;
* Bean Validation;
* Tratamento global de exceções;
* Docker Compose;
* PostgreSQL;
* Boas práticas de organização de código.

---

#  Autor

## Arthur Lima

Desenvolvedor Backend.

Tecnologias principais:

* Java
* Spring Boot
* PostgreSQL
* Docker

---
