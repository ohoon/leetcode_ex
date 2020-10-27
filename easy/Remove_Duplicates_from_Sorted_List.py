'''
83.
Remove Duplicates from Sorted List
https://leetcode.com/problems/remove-duplicates-from-sorted-list/
'''

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if not head:        # 비어있는 linked list이면 종료
            return head
        
        pre = head
        node = head.next
        
        while node:
            if node.val == pre.val:     # 전의 노드와 같은 값을 만나면 다음 노드로 건너띔
                node = node.next
                continue
            
            pre.next = node     # 다른 값을 만나면 pre의 next를 이 노드로 지정하고, pre값을 갱신
            pre = pre.next
            node = node.next
        
        pre.next = None     # 노드 순환이 끝나면 pre의 next를 노드의 끝으로 지정
        
        return head

'''
Runtime: 28 ms, faster than 99.71% of Python3 online submissions for Remove Duplicates from Sorted List.
Memory Usage: 14.1 MB, less than 100.00% of Python3 online submissions for Remove Duplicates from Sorted List.
'''