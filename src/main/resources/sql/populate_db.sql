INSERT INTO Employees (id, name, technical_level, salary)
VALUES
    (1, 'Ivan Petrov', 'Trainee', 900),
    (2, 'Anna Ivanova', 'Junior', 1500),
    (3, 'Oleg Sidorenko', 'Junior', 2000),
    (4, 'Maria Koval', 'Middle', 3500),
    (5, 'Yuriy Bondarenko', 'Middle', 4000),
    (6, 'Svetlana Gorbatyuk', 'Senior', 5500),
    (7, 'Nikolai Zhuk', 'Senior', 6000),
    (8, 'Andrey Tkachenko', 'Middle', 4200),
    (9, 'Olga Yatsenko', 'Junior', 1800),
    (10, 'Viktor Shevchenko', 'Trainee', 950);

INSERT INTO Clients (id, name, contact_info)
VALUES
    (1, 'ABC Corp', 'abc@example.com'),
    (2, 'Global Tech', 'global@example.com'),
    (3, 'Innovate LLC', 'innovate@example.com'),
    (4, 'Future Solutions', 'future@example.com'),
    (5, 'Bright Minds', 'bright@example.com');

INSERT INTO Projects (id, name, client_id, start_date, finish_date)
VALUES
    (1, 'Project Alpha', 1, '2023-01-01', '2023-12-31'),
    (2, 'Project Beta', 2, '2022-05-01', '2025-05-01'),
    (3, 'Project Gamma', 3, '2023-03-01', '2023-06-01'),
    (4, 'Project Delta', 4, '2023-07-01', '2024-01-01'),
    (5, 'Project Epsilon', 5, '2021-01-01', '2024-12-31'),
    (6, 'Project Zeta', 1, '2020-06-01', '2022-12-01'),
    (7, 'Project Eta', 2, '2023-01-01', '2023-12-01'),
    (8, 'Project Theta', 3, '2023-02-01', '2024-02-01'),
    (9, 'Project Iota', 4, '2022-01-01', '2022-12-31'),
    (10, 'Project Kappa', 5, '2023-01-01', '2023-05-01');

INSERT INTO ProjectAssignments (project_id, employee_id)
VALUES
    (1, 1), (1, 2),
    (2, 3), (2, 4),
    (3, 5), (3, 6), (3, 7),
    (4, 8),
    (5, 9), (5, 10),
    (6, 1), (6, 2),
    (7, 3),
    (8, 4), (8, 5),
    (9, 6),
    (10, 7), (10, 8), (10, 9);
