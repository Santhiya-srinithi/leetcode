# Last updated: 9/22/2026, 10:12:39 AM
1class TrieNode:
2    def __init__(self):
3        self.children = {}
4        self.word = None
5
6class Solution:
7    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
8        # Insert every word into trie
9        # start dfs from every cell
10        # In DFS, walk through trie 
11        # if tree node contains complete word we found candidate
12        # continue search
13        root = TrieNode()
14        for word in words:
15            node = root
16            for ch in word:
17                if ch not in node.children:
18                    node.children[ch] = TrieNode()
19                node = node.children[ch]
20            node.word = word
21        
22        rows = len(board)
23        cols = len(board[0])
24
25        result = []
26        def dfs(r, c, parent):
27            letter = board[r][c]
28            if letter not in parent.children:
29                return
30            
31            node = parent.children[letter]
32            # check if current pos make up the word
33            if node.word:
34                result.append(node.word)
35                # To avoid duplicates
36                node.word = None
37            board[r][c] = '#' # so that we do not count it again
38            for dr, dc in [(-1,0),(1,0),(0,-1),(0,1)]:
39                nr = r + dr
40                nc = c + dc
41                if (0 <= nr < rows and
42                    0 <= nc < cols and
43                    board[nr][nc] != '#'):
44                    dfs(nr, nc, node)
45            
46            # reset back
47            board[r][c] = letter
48            if not node.children and node.word is None:
49                del parent.children[letter]
50        
51        for i in range(rows):
52            for j in range(cols):
53                dfs(i, j, root)
54
55        return result