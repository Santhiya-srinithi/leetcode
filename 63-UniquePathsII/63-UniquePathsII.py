# Last updated: 9/22/2026, 10:07:20 AM
1class Solution:
2    def uniquePathsWithObstacles(self, obstacleGrid):
3        m = len(obstacleGrid)
4        n = len(obstacleGrid[0])
5
6        if obstacleGrid[0][0] == 1:
7            return 0
8
9        path = [[0] * n for _ in range(m)]
10
11        path[0][0] = 1
12
13        for i in range(1, m):
14            if obstacleGrid[i][0] == 0 and path[i - 1][0] == 1:
15                path[i][0] = 1
16
17        for i in range(1, n):
18            if obstacleGrid[0][i] == 0 and path[0][i - 1] == 1:
19                path[0][i] = 1
20
21        for i in range(1, m):
22            for j in range(1, n):
23                if obstacleGrid[i][j] != 1:
24                    path[i][j] = path[i - 1][j] + path[i][j - 1]
25
26        return path[m - 1][n - 1]