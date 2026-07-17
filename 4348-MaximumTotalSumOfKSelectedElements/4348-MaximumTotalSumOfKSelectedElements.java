// Last updated: 7/17/2026, 3:01:36 PM
class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        long ans =0;
        int n = nums.length;
        for(int i = 0;i<k;i++){
            long value=nums[n-1-i];
            long currentMul=mul-i;
            if(currentMul>1){
                ans+=value*currentMul;
            }else{
                ans+=value;
            }
        }
        return ans;
    }
}