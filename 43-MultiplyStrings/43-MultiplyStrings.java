// Last updated: 7/15/2026, 11:37:27 PM
1class Solution {
2    public String multiply(String num1, String num2) {
3
4        if (num1.equals("0") || num2.equals("0")) {
5            return "0";
6        }
7
8        int m = num1.length();
9        int n = num2.length();
10
11        int[] result = new int[m + n];
12
13        for (int i = m - 1; i >= 0; i--) {
14            int digit1 = num1.charAt(i) - '0';
15
16            for (int j = n - 1; j >= 0; j--) {
17                int digit2 = num2.charAt(j) - '0';
18
19                int multiplication = digit1 * digit2;
20
21                int onesPosition = i + j + 1;
22                int tensPosition = i + j;
23
24                int sum = multiplication + result[onesPosition];
25
26                result[onesPosition] = sum % 10;
27                result[tensPosition] += sum / 10;
28            }
29        }
30
31        StringBuilder answer = new StringBuilder();
32
33        int index = 0;
34
35        while (index < result.length && result[index] == 0) {
36            index++;
37        }
38
39        while (index < result.length) {
40            answer.append(result[index]);
41            index++;
42        }
43
44        return answer.toString();
45    }
46}