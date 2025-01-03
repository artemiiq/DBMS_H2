WITH MaxSalary AS (
    SELECT MAX(salary) AS max_salary
    FROM employees
)
SELECT name, salary
FROM employees
WHERE salary = (SELECT max_salary FROM MaxSalary);
