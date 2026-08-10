// Last updated: 8/10/2026, 9:09:59 PM
1class Solution {
2    public ListNode deleteDuplicates(ListNode head) {
3        if (head == null || head.next == null) return head;
4
5        ListNode dummy = new ListNode(-1); // Dummy node to handle head removals
6        dummy.next = head;
7        ListNode prev = dummy;
8        ListNode cur = head;
9
10        while (cur != null && cur.next != null) {
11            if (cur.val == cur.next.val) {
12                // Skip all nodes with the same value
13                while (cur.next != null && cur.val == cur.next.val) {
14                    cur = cur.next;
15                }
16                prev.next = cur.next; // Remove duplicates
17            } else {
18                prev = prev.next; // Move to next distinct node
19            }
20            cur = cur.next;
21        }
22
23        return dummy.next;
24    }
25}