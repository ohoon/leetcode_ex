'''
206.
Reverse Linked List
https://leetcode.com/problems/reverse-linked-list/
'''

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        node = head
        prev_node = None
        while node:
            if not node.next:       # 마지막 노드는 첫번째 노드로
                head = node
                
            next_node = node.next   # 다음에 참조할 노드
            node.next = prev_node   # 현재 노드의 next를 이전 노드로
            prev_node = node        # 현재 노드를 이전 노드로 저장
            node = next_node        # 다음 노드로 이동
            
        return head

'''
Runtime: 32 ms, faster than 86.14% of Python3 online submissions for Reverse Linked List.
Memory Usage: 18.7 MB, less than 18.56% of Python3 online submissions for Reverse Linked List.
'''

'''
재귀적 풀이

class Solution:
    def reverse(self, node: ListNode):
        last = node
        if node.next:
            backtrack = self.reverse(node.next)
            backtrack[0].next = node
            last = backtrack[1]
        
        return [node, last]
    
    def reverseList(self, head: ListNode) -> ListNode:
        if not head:
            return head
        
        result = self.reverse(head)
        result[0].next = None
        
        return result[1]

반복법으로 풀이하는 방법은 금방 나왔고
문제는 재귀적 풀이법인데.. 이것도 reverse하는 것은 쉬운데 head 포인터를 옮기는 것이 문제가 됐다.
그래서 따로 reverse라는 함수를 만들어서 이 함수를 재귀적으로 불러서 reverse시키면서 마지막 노드의 주소도 같이 반환하도록 했음
모든 노드가 reverse되면 head 노드를 마지막 노드로 바꿔주면 끝

'''