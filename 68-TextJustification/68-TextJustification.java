// Last updated: 7/15/2026, 11:36:10 PM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5
6    public List<String> fullJustify(String[] words, int maxWidth) {
7        List<String> result = new ArrayList<>();
8        int index = 0;
9
10        while (index < words.length) {
11            int lineStart = index;
12            int wordsLength = 0;
13
14            while (index < words.length) {
15                int requiredSpaces = index - lineStart;
16
17                if (wordsLength + requiredSpaces + words[index].length()
18                        > maxWidth) {
19                    break;
20                }
21
22                wordsLength += words[index].length();
23                index++;
24            }
25
26            int wordCount = index - lineStart;
27            int totalSpaces = maxWidth - wordsLength;
28
29            StringBuilder line = new StringBuilder();
30
31            if (index == words.length || wordCount == 1) {
32
33                for (int i = lineStart; i < index; i++) {
34                    line.append(words[i]);
35
36                    if (i < index - 1) {
37                        line.append(" ");
38                    }
39                }
40
41                while (line.length() < maxWidth) {
42                    line.append(" ");
43                }
44
45            } else {
46
47                int gaps = wordCount - 1;
48                int spacesPerGap = totalSpaces / gaps;
49                int extraSpaces = totalSpaces % gaps;
50
51                for (int i = lineStart; i < index; i++) {
52                    line.append(words[i]);
53
54                    if (i < index - 1) {
55                        int spaces = spacesPerGap;
56
57                        if (i - lineStart < extraSpaces) {
58                            spaces++;
59                        }
60
61                        line.append(" ".repeat(spaces));
62                    }
63                }
64            }
65
66            result.add(line.toString());
67        }
68
69        return result;
70    }
71}