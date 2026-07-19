// Last updated: 7/19/2026, 9:12:11 AM
1class Solution {
2    public boolean canReach(int[] start, int[] target) {
3        return(start[0]+start[1])%2==(target[0]+target[1])%2;
4    }
5}