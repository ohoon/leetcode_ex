'''
160.
Intersection of Two Linked Lists
https://leetcode.com/problems/intersection-of-two-linked-lists/
'''

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        hash_map = {}
        while headA or headB:
            if headA:
                if headA in hash_map:
                    return headA
                
                hash_map[headA] = 'A'
                headA = headA.next
            
            if headB:
                if headB in hash_map:
                    return headB
                
                hash_map[headB] = 'B'
                headB = headB.next
        
        return None

'''
Runtime: 164 ms, faster than 68.40% of Python3 online submissions for Intersection of Two Linked Lists.
Memory Usage: 29.8 MB, less than 12.23% of Python3 online submissions for Intersection of Two Linked Lists.
'''

'''
최적 풀이

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if not(headA and headB):
            return None
        
        pA = headA
        pB = headB
        while pA or pB:
            if pA == pB:
                return pA
            
            pA = pA.next if pA else headB
            pB = pB.next if pB else headA
        
        return None

해시맵을 이용한 풀이의 시간복잡도는 O(m+n)으로 O(N)이지만 메모리 공간을 O(N)을 사용한다.
문제의 follow up이 시간복잡도는 O(N), 메모리 공간을 O(1) 사용하는 방법을 풀이해라.. 라고 되어 있어서
저번에 연결리스트의 cycle을 찾는 문제에서 포인터 2개를 이용해 O(1)의 메모리 공간을 사용해서 풀이하는 방법이 생각났다.
그래서 이리저리 생각해봤지만 잘 떠오르지 않았다. 그래서 솔루션을 보고 배우기로 했음
풀이 방식은 두 연결리스트 중에 길이가 짧은 연결리스트가 먼저 끝이 날건데, 끝이 나면 다른 연결리스트로 옮겨가게 만든다.
그렇게 되면 길이가 긴 연결리스트가 끝이 날때, 짧은 연결리스트 포인터가 참조하는 부분은 두 연결리스트의 길이 차이만큼 전진해있을 것이다.
그 상태에서 긴 연결리스트 포인터도 마찬가지로 짧은 연결리스트로 옮긴다. 그리고 쭉 전진하다보면 두 연결리스트의 포인터는 동시에 끝마치게 된다.
동시에 끝마친다는 것은 두 연결리스트가 나란히 줄맞추어 전진한다는 것이고, 두 포인터가 가리키는 노드값을 비교하면서 전진하면 교차 노드를 찾을 수 있게 된다.

'''