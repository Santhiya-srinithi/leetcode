// Last updated: 7/17/2026, 3:04:07 PM
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[] dp = new int[n + 1];

        for (int row = n - 1; row >= 0; row--) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                dp[col] = triangle.get(row).get(col)
                        + Math.min(dp[col], dp[col + 1]);
            }
        }

        return dp[0];
    }
}