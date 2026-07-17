// Last updated: 7/17/2026, 3:01:45 PM
class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            long sum=0;
        for(int j=i;j<n;j++){
            sum+=nums[j];
            int lastDigit =(int)(sum%10);
            int firstDigit = getFirstDigit(sum);
                if(firstDigit == x && lastDigit ==x ){
                    count++;
                }
            }
        }
        return count;
    }
    private int getFirstDigit(long num){
        while (num>=10){
            num/=10;
        }
        return(int)num;
    }
}