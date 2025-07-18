SELECT id, visit_date, people
FROM (
    SELECT *,
           ROW_NUMBER() OVER (ORDER BY id) - 
           ROW_NUMBER() OVER (PARTITION BY people >= 100 ORDER BY id) AS grp
    FROM stadium
) AS t
WHERE people >= 100
  AND grp IN (
    SELECT grp
    FROM (
        SELECT grp, COUNT(*) AS cnt
        FROM (
            SELECT *,
                   ROW_NUMBER() OVER (ORDER BY id) - 
                   ROW_NUMBER() OVER (PARTITION BY people >= 100 ORDER BY id) AS grp
            FROM stadium
        ) AS temp
        WHERE people >= 100
        GROUP BY grp
        HAVING COUNT(*) >= 3
    ) AS valid_groups
)
ORDER BY id;
