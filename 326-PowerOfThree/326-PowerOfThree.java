// Last updated: 7/17/2026, 3:03:13 PM
class Solution {
    public boolean isPowerOfThree(int n) 
    {
        if(n<=0)
        {
            return false;
        }
        while(n%3==0)
        {
            n = n/3;
        }
        return n==1; 
    }
}