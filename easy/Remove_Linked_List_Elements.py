'''
203.
Remove Linked List Elements
https://leetcode.com/problems/remove-linked-list-elements/
'''

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        node = head
        prev_node = None
        while node:
            if node.val == val:
                if node == head:		# head 노드면 다음 노드를 head 노드로 지정하고 이동
                    head = node.next
                    node = node.next
                    continue

                prev_node.next = node.next		# 이전 노드의 next를 다음 노드로 지정하고 이동
                node = node.next
                continue
            
            prev_node = node		# 현재 노드를 이전 노드로 지정하고 이동
            node = node.next
        
        return head

'''
Runtime: 64 ms, faster than 88.54% of Python3 online submissions for Remove Linked List Elements.
Memory Usage: 16.9 MB, less than 65.32% of Python3 online submissions for Remove Linked List Elements.
'''