-- Last updated: 7/17/2026, 3:02:36 PM
# Write your MySQL query statement below
SELECT p.product_name, s.year, s.price
FROM Sales s
JOIN Product p
ON s.product_id = p.product_id;