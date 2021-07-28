/*
61.
Rotate List
https://leetcode.com/problems/rotate-list/
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        
        ListNode first = head, second = head;
        k = k % getSize(head);                  // 연결리스트의 길이로 나머지를 구하여 중복되는 cycle 생략
        
        if (k == 0) {                           // 이동할 필요가 없으면 그대로 head 반환
            return head;
        }
        
        for (int i = 0; i < k; i++) {           // k만큼 first 포인터 이동
            first = first.next;
        }
        
        while (first != null) {                 // first와 second를 동시에 이동시켜서 추후에 head 포인터가 될 위치를 구함
            if (first.next == null) {           // first가 null이 되기 전 단계에서 second의 next를 null로 바꿔줌
                first = first.next;
                ListNode temp = second.next;
                second.next = null;
                second = temp;
            } else {
                first = first.next;
                second = second.next;
            }
        }
        
        ListNode newHead = second;
        while (second.next != null) {           // second를 연결리스트 끝으로 이동
            second = second.next;
        }
        
        second.next = head;                     // 연결리스트 끝부분을 예전 head에 이어줌
        return newHead;
    }
    
    private int getSize(ListNode head) {        // 연결리스트 길이를 구하는 함수
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        
        return size;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate List.
Memory Usage: 38.4 MB, less than 64.66% of Java online submissions for Rotate List.
*/
