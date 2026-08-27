// Last updated: 8/27/2026, 9:26:44 AM
1class Solution {
2    public int candy(int[] ratings) {
3        int n = ratings.length;
4        int cnt = 0;
5        int[] candies = new int[n];
6        for (int i = 0; i < n; i++) candies[i] = 1;
7        for (int i = 1; i < n; i++)
8            if (ratings[i] > ratings[i - 1])
9                candies[i] = candies[i - 1] + 1;
10        for (int i = n - 1; i > 0; i--) {
11            if (ratings[i - 1] > ratings[i])
12                candies[i - 1] = Math.max(candies[i] + 1, candies[i - 1]);
13            cnt += candies[i - 1];
14        }
15        return cnt + candies[n - 1];
16    }
17}