WITH WorkersWithAge AS (
    SELECT 
        NAME, 
        BIRTHDAY,
        ROW_NUMBER() OVER (ORDER BY BIRTHDAY ASC) AS EldestRank,
        ROW_NUMBER() OVER (ORDER BY BIRTHDAY DESC) AS YoungestRank
    FROM Workers
)

SELECT
    CASE 
        WHEN EldestRank = 1 THEN 'OLDEST'
        WHEN YoungestRank = 1 THEN 'YOUNGEST'
    END AS TYPE,
    NAME,
    BIRTHDAY
FROM WorkersWithAge
WHERE EldestRank = 1 OR YoungestRank = 1
ORDER BY TYPE, NAME;