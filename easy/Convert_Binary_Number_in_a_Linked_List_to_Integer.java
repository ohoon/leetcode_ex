/*
1290.
Convert Binary Number in a Linked List to Integer
https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
*/

 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public int getDecimalValue(ListNode head) {
        int res = 0;

        while (head != null) {
            res *= 2;           // left shift
            res += head.val;    // 맨 끝 비트에 현재 값을 삽입
            head = head.next;
        }

        return res;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
Memory Usage: 36.3 MB, less than 78.94% of Java online submissions for Convert Binary Number in a Linked List to Integer.
*/