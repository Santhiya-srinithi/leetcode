// Last updated: 7/17/2026, 3:03:18 PM
class Solution {
    public int addDigits(int num) {
     while(num>=10)
     {
       int sum = 0;
       while(num>0)
       {
         sum+=num%10;
         num/=10;
       }
       num=sum;
     }
     return num;
    }
}