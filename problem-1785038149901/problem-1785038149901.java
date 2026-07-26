// Last updated: 7/26/2026, 9:25:49 AM
1class Solution {
2    public int largestInteger(int n, int s) {
3        if(s==0)
4            return 0;
5        if(s>9*n)
6            return -1;
7        StringBuffer a = new StringBuffer();
8        while(n>0){
9            if(s>=9){
10                a.append(9);
11                s-=9;
12            }
13            else{
14                a.append(s);
15                s=0;
16            }
17            n--;
18        }
19        return Integer.parseInt(a.toString());
20    }
21}