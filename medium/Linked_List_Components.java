/*
817.
Linked List Components
https://leetcode.com/problems/linked-list-components/
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
    public int numComponents(ListNode head, int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();     // nums 데이터를 set로 이동
        for (int num : nums) {
            set.add(num);
        }

        while (head != null) {
            int val = head.val;     // 현재 head가 가리키는 val값 백업
            head= head.next;        // head 포인터 이동
            if (!set.contains(val)) {       // nums에 없는 값이면 그대로 다음 포인터로 이동
                continue;
            }
            
            answer++;
            while (head != null) {      // nums에 있는 값이면 component가 끝날때까지 탐색 반복
                val = head.val;
                head = head.next;
                if (!set.contains(val)) {
                    break;
                }
            }
        }

        return answer;
    }
}
