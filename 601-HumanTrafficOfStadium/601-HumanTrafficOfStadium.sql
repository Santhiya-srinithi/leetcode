-- Last updated: 7/17/2026, 3:02:58 PM
SELECT id, visit_date, people
FROM (
    SELECT *,
           id - ROW_NUMBER() OVER (ORDER BY id) AS group_id
    FROM Stadium
    WHERE people >= 100
) AS temp
WHERE group_id IN (
    SELECT group_id
    FROM (
        SELECT *,
               id - ROW_NUMBER() OVER (ORDER BY id) AS group_id
        FROM Stadium
        WHERE people >= 100
    ) AS temp2
    GROUP BY group_id
    HAVING COUNT(*) >= 3
)
ORDER BY visit_date;
