WITH ClientProjectCount AS (
    SELECT 
        c.name AS NAME, 
        COUNT(p.id) AS PROJECT_COUNT
    FROM clients c
    LEFT JOIN projects p ON c.id = p.client_id
    GROUP BY c.name
)

SELECT 
    NAME, 
    PROJECT_COUNT
FROM ClientProjectCount
WHERE PROJECT_COUNT = (SELECT MAX(PROJECT_COUNT) FROM ClientProjectCount);