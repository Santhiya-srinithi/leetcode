// Last updated: 7/17/2026, 3:02:43 PM
class Solution {
    public int fib(int n) {
        if(n==0)
        {
            return 0;
        }
        else if(n==1)
        {
            return 1;
        }
        else
        {
            return (fib(n-1)+fib(n-2));
        }
    }
}