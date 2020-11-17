'''
234.
Palindrome Linked List
https://leetcode.com/problems/palindrome-linked-list/
'''

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if not head:
            return True
        
        node = head
        length = 1
        while node.next:
            node.next.prev = node       # 이전 노드의 주소를 갖는 prev 속성 추가
            node = node.next
            length += 1
            
        tail = node     # next가 None타입인 마지막 노드 tail
        for _ in range(length // 2):        # 연결리스트를 절반으로 나누어 head와 tail로 서로 비교
            if head.val != tail.val:
                return False
            
            head = head.next
            tail = tail.prev
            
        return True

'''
Runtime: 76 ms, faster than 31.53% of Python3 online submissions for Palindrome Linked List.
Memory Usage: 24 MB, less than 86.27% of Python3 online submissions for Palindrome Linked List.
'''

'''
다른 사람의 풀이

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if not head or not head.next:
            return True

        slow = fast = head
        reversed_list = None

        # reverse left half of the list while searching
        # the start point of the right half
        while fast is not None and fast.next is not None:
            tmp = slow

            # keep moving guys
            slow = slow.next
            fast = fast.next.next

            # place node at the start of the reversed half
            tmp.next = reversed_list
            reversed_list = tmp

        # if there are even number of elements in the list
        # do one more step to reach the first element of
        # the second list's half
        if fast is not None:
            slow = slow.next

        # compare reversed left half with the original
        # right half
        while reversed_list is not None and reversed_list.val == slow.val:
            reversed_list = reversed_list.next
            slow = slow.next

        return reversed_list is None

나의 풀이는 O(N)의 시간복잡도와 O(1)의 공간복잡도를 만족하는 것 같지만, 엄밀히 따지면 O(1.5*N)의 시간복잡도를 가지고 있고
ListNode에 prev 속성을 추가해서 풀었기 때문에 깔끔하게 풀이했다고 생각하지 않는다.
따라서 위의 풀이처럼 한 번에 한 칸씩 이동하는 slow 포인터와 두 칸씩 이동하는 fast 포인터를 이용해서 연결리스트의 가운데 점을 찾는 로직이 더 좋은 코드라고 생각된다.

'''