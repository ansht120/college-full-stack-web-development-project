# Architecture

## System Context

```mermaid
flowchart LR
    User["Admin / Faculty / Student"] --> React["React Web App"]
    React --> Api["Spring Boot API (/api/v1)"]
    Api --> Db["PostgreSQL"]
    Api --> Swagger["OpenAPI / Swagger UI"]
```

## Backend Layers

```mermaid
flowchart TD
    Controller["REST Controllers"] --> Service["Application Services"]
    Service --> Repository["Spring Data Repositories"]
    Repository --> Entity["JPA Entities"]
    Entity --> Database["PostgreSQL + Flyway"]
    Security["JWT Security Filter"] --> Controller
    Exceptions["Global Exception Handler"] --> Controller
```

## ER Diagram

```mermaid
erDiagram
    DEPARTMENTS ||--o{ STUDENTS : has
    USERS {
        bigint id PK
        uuid public_id UK
        varchar full_name
        varchar email UK
        varchar password_hash
        varchar role
        boolean deleted
    }
    DEPARTMENTS {
        bigint id PK
        uuid public_id UK
        varchar code UK
        varchar name UK
        boolean deleted
    }
    STUDENTS {
        bigint id PK
        uuid public_id UK
        varchar roll_number UK
        varchar full_name
        varchar email UK
        int semester
        bigint department_id FK
        boolean deleted
    }
```

## Login Sequence

```mermaid
sequenceDiagram
    participant Client
    participant AuthController
    participant AuthService
    participant UserRepository
    participant JwtService
    Client->>AuthController: POST /auth/login
    AuthController->>AuthService: validate credentials
    AuthService->>UserRepository: find active user by email
    AuthService->>AuthService: BCrypt password match
    AuthService->>JwtService: generate token
    JwtService-->>Client: JWT response
```
