insert into departments (public_id, code, name, deleted, created_at, updated_at)
values
    ('11111111-1111-1111-1111-111111111111', 'CSE', 'Computer Science and Engineering', false, now(), now()),
    ('22222222-2222-2222-2222-222222222222', 'ECE', 'Electronics and Communication Engineering', false, now(), now());

-- Password for every seeded user: Password@123
insert into users (public_id, full_name, email, password_hash, role, deleted, created_at, updated_at)
values
    ('33333333-3333-3333-3333-333333333333', 'System Administrator', 'admin@college.com', '$2a$12$SbSS2OCtvvlECvq6SmFrZ.0ecCtP6qeb2UPxW0.1P1TdQMxWC00n2', 'ADMIN', false, now(), now()),
    ('44444444-4444-4444-4444-444444444444', 'Faculty Demo', 'faculty@college.com', '$2a$12$SbSS2OCtvvlECvq6SmFrZ.0ecCtP6qeb2UPxW0.1P1TdQMxWC00n2', 'FACULTY', false, now(), now());

insert into students (public_id, roll_number, full_name, email, semester, department_id, deleted, created_at, updated_at)
select '55555555-5555-5555-5555-555555555555', 'CSE-2026-001', 'Rahul Sharma', 'rahul@student.college.com', 5, d.id, false, now(), now()
from departments d
where d.code = 'CSE';
