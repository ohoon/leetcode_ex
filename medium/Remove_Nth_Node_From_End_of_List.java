/*
19.
Remove Nth Node From End of List
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head, second = head, prev = null;
        for (int i = n; i > 0; i--) {       // n만큼 first 포인터를 먼저 이동시킴
            first = first.next;
        }
        
        while (first != null) {             // 그 다음 first와 second 포인터를 동시에 이동시키는 것으로 뒤에서 n만큼 떨어진 노드를 찾을 수 있게 됨
            first = first.next;
            prev = second;
            second = second.next;
        }
        
        if (prev != null) {                 // second가 head포인터가 아닐 경우, second 노드를 삭제
            prev.next = second.next;
            second.next = null;
        } else {                            // head포인터에 위치하는 경우엔 head 포인터만 변경
            head = second.next;
        }
        
        return head;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
Memory Usage: 36.9 MB, less than 72.50% of Java online submissions for Remove Nth Node From End of List.
*/
