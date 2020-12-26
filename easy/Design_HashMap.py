'''
706.
Design HashMap
https://leetcode.com/problems/design-hashmap/
'''

class ListNode:                         # key와 value를 가지는 연결리스트
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None
        
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.MAX_SIZE = 1000
        self.storage = [None] * self.MAX_SIZE               # 해싱값을 인덱스로 가지는 저장공간

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        idx = key % self.MAX_SIZE
        node = self.storage[idx]
        if not node:                                    # 비어있는 공간에는 연결리스트를 그냥 대입
            self.storage[idx] = ListNode(key, value)
            return
        
        while True:
            if node.key == key:                         # 이미 key값이 저장되어있으면 기존 value값을 덮어씀
                node.value = value
                return
            
            if not node.next:
                break
                
            node = node.next
        
        node.next = ListNode(key, value)                # key값이 없으면 연결리스트 끝에 새로 ListNode를 추가

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        idx = key % self.MAX_SIZE
        node = self.storage[idx]
        while True:
            if not node:
                return -1
            
            if node.key == key:
                return node.value
                
            node = node.next

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        idx = key % self.MAX_SIZE
        node = prev = self.storage[idx]             # prev -> node -> node.next로 전개할 예정
        if not node:
            return
        
        if node.key == key:                         # 가장 첫 요소가 지워야할 key값을 가지는 경우
            self.storage[idx] = node.next
            return
        
        node = node.next
        while True:
            if not node:
                return
            
            if node.key == key:                     # prev -> node.next로 node를 제거
                prev.next = node.next
                return
            
            prev = node
            node = node.next

'''
Runtime: 264 ms, faster than 40.04% of Python3 online submissions for Design HashMap.
Memory Usage: 17.4 MB, less than 59.93% of Python3 online submissions for Design HashMap.
'''

'''
여담

연결리스트를 사용해서 풀이하려고 했는데, 자꾸 한 테스트케이스에서 시간초과가 떠서 뭐가 문제일까 생각하다가
remove하는 작업 중에 node.next = node.next.next 처럼 .next를 여러번 체이닝하는 과정이 시간을 생각보다 많이 잡아먹는다는 것을 깨달았다.
그래서 prev 변수를 하나 만들어서 chaining 횟수를 줄이니까 성공적으로 테스트케이스를 통과하였다.
많이 어려웠던 문제였다.

'''