# Last updated: 8/11/2026, 10:05:03 AM
1class Solution:
2    def jump(self, nums: List[int]) -> int:
3        count = reached_to = can_reach_to = 0
4        for i in range(len(nums)):
5            if i > reached_to: count += 1;reached_to = can_reach_to
6            can_reach_to = max(can_reach_to, i + nums[i])
7        return count