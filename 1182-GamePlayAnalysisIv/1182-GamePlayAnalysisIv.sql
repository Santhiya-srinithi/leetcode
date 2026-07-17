-- Last updated: 7/17/2026, 3:02:32 PM
# Write your MySQL query statement below
SELECT 
    ROUND(COUNT(a2.player_id) / COUNT(a1.player_id), 2) AS fraction
FROM (
    SELECT 
        player_id,
        MIN(event_date) AS first_login
    FROM Activity
    GROUP BY player_id
) a1
LEFT JOIN Activity a2
ON a1.player_id = a2.player_id
AND DATEDIFF(a2.event_date, a1.first_login) = 1;