'''
225.
Implement Stack using Queues
https://leetcode.com/problems/implement-stack-using-queues/
'''

from collections import deque

class MyStack:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.q = deque()

    def push(self, x: int) -> None:
        """
        Push element x onto stack.
        """
        self.q.append(x)

    def pop(self) -> int:
        """
        Removes the element on top of the stack and returns that element.
        """
        sub = deque()
        while len(self.q) > 1:      # 마지막 요소가 남을 때까지 popleft해서 sub에 쌓음
            sub.append(self.q.popleft())
        
        last = self.q.popleft()     # 마지막 요소는 변수에 저장했다가 나중에 반환할 때 사용
        self.q = sub                # sub에 있는 나머지 요소들을 그대로 q에 복구
        
        return last
    
    def top(self) -> int:
        """
        Get the top element.
        """
        return self.q[-1]

    def empty(self) -> bool:
        """
        Returns whether the stack is empty.
        """
        return not self.q

'''
Runtime: 28 ms, faster than 76.36% of Python3 online submissions for Implement Stack using Queues.
Memory Usage: 14.1 MB, less than 30.22% of Python3 online submissions for Implement Stack using Queues.
'''