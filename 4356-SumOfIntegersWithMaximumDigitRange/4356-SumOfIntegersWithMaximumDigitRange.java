// Last updated: 7/17/2026, 3:01:39 PM
class Solution {
    public int maxDigitRange(int[] nums) {
        int maxRange=-1;
        int sum=0;
        for(int num:nums){
            int range=digitRange(num);
            if(range>maxRange){
                maxRange=range ;sum=num;
                sum=num;
            }
            else if (range==maxRange){
                sum+=num;
            }
        }
        return sum;
    }
    private int digitRange(int num){
        int largest=0;
        int smallest=9;
        while(num>0){
            int digit=num%10;
            largest=Math.max(largest,digit);
            smallest=Math.min(smallest,digit);
            num=num/10;
        }
        return largest-smallest;
    }
}