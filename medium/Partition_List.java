/*
86.
Partition List
https://leetcode.com/problems/partition-list/
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
    public ListNode partition(ListNode head, int x) {
        ListNode p = head;
        ListNode headA = new ListNode(), headB = new ListNode();        // 첫 노드 처리를 위한 dummy 노드
        ListNode curA = headA, curB = headB;
        while (p != null) {
            if (p.val < x) {                // x보다 작은 노드는 headA 연결리스트에 속하도록
                curA.next = p;
                curA = curA.next;
            } else {                        // x 이상 노드는 headB 연결리스트에 속하도록
                curB.next = p;
                curB = curB.next;
            }
            
            p = p.next;
        }
        
        curA.next = headB.next;             // headA 연결리스트 끝은 headB 연결리스트 처음과 연결
        curB.next = null;
        return headA.next;                  // 더미노드는 생략
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Partition List.
Memory Usage: 38.3 MB, less than 64.57% of Java online submissions for Partition List.
*/
