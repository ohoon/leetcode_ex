/*
1019.
Next Greater Node In Linked List
https://leetcode.com/problems/next-greater-node-in-linked-list/
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
    private int getSize(ListNode head) {        // 연결리스트의 길이를 반환하는 메서드
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        
        return size;
    }
    
    public int[] nextLargerNodes(ListNode head) {       // stack
        int n = getSize(head);
        int[] answer = new int[n];
        Deque<int[]> deq = new LinkedList<>();      // stack 용도로 사용하는 deque
        ListNode curr = head;
        for (int i = 0; i < n; i++) {
            while (!deq.isEmpty() && deq.peekLast()[1] < curr.val) {        // 현재 노드의 값보다 작은 노드들은 deq에서 pop해서 answer에 기록
                answer[deq.removeLast()[0]] = curr.val;
            }
            
            deq.addLast(new int[]{i, curr.val});    // 현재 인덱스와 함께 deq에 등록
            curr = curr.next;
        }
        
        return answer;
    }
}

/*
Runtime: 18 ms, faster than 95.06% of Java online submissions for Next Greater Node In Linked List.
Memory Usage: 73.3 MB, less than 27.68% of Java online submissions for Next Greater Node In Linked List.
*/
