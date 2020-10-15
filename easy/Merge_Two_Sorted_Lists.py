'''
21.
Merge Two Sorted Lists
https://leetcode.com/problems/merge-two-sorted-lists/
'''

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if (l1 and l2):
            firstNode = l1 if l1.val <= l2.val else l2
            
            while (l1):
                # l1의 값 <= l2의 값
                if (l1.val <= l2.val):
                    if (not l1.next):       # l1가 마지막 노드라면 다음 노드로 나머지 l2를 연결하고 종료
                        l1.next = l2
                        break
                        
                    if (l1.next.val > l2.val):      # l1의 다음 노드값이 l2의 노드값보다 크면 l1 -> l2 -> l1.next(다음 순환에서 처리)
                        nextNode = l1.next
                        l1.next = l2
                        l1 = nextNode
                        continue
                        
                    l1 = l1.next        # l1의 다음 노드값이 l2의 노드값 이하면 l1 -> l1.next -> ... -> l2이므로 다음 순환으로
                        
                # l1의 값 > l2의 값
                else:
                    if (not l2.next):       # l2가 마지막 노드라면 다음 노드로 나머지 l1를 연결하고 종료
                        l2.next = l1
                        break
                        
                    if (l1.val <= l2.next.val):     # l2의 다음 노드값이 l1의 노드값보다 크면 l2 -> l1 -> l2.next(다음 순환에서 처리)
                        nextNode = l2.next
                        l2.next = l1
                        l2 = nextNode
                        continue
                        
                    l2 = l2.next        # l2의 다음 노드값이 l1의 노드값 이하면 l2 -> l2.next -> ... -> l1이므로 다음 순환으로
                    
            return firstNode
                
        return (l1 or l2) if l1 or l2 else ListNode('')
        

'''
Runtime: 32 ms, faster than 92.60% of Python3 online submissions for Merge Two Sorted Lists.
Memory Usage: 14.2 MB, less than 99.99% of Python3 online submissions for Merge Two Sorted Lists.
'''

'''
다른 사람의 풀이

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if (not l1) or (l2 and (l1.val > l2.val)):
            l1, l2 = l2, l1
        
        if l1:
            l1.next = self.mergeTwoLists(l1.next, l2)
        
        return l1

풀긴 풀었지만 시간은 1~2시간 걸렸다.
링크드 리스트를 다루는 건 오랜만이라 머리가 많이 아팠음
좀 더 이해하기 쉽게 코드를 짤 수 있었음 좋겠지만
속도는 잘 나와서 만족한다.
뒤늦게 어떤 사람의 코드를 봤는데
와.. 너무 허무하다.
재귀법을 쓰면 이렇게 코드가 간단해지구나 놀랍다.
이 간단한 코드의 작동 과정을 이해하는 것도 만만치가 않다...ㅠㅠㅠ

'''