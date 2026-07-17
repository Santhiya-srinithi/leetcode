-- Last updated: 7/17/2026, 3:03:39 PM
SELECT email AS Email
FROM Person
GROUP BY email
HAVING COUNT(email) > 1;
