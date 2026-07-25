// Last updated: 7/25/2026, 11:17:05 AM
1class Solution {
2    public int[] maxSlidingWindow(int[] nums, int k) {
3        Deque<Integer> q = new ArrayDeque<>();  // stores *indices*
4        List<Integer> res = new ArrayList<>();
5        for (int i = 0; i < nums.length; i++) {
6            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
7                q.removeLast();
8            }
9            q.addLast(i);
10            // remove first element if it's outside the window
11            if (q.getFirst() == i - k) {
12                q.removeFirst();
13            }
14            // if window has k elements add to results (first k-1 windows have < k elements because we start from empty window and add 1 element each iteration)
15            if (i >= k - 1) {
16                res.add(nums[q.peek()]);
17            }
18        }
19        return res.stream().mapToInt(i->i).toArray();            
20    }
21}