/*
1669.
Merge In Between Linked Lists
https://leetcode.com/problems/merge-in-between-linked-lists/
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode list2Rear = list2;             // list2의 마지막 노드
        while (list2Rear.next != null) {
            list2Rear = list2Rear.next;
        }
        
        ListNode start = null, end = null;          // merge할 부분의 앞, 뒤 노드
        ListNode curr = list1;
        while (curr != null) {
            if (--a == 0) {         // start의 경우, a-1번째 노드
                start = curr;
            }
            
            if (b-- == 0) {         // end의 경우, b번째 노드
                end = curr.next;
            }
            
            curr = curr.next;
        }
        
        list2Rear.next = end;
        if (start == null) {        // list1의 처음부터 merge되는 경우
            return list2;
        }
        
        start.next = list2;         // 중간에 merge되는 경우
        return list1;
    }
}

/*
Runtime: 2 ms, faster than 86.58% of Java online submissions for Merge In Between Linked Lists.
Memory Usage: 108.9 MB, less than 17.98% of Java online submissions for Merge In Between Linked Lists.
*/
