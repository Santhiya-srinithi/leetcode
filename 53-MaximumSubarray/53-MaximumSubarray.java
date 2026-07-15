// Last updated: 7/15/2026, 11:34:03 PM
1class Solution {
2    public int maxSubArray(int[] nums) {
3        int currentSum = nums[0];
4        int maximumSum = nums[0];
5
6        for (int i = 1; i < nums.length; i++) {
7            currentSum = Math.max(nums[i], currentSum + nums[i]);
8
9            maximumSum = Math.max(maximumSum, currentSum);
10        }
11
12        return maximumSum;
13    }
14}