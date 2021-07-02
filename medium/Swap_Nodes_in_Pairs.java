/*
24.
Swap Nodes in Pairs
https://leetcode.com/problems/swap-nodes-in-pairs/
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
    public ListNode swapPairs(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null && cur.next != null) {
            ListNode temp = cur.next;       // 앞으로 가져올 2번 노드를 임시 변수에 저장
            cur.next = temp.next;           // 1번 노드 next를 3번 노드로 지정  (1) -> (3), (2) -> (3)
            temp.next = cur;                // 2번 노드를 1번 노드 앞으로 이동    (2) -> (1) -> (3)
            if (prev != null) {             // 이전 노드가 존재하면 2번 노드에 연결    (...) -> (2) -> (1) -> (3)
                prev.next = temp;
            } else {                        // 해당 노드가 head에 위치한 노드라면 head 재지정 (head)(2) -> (1) -> (3)
                head = temp;
            }
            
            prev = cur;
            cur = cur.next;
        }
        return head;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
Memory Usage: 36.5 MB, less than 75.34% of Java online submissions for Swap Nodes in Pairs.
*/
