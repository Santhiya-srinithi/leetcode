-- Last updated: 7/17/2026, 3:02:50 PM
# Write your MySQL query statement below
SELECT *
FROM Cinema
WHERE id % 2 = 1
  AND description <> 'boring'
ORDER BY rating DESC;