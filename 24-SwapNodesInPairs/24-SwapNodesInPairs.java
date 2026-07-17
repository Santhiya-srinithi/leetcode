// Last updated: 7/17/2026, 3:05:44 PM
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {

        // Dummy node helps handle swapping from the first node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode previous = dummy;

        while (previous.next != null &&
               previous.next.next != null) {

            ListNode first = previous.next;
            ListNode second = first.next;

            // Swap the two nodes
            first.next = second.next;
            second.next = first;
            previous.next = second;

            // Move to the next pair
            previous = first;
        }

        return dummy.next;
    }
}