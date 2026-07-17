// Last updated: 7/17/2026, 3:03:10 PM
class Solution {
    public boolean isPowerOfFour(int n) 
    {
        if(n<=0)
        {
            return false;
        }
        while(n%4==0)
        {
            n= n/4;
        }
        return n==1;
    }
}