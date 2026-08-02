// Last updated: 8/2/2026, 8:39:06 AM
1class Solution {
2    public int countRatioSubarrays(int[] nums, int a, int b) {
3        int n =nums.length;
4        int an =0;
5        for(int i=0;i<n;i++){
6            int even=0;
7            int odd=0;
8            for(int j =i;j<n;j++){
9                if(nums[j]%2==0){
10                    even++;
11                }
12                else{
13                    odd++;
14                }
15                if(odd>0 && (long)even*b<=(long)odd*a){
16                    an++;
17                }
18            }
19        }
20        return an;
21    }
22    
23}