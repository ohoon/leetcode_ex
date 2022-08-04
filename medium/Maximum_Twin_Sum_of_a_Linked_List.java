/*
2130.
Maximum Twin Sum of a Linked List
https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
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
    public int pairSum(ListNode head) {
        Deque<Integer> deq = new LinkedList<>();        // 자료구조를 linkedlist -> deque으로 변환하기 위함
        while (head != null) {
            deq.addLast(head.val);
            head = head.next;
        }
        
        int answer = 0;
        while (!deq.isEmpty()) {
            answer = Math.max(answer, deq.removeFirst() + deq.removeLast());        // front, rear에서 하나씩 꺼내서 twin
        }
        
        return answer;
    }
}

/*
Runtime: 46 ms, faster than 20.38% of Java online submissions for Maximum Twin Sum of a Linked List.
Memory Usage: 115.4 MB, less than 49.11% of Java online submissions for Maximum Twin Sum of a Linked List.
*/
