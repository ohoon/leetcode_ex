'''
237.
Delete Node in a Linked List
https://leetcode.com/problems/delete-node-in-a-linked-list/
'''

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        node.val = node.next.val    # 다음 노드의 val값 가져옴
        node.next = node.next.next  # 다음 노드를 생략

'''
Runtime: 32 ms, faster than 94.72% of Python3 online submissions for Delete Node in a Linked List.
Memory Usage: 14.4 MB, less than 16.42% of Python3 online submissions for Delete Node in a Linked List.
'''