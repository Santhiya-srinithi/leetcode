// Last updated: 8/6/2026, 9:20:45 AM
1class Solution {
2    public boolean isValidSudoku(char[][] board) {
3
4        int[][] rows = new int[9][9];
5        int[][] columns = new int[9][9];
6        int[][] subboxes = new int[9][9];
7
8        for(int r = 0; r < 9 ; r++){
9            for(int c = 0; c < 9 ; c++){
10
11                if(board[r][c] == '.'){
12                    continue;
13                }
14
15                int value = board[r][c] - '1';
16
17                if(rows[r][value] == 1){
18                    return false;
19                }
20
21                rows[r][value] = 1;
22
23                if(columns[c][value] == 1){
24                    return false;
25                }
26
27                columns[c][value] = 1;
28
29                int subboxIndex = 3 * (r / 3) + (c / 3);
30                if(subboxes[subboxIndex][value] == 1){
31                    return false;
32                }
33                subboxes[subboxIndex][value] = 1;
34            }
35        }
36        return true;
37    }
38}