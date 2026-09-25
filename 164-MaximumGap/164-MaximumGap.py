# Last updated: 9/25/2026, 9:14:41 AM
1class Solution:
2    def maximumGap(self, nums: List[int]) -> int:
3        n = len(nums)
4        if n < 2:
5            return 0
6        
7        minVal = min(nums)
8        maxVal = max(nums)
9
10        if minVal == maxVal:
11            return 0
12        
13        # determine the size of the bucket
14        bucketSize = max(1, (maxVal - minVal) // (n - 1))
15        # determine the number of buckets
16        bucketCount = (maxVal - minVal) // bucketSize + 1
17
18        # create buckets
19        buckets = [[None, None] for _ in range(bucketCount)]
20
21        # fill buckets
22        for num in nums:
23            bucket = (num - minVal) // bucketSize
24
25            if buckets[bucket][0] is None:
26                buckets[bucket][0] = num
27                buckets[bucket][1] = num
28            
29            else:
30                buckets[bucket][0] = min(buckets[bucket][0], num)
31                buckets[bucket][1] = max(buckets[bucket][1], num)
32
33        # find max gap
34        prevMax = None
35        maxGap = 0
36
37        for currMin, currMax in buckets:
38            # don't check empty buckets
39            if currMin is None:
40                continue
41
42            if prevMax is not None:
43                maxGap = max(maxGap, currMin - prevMax)
44            prevMax = currMax
45        
46        return maxGap