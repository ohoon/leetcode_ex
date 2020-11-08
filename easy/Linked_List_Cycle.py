'''
141.
Linked List Cycle
https://leetcode.com/problems/linked-list-cycle/
'''

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        node = head
        hash_map = {}
        while node:
            if node in hash_map:
                return True
            
            hash_map[node] = node.val
            node = node.next
        
        return False

'''
Runtime: 36 ms, faster than 99.36% of Python3 online submissions for Linked List Cycle.
Memory Usage: 17.2 MB, less than 99.27% of Python3 online submissions for Linked List Cycle.
'''

'''
최적 풀이

class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        if not head:
            return False
        
        slow = head
        fast = head.next
        while slow != fast:
            if not fast or not fast.next:
                return False
            
            slow = slow.next
            fast = fast.next.next
        
        return True

Follow up을 보면 O(1) 메모리 공간을 사용하는 알고리즘을 짜라고 되어있었다.
하지만 Single Number 문제와 마찬가지로 묘수가 떠오르지 않아서 딕셔너리로 풀었다..ㅠㅠ
위의 코드는 포인터를 2개를 두고 한번에 이동하는 횟수를 다르게 하여서 두 포인터가 같은 노드를 가리키고 있으면 cycle이라고 판단하는 풀이다.

'''