/*
445.
Add Two Numbers II
https://leetcode.com/problems/add-two-numbers-ii/
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
    private ListNode reverse(ListNode head) {       // 연결리스트를 뒤집는 메서드
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            if (next == null) {
                break;
            }
            
            head = next;
        }

        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode reverseL1 = reverse(l1);       // l1, l2를 뒤집은 후에 차례대로 더함
        ListNode reverseL2 = reverse(l2);
        ListNode cur = head;
        int sum = 0;
        while (sum != 0 || reverseL1 != null || reverseL2 != null) {
            if (reverseL1 != null) {
                sum += reverseL1.val;
                reverseL1 = reverseL1.next;
            }

            if (reverseL2 != null) {
                sum += reverseL2.val;
                reverseL2 = reverseL2.next;
            }

            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            sum /= 10;      // carry를 남기기 위함
        }

        return reverse(head.next);      // head는 빈 노드이므로 그 다음 노드부터만 취급
    }
}
