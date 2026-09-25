# Last updated: 9/25/2026, 9:22:09 AM
1class Solution:
2    def hIndex(self, citations: List[int]) -> int:
3        n = len(citations)
4        citations.sort()
5
6        for i,v in enumerate(citations):
7            if n - i <= v:
8                return n - i
9        return 0