SELECT
    p.project_name AS NAME,
    SUM(e.salary) * p.duration_months AS PRICE
FROM
    projects p
JOIN
    project_employees pe ON p.project_id = pe.project_id
JOIN
    employees e ON pe.employee_id = e.employee_id
GROUP BY
    p.project_id, p.project_name, p.duration_months
ORDER BY
    PRICE DESC;