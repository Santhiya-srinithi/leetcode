# Last updated: 9/25/2026, 9:13:50 AM
1class Solution:
2    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
3        start=head
4        lookup=set()
5        while start:
6            if start in lookup:
7                return start
8            else:
9                lookup.add(start)
10                start=start.next
11        return None