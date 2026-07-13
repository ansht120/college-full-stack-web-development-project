# Enterprise Digital Banking Operations Platform

Production-oriented full-stack banking operations project for managing secure staff access, customer operations, account workflows, transaction monitoring, approvals, audit trails, and role-based back-office banking workflows.

The repository is being evolved into an enterprise-grade banking platform suitable for Java/Spring Boot portfolio interviews. The current milestone establishes the backend foundation under `backend-java`; upcoming milestones will replace the earlier academic domain with banking modules.

## Tech Stack

| Layer | Technology |
|---|---|
| Java Backend | Spring Boot 3, Java 21, Spring Security, Spring Data JPA |
| Database | PostgreSQL, Flyway migrations |
| API Docs | Swagger / OpenAPI |
| Security | JWT, BCrypt, role-based authorization |
| Frontend | React, Tailwind CSS |
| DevOps | Docker, Docker Compose, GitHub Actions |

## Enterprise Features Implemented

- Versioned REST API: `/api/v1`
- Standard API response wrapper
- JWT authentication
- BCrypt password validation
- Role-based authorization
- DTO-based request and response models
- Global exception handling
- Validation with meaningful HTTP responses
- Pagination, sorting, filtering, and search foundation
- Soft delete support for regulated operational records
- Transactional service layer
- Repository pattern
- Flyway migrations with constraints, foreign keys, and indexes
- Swagger UI
- Docker Compose environment
- GitHub Actions CI workflow

## Folder Structure

```text
.
├── backend-java/          Spring Boot enterprise backend
├── backend/               Existing Node.js backend
├── frontend/              React frontend
├── database/              Existing SQL scripts
├── docs/                  Architecture and milestone documentation
├── postman/               Postman collection
├── docker-compose.yml
└── .github/workflows/ci.yml
```

## Run With Docker

```bash
cp .env.example .env
docker compose up --build
```

Java API:

- Base URL: `http://localhost:8080/api/v1`
- Swagger UI: `http://localhost:8080/api/v1/swagger-ui.html`

## Java Backend Local Setup

Prerequisites:

- Java 21
- Maven 3.9+
- PostgreSQL 16+

```bash
cd backend-java
mvn test
mvn spring-boot:run
```

## Default Seed Credentials

| Role | Email | Password |
|---|---|---|
| Operations Admin | `admin@college.com` | `Password@123` |
| Operations Staff | `faculty@college.com` | `Password@123` |

## API Examples

Login:

```http
POST /api/v1/auth/login
Content-Type: application/json

{
  "email": "admin@college.com",
  "password": "Password@123"
}
```

Search current milestone records:

```http
GET /api/v1/students?q=rahul&semester=5&page=0&size=20&sort=fullName,asc
Authorization: Bearer <token>
```

## Documentation

- [Architecture, ER, and sequence diagrams](docs/architecture.md)
- [Milestone 1 senior review](docs/milestone-1-review.md)
- [Security policy](SECURITY.md)
- [Contributing guide](CONTRIBUTING.md)
- [Code of conduct](CODE_OF_CONDUCT.md)

## Roadmap

- Banking customer profile module
- Account management module
- Transaction ledger module
- Internal transfer workflow
- Maker-checker approval workflow
- KYC status and document review module
- Audit logging and suspicious activity flags
- React frontend integration with Java banking APIs
- Expanded unit and integration test suite
- Deployment guide and screenshots

## License

MIT License.
