// Last updated: 7/17/2026, 3:01:46 PM
class Solution {
    public long maxRatings(int[][] units) {
        int m = units.length;
        int n = units[0].length;
        long sum = 0;
        if(n==1){
            for(int i = 0;i<m;i++){
                sum+=units[i][0];
            }
            return sum;
        }
        int globalMin = Integer.MAX_VALUE;
        int minSecond = Integer.MAX_VALUE;
        long sumSecond = 0;
        for(int i = 0;i<m;i++){
            int first =Integer.MAX_VALUE;
            int second=Integer.MAX_VALUE;
            for(int val:units[i]){
                if(val<first){
                    second = first;
                    first =val;
                }
                else if(val<second){
                    second= val;
                }
            }
            globalMin = Math.min(globalMin,first);
            minSecond = Math.min(minSecond,second);
            sumSecond +=second;
        }
        return sumSecond + globalMin - minSecond;  
    }
}