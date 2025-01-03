WITH ProjectDurations AS (
    SELECT 
        NAME, 
        DATEDIFF(MONTH, START_DATE, END_DATE) AS MONTH_COUNT
    FROM 
        Projects
)

SELECT 
    NAME, 
    MONTH_COUNT
FROM 
    ProjectDurations
WHERE 
    MONTH_COUNT = (SELECT MAX(MONTH_COUNT) FROM ProjectDurations);
