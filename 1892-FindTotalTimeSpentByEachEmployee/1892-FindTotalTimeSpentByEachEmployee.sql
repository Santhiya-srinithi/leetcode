-- Last updated: 7/17/2026, 3:02:05 PM
# Write your MySQL query statement below
SELECT
    event_day AS day,
    emp_id,
    SUM(out_time - in_time) AS total_time
FROM Employees
GROUP BY event_day, emp_id;