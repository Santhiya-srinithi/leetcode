// Last updated: 7/17/2026, 3:01:44 PM
class Solution {
    public int getLength(int[] nums) {
        int n = nums.length;
        int ans = 1;
        for(int i=0;i<n;i++){
            Map<Integer,Integer>freq = new HashMap<>();
            Map<Integer,Integer>countFreq = new HashMap<>();
            for(int j=i;j<n;j++){
                int val = nums[j];
                int oldFreq =freq.getOrDefault(val,0);
                if(oldFreq>0){
                    countFreq.put(oldFreq,countFreq.get(oldFreq)-1);
                    if(countFreq.get(oldFreq)==0){
                        countFreq.remove(oldFreq);
                    }
                }
                int newFreq = oldFreq+1;
                freq.put(val,newFreq);
                countFreq.put(newFreq,countFreq.getOrDefault(newFreq,0)+1);
                if(isBalanced(countFreq,freq.size()))
                {
                    ans = Math.max(ans,j-i+1);
                }  
            }
        }
        return ans;   
    }
    private boolean isBalanced(Map<Integer,Integer>countFreq,int distinct){
        if(distinct == 1){
            return true;
        }
        if(countFreq.size()!=2){
            return false;
        }
        List<Integer>list = new ArrayList<>(countFreq.keySet());
        int a = list.get(0);
        int b = list.get(1);
        int small = Math.min(a,b);
        int large = Math.max(a,b);

        return large ==2*small;
    }
}