/*
2074.
Reverse Nodes in Even Length Groups
https://leetcode.com/problems/reverse-nodes-in-even-length-groups/
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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        Deque<ListNode> deq = new LinkedList<>();
        ListNode front = new ListNode(-1, head);        // front.next = 그룹이 시작되는 node
        ListNode cur = front;
        int group = 1;          // 그룹 크기
        while (cur.next != null) {
            int groupSize = 0;  // 실제 그룹 크기
            for (int i = 0; i < group; i++) {       // 그룹 크기만큼 deque에 node를 삽입
                if (cur.next == null) {
                    break;
                }

                deq.addLast(cur.next);
                cur = cur.next;
                groupSize++;
            }

            group++;
            if (groupSize % 2 == 0) {           // 그룹이 짝수면 reverse
                ListNode next = cur.next;
                for (int i = 0; i < groupSize; i++) {
                    front.next = deq.removeLast();
                    front = front.next;
                }

                front.next = next;
                cur = front;
            } else {
                front = cur;
            }
        }

        return head;
    }
}
