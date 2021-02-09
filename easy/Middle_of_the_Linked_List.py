'''
876.
Middle of the Linked List
https://leetcode.com/problems/middle-of-the-linked-list/
'''

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def middleNode(self, head: ListNode) -> ListNode:
        fast, slow = head, head             # fast: 2칸씩, slow: 1칸씩
        while slow.next and fast.next:
            slow = slow.next
            fast = fast.next
            
            if fast.next:                   # 한칸 더 이동, 불가능하면 break
                fast = fast.next
            else:
                break
            
        return slow                         # fast가 도착할 때에 slow는 중간에 위치할 것임

'''
Runtime: 28 ms, faster than 84.46% of Python3 online submissions for Middle of the Linked List.
Memory Usage: 14.2 MB, less than 77.07% of Python3 online submissions for Middle of the Linked List.
'''