create table departments (
    id bigserial primary key,
    public_id uuid not null unique,
    code varchar(20) not null unique,
    name varchar(120) not null unique,
    deleted boolean not null default false,
    created_at timestamp with time zone not null,
    updated_at timestamp with time zone not null
);

create table users (
    id bigserial primary key,
    public_id uuid not null unique,
    full_name varchar(120) not null,
    email varchar(160) not null unique,
    password_hash varchar(255) not null,
    role varchar(30) not null check (role in ('ADMIN', 'FACULTY', 'STUDENT')),
    deleted boolean not null default false,
    created_at timestamp with time zone not null,
    updated_at timestamp with time zone not null
);

create table students (
    id bigserial primary key,
    public_id uuid not null unique,
    roll_number varchar(40) not null unique,
    full_name varchar(120) not null,
    email varchar(160) not null unique,
    semester integer not null check (semester between 1 and 12),
    department_id bigint not null references departments(id),
    deleted boolean not null default false,
    created_at timestamp with time zone not null,
    updated_at timestamp with time zone not null
);

create index idx_departments_code_active on departments (lower(code), deleted);
create index idx_users_email_active on users (lower(email), deleted);
create index idx_students_roll_active on students (lower(roll_number), deleted);
create index idx_students_search on students (lower(full_name), lower(email), semester, deleted);
create index idx_students_department on students (department_id);
