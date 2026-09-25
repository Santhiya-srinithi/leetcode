# Last updated: 9/25/2026, 9:11:42 AM
1class Solution:
2    def nextPermutation(self, nums: list[int]) -> None:
3        """
4        Do not return anything, modify nums in-place instead.
5        """
6        #start from back
7        #if there is a smaller number before in the array, we swap them 
8        #this makes the first "larger" permutation
9        #use two pointers
10        #[1,3,2] -> [2,1,3]
11        #two cases: if bigger, iterate left ptr
12        #if smaller, swap left and right,
13        #if we reach end with no swap, swap elt[0] and elt[-1]
14
15        #[1,2,3,5,4,0] -> [124305]
16        max_idx = len(nums)-1 #last elt
17        ptr = len(nums) - 1
18        while ptr >= 0:
19            if nums[ptr] < nums[max_idx]:
20                break
21            elif nums[ptr] > nums[max_idx]:
22                max_idx = ptr
23            ptr -= 1
24
25        if ptr == -1:
26            nums[:] = nums[::-1]
27            return
28        
29        min_idx = ptr + 1
30        for i in range(ptr+1, len(nums)):
31            if nums[i] <= nums[ptr]:
32                continue
33            if nums[i] <= nums[min_idx]:
34                min_idx = i
35        nums[ptr], nums[min_idx] = nums[min_idx], nums[ptr]
36        nums[ptr+1:] = nums[ptr+1:][::-1]
37        
38        
39
40        