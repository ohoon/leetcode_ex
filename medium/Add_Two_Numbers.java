/*
2.
Add Two Numbers
https://leetcode.com/problems/add-two-numbers/
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode answer = l3;
        int num1 = 0, num2 = 0, carry = 0, next = 0;
        while (true) {
            if (l1 != null) {       // l1값을 num1에 할당하고 다음 노드로
                num1 = l1.val;
                l1 = l1.next;
            } else {                // l1이 끝난 상태면 num1은 0
                num1 = 0;
            }
            
            if (l2 != null) {       // l2값을 num2에 할당하고 다음 노드로
                num2 = l2.val;
                l2 = l2.next;
            } else {                // l2이 끝난 상태면 num2은 0
                num2 = 0;
            }
            
            next = l3.val + num1 + num2;        // 올림수 + l1와 l2의 값
            l3.val = next % 10;                 // 올림수를 제외한 수
            carry = next / 10;                  // 올림수
            
            if (l1 != null || l2 != null || carry > 0) {        // 더할 것이 더 있으면 올림수를 가지는 노드 생성하여 다음 노드로 연결
                l3.next = new ListNode(carry);
                l3 = l3.next;
            } else {                                            // 더할 것이 없으면 반복문 종료
                break;
            }
        }
        
        return answer;
    }
}

/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Two Numbers.
Memory Usage: 39.5 MB, less than 37.76% of Java online submissions for Add Two Numbers.
*/
