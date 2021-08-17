/*
143.
Reorder List
https://leetcode.com/problems/reorder-list/
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
public class Solution {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        // step 1. cut the list to two halves
        // prev will be the tail of 1st half
        // slow will be the head of 2nd half
        ListNode prev = null, slow = head, fast = head, l1 = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // step 2. reverse the 2nd half
        ListNode l2 = reverse(slow);

        // step 3. merge the two halves
        merge(l1, l2);
    }

    ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    void merge(ListNode l1, ListNode l2) {
        while (head2 != null) {
            ListNode next = head1.next;
            head1.next = head2;
            head1 = head2;
            head2 = next;
        }
    }

}

/*
Runtime: 1 ms, faster than 99.92% of Java online submissions for Reorder List.
Memory Usage: 41.7 MB, less than 53.82% of Java online submissions for Reorder List.
*/

/*
여담

처음에는 deque로 풀이를 하려고 시도를 해봤는데, 시간 초과로 테스트케이스를 통과하지 못했다.
다른 방법이 무엇이 있나 곰곰히 한참 생각해도 감이 잘 안잡혀서 풀이를 보고 익히기로 했음
원리는 전체 연결리스트를 반으로 쪼갠 다음에 하나의 서브 연결리스트를 역순으로 만든다.
그리고 나서 두 리스트를 다시 합병정렬처럼 합치면 문제의 답에 도달하게 되는 원리다.

*/
