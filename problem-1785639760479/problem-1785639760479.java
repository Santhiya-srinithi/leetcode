// Last updated: 8/2/2026, 8:32:40 AM
1class Solution {
2    public long maxPairStrength(int[] nums) {
3        long an=0;
4        for(int i =0;i<nums.length;i++){
5            for(int j=i+1;j<nums.length;j++){
6                long g=gcd(nums[i],nums[j]);
7                long s=((long)nums[i]*nums[j])/(g*g);
8                an=Math.max(an,s);
9            }
10        }
11        return an;
12    }
13    private long gcd(long a,long b){
14        while(b!=0){
15            long temp =b;
16            b=a%b;
17            a=temp;
18        }
19        return a;
20    }
21}