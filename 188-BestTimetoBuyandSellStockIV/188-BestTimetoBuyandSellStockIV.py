# Last updated: 9/22/2026, 10:10:28 AM
1class DoubleLinkListNode:
2    def __init__(self, ind, pre = None, next = None):
3        self.ind = ind
4        self.pre = pre if pre else self
5        self.next = next if next else self
6
7class Solution:
8    def MinMaxList(self, arr: List[int]) -> List[int]:
9        n = len(arr)
10        if n == 0:
11            return []
12        sign = -1
13        res = [9999]
14        for num in arr:
15            if num * sign > res[-1] * sign:
16                res[-1] = num
17            else:
18                res.append(num)
19                sign *= -1
20        if len(res) & 1:
21            res.pop()
22        return res
23    def maxProfit(self, k: int, prices: List[int]) -> int:
24        newP = self.MinMaxList(prices)
25        n = len(newP)
26        m = n // 2
27        res = 0
28        for i in range(m):
29            res += newP[i*2+1] - newP[i*2]
30        if m <= k:
31            return res
32        head, tail = DoubleLinkListNode(-1), DoubleLinkListNode(-1)
33        NodeList = [DoubleLinkListNode(0, head)]
34        for i in range(1, n):
35            NodeList.append(DoubleLinkListNode(i, NodeList[-1]))
36            NodeList[i-1].next = NodeList[i]
37        NodeList[n-1].next = tail
38        head.next, tail.pre = NodeList[0], NodeList[n-1]
39        heap = []
40        for i in range(n-1):
41            if i&1:
42                heappush(heap, [newP[i] - newP[i+1], i, i+1, 0])
43            else:
44                heappush(heap, [newP[i+1] - newP[i], i, i+1, 1])
45        while m > k:
46            loss, i, j, t = heappop(heap)
47            if NodeList[i] == None or NodeList[j] == None: continue
48            m -= 1
49            res -= loss
50            nodei, nodej = NodeList[i], NodeList[j]
51            nodel, noder = nodei.pre, nodej.next
52            l, r = nodel.ind, noder.ind
53            valL, valR = newP[l], newP[r]
54            noder.pre, nodel.next = nodel, noder
55            NodeList[i], NodeList[j] = None, None
56            if t == 0:
57                heappush(heap, [valR - valL, l, r, 1])
58            elif l != -1 and r != -1:
59                heappush(heap, [valL - valR, l, r, 0])
60        return res