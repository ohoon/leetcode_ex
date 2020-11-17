'''
232.
Implement Queue using Stacks
https://leetcode.com/problems/implement-queue-using-stacks/
'''

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        temp = []
        while self.stack:
            temp.append(self.stack.pop())
        
        temp.append(x)
        while temp:
            self.stack.append(temp.pop())

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        return self.stack.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        return self.stack[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return not self.stack

'''
Runtime: 20 ms, faster than 98.40% of Python3 online submissions for Implement Queue using Stacks.
Memory Usage: 14.3 MB, less than 6.18% of Python3 online submissions for Implement Queue using Stacks.
'''

'''
여담

큐로 스택 구조를 구현하는 문제의 풀이와 다르게 pop 함수를 살리고 push하는 로직을 바꿔보기로 했음
큐에 아이템이 배열의 앞부분에서 삽입되도록 만들면 구현이 된다.
따라서 현재 아이템들을 모두 pop해서 다른 스택에 append하는 것으로 아이템들을 역순으로 저장해놓고 거기다가 새로운 아이템 x를 넣음
그 다음 다시 모두 pop하여 원래 스택으로 append하면 새로운 아이템 x가 배열의 가장 첫 부분, 0 인덱스에 있게 된다.

'''