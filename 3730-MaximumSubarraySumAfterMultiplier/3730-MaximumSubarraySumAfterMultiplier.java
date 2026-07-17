// Last updated: 7/17/2026, 3:01:49 PM
class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long ans=Long.MIN_VALUE;
        ans=Math.max(ans,solve(nums,k,true));
        ans=Math.max(ans,solve(nums,k,false));
        return ans;
    }
    private long solve(int[] nums,int k,boolean multiply){
        long noOp=nums[0];
        long changed = getValue(nums[0],k,multiply);
        long after=Long.MIN_VALUE/4;
        long  ans=changed;
        for(int i=1;i<nums.length;i++){
            long x = nums[i];
            long val=getValue(nums[i],k,multiply);
            long newAfter=Math.max(changed+x,after+x);
            long newChanged=Math.max(val,Math.max(noOp+val,changed+val));
            long newNoOp =Math.max(x,noOp+x);
            noOp = newNoOp;
            changed = newChanged;
            after = newAfter;
            ans=Math.max(ans,Math.max(changed,after));
        }
        return ans;
    }
    private long getValue(int x,int k,boolean multiply){
        if(multiply)return 1L*x*k;
        return x/k;
    }
}
