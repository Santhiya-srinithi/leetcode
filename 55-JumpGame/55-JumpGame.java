// Last updated: 7/17/2026, 3:04:56 PM
class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            // Current index cannot be reached
            if (i > maxReach) {
                return false;
            }

            // Update the farthest reachable index
            maxReach = Math.max(maxReach, i + nums[i]);

            // Last index can already be reached
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}