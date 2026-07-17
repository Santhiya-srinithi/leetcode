// Last updated: 7/17/2026, 3:01:41 PM
class Solution {
    public int maxDistance(String moves) {
        int u=0,d=0,l=0,r=0,q=0;
        for(char ch:moves.toCharArray()){
            if(ch=='U')u++;
            else if(ch=='D')d++;
            else if(ch=='L')l++;
            else if(ch=='R')r++;
            else q++;
        }
        int vertical=Math.abs(u-d);
        int horizontal=Math.abs(r-l);
        return vertical+horizontal+q;
    }
}