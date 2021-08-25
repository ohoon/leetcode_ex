/*
328.
Odd Even Linked List
https://leetcode.com/problems/odd-even-linked-list/
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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode();
        ListNode evenHead = new ListNode();
        ListNode odd = oddHead;
        ListNode even = evenHead;
        ListNode curr = head;
        boolean isOdd = true;
        while (curr != null) {
            if (isOdd) {        // 홀수번째 노드일 경우
                odd.next = curr;
                odd = odd.next;
            } else {            // 짝수번째 노드일 경우
                even.next = curr;
                even = even.next;
            }
            
            isOdd = !isOdd;
            curr = curr.next;
        }
        
        odd.next = evenHead.next;       // 홀수->짝수 순으로 병합
        even.next = null;
        return oddHead.next;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Odd Even Linked List.
Memory Usage: 38.6 MB, less than 57.86% of Java online submissions for Odd Even Linked List.
*/
