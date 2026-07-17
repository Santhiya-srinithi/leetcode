-- Last updated: 7/17/2026, 3:02:53 PM
# Write your MySQL query statement below
SELECT x,y,z,
case WHEN (x+y) > z AND (x+z) > y AND (y+z) > x THEN 'Yes' ELSE 'No' end AS triangle
FROM Triangle 