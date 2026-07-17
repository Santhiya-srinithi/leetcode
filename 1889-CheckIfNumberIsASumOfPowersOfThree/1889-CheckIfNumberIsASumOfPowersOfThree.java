// Last updated: 7/17/2026, 3:02:06 PM
class Solution {
    public boolean checkPowersOfThree(int n) 
    {
        while(n>0)
        {
            if(n%3==2)
            {
                return false;
            }
            n=n/3;
        }
        return true;
    }
}