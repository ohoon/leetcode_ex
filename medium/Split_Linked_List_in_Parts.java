/*
725.
Split Linked List in Parts
https://leetcode.com/problems/split-linked-list-in-parts/
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode node = head;
        int len = 0;
        while (node != null) {      // 연결리스트의 전체 길이 계산
            node = node.next;
            len++;
        }
        
        ListNode[] answer = new ListNode[k];
        int base = len / k;         // 기본적으로 배열에 동등하게 나눠줘야 할 노드 개수
        int remained = len % k;     // 전체 길이를 k로 나눈 나머지로, 배열 앞부터 차례대로 하나씩 넣어줘야 함
        for (int i = 0; i < k; i++) {
            answer[i] = head;
            for (int j = 0; j < base-1; j++) {      // 현재 head 노드에서 base-1만큼 포인터 이동, 부분 리스트의 가장 끝 노드로 포인터가 이동됨
                head = head.next;
            }
            
            if (base > 0 && remained > 0) {         // 나머지가 존재하면 한칸 더 이동
                head = head.next;
                remained--;
            }
            
            if (head == null) {         // 전체 연결 리스트의 끝에 도달하면 종료
                break;
            }
            
            ListNode nextHead = head.next;      // 끝 노드에서 연결을 끊어버리고 다음 head 노드로 포인터 이동
            head.next = null;
            head = nextHead;
        }
        
        return answer;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Split Linked List in Parts.
Memory Usage: 44.4 MB, less than 24.77% of Java online submissions for Split Linked List in Parts.
*/
