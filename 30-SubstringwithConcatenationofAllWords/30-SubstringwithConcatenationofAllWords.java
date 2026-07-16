// Last updated: 7/16/2026, 11:26:32 PM
1class Solution {
2    public List<Integer> findSubstring(String s, String[] words) {
3        List<Integer> ans = new ArrayList<>();
4        int n = s.length();
5        int m = words.length;
6        int w = words[0].length();
7
8        HashMap<String,Integer> map = new HashMap<>();
9        for(String x : words)
10        map.put(x, map.getOrDefault(x,0)+1);
11
12        for(int i=0; i<w; i++){
13            HashMap<String,Integer> temp = new HashMap<>();
14            int count = 0;
15            for(int j=i,k=i; j+w <= n; j=j+w){
16                String word = s.substring(j,j+w);
17                temp.put(word,temp.getOrDefault(word,0)+1);
18                count++;
19                
20                if(count==m){
21                    if(map.equals(temp)){
22                        ans.add(k);
23                    }
24                    String remove = s.substring(k,k+w);
25                    temp.computeIfPresent(remove, (a, b) -> (b > 1) ? b - 1 : null);
26                    count--;
27                    k=k+w;
28                }
29            }
30        }
31        return ans;
32    }
33}
34