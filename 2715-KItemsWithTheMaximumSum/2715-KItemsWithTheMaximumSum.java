// Last updated: 7/17/2026, 3:01:55 PM
class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int max = 0;

        while (k > 0) {
            if (numOnes > 0) {
                max += 1;      // pick 1s first
                numOnes--;
            } else if (numZeros > 0) {
                // pick 0s → sum doesn't change
                numZeros--;
            } else {
                max += -1;     // pick -1s last
                numNegOnes--;
            }
            k--;
        }

        return max;
    }
}
