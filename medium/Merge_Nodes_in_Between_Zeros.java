/*
2181.
Merge Nodes in Between Zeros
https://leetcode.com/problems/merge-nodes-in-between-zeros/
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
    public ListNode mergeNodes(ListNode head) {
        ListNode node = head;       // curr의 val 값을 누적시킬 node
        ListNode curr = node.next;
        while (curr.next != null) {
            if (curr.val == 0) {    // val 값이 0이면 node 갱신
                node.next = curr;
                node = curr;
            } else {                // 그 외에는 node.val 누적
                node.val += curr.val;
            }
            
            curr = curr.next;
        }
        
        node.next = null;
        return head;
    }
}

/*
Runtime: 8 ms, faster than 85.56% of Java online submissions for Merge Nodes in Between Zeros.
Memory Usage: 270.3 MB, less than 73.02% of Java online submissions for Merge Nodes in Between Zeros.
*/
