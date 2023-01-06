/*
2058.
Find the Minimum and Maximum Number of Nodes Between Critical Points
https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
*/

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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] answer = {Integer.MAX_VALUE, -1};
        ListNode node = head;
        int first = -1, last = -1, prev = -1, cur = 0;
        while (node.next.next != null) {
            if ((node.val < node.next.val && node.next.val > node.next.next.val) ||
             (node.val > node.next.val && node.next.val < node.next.next.val)) {
                if (prev > -1) {
                    answer[0] = Math.min(answer[0], cur - prev);
                } else {
                    first = cur;
                }

                prev = cur;
                last = cur;
            }

            cur++;
            node = node.next;
        }

        answer[0] = answer[0] == Integer.MAX_VALUE ? -1 : answer[0];
        answer[1] = first == last ? -1 : last - first;
        return answer;
    }
}
