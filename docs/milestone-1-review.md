# Milestone 1 Review

## Delivered

- Spring Boot 3 Java backend under `backend-java`.
- JWT login endpoint with BCrypt password verification.
- Role-based authorization using Spring Security method rules.
- Student CRUD foundation with pagination, sorting, filtering, search, soft delete, DTOs, transactions, validation, and repository pattern.
- Flyway migrations with 3NF core tables, constraints, foreign keys, and indexes.
- Docker Compose for PostgreSQL and the Java API.
- GitHub Actions CI for Java tests.
- Architecture, ER, and sequence diagrams.

## Architecture Decisions

- Added `backend-java` instead of replacing the current Node/React code so the existing work is preserved while the enterprise Java backend grows cleanly.
- Used Spring Boot layered architecture because it is the industry-standard Java stack for enterprise REST APIs.
- Used Flyway instead of Hibernate schema generation for repeatable production database changes.
- Used DTO records at API boundaries to keep entities from leaking into controllers.
- Used soft delete as a domain rule so historical academic records are not physically removed.

## Senior Review Notes

- Security: production deployments must override `JWT_SECRET`; the default exists only for local development.
- Performance: student search has indexes for common filters, but full-text search should be introduced once result/marks volume grows.
- Maintainability: next milestone should add faculty, subject, marks, result aggregates, and shared pagination response metadata.
- Testing: local Java/Maven are unavailable on this machine, so CI is the intended compiler/test verifier until Java is installed locally.

## Interview Questions

1. Why use DTOs instead of returning JPA entities?
   DTOs decouple external API contracts from internal persistence models, prevent lazy-loading serialization issues, and reduce accidental data exposure.

2. Why use Flyway with Spring Boot?
   Flyway gives deterministic, versioned database migrations that work across local, CI, staging, and production.

3. Why soft delete students?
   Academic records usually need auditability. Soft delete hides records from normal workflows while preserving historical integrity.

4. How is RBAC enforced?
   JWT tokens carry the user role, the security filter converts it to Spring authorities, and controller methods enforce access with `@PreAuthorize`.

5. Why disable Open Session in View?
   It prevents accidental lazy database queries from the web layer and forces services to fetch the data they need intentionally.
